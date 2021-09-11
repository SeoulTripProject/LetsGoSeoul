package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import com.sist.dao.*;
import com.sist.vo.MemberVO;
import com.sist.vo.ZipcodeVO;
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static MemberDAO dao; 

	public void getConnection()
	{
		try
		{
			Context init=new InitialContext();
			Context c=(Context)init.lookup("java://comp//env");
			DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void disConnection()
	{
		try
		{
			if(ps==null) ps.close();
			if(conn==null) conn.close();
		}catch(Exception ex) {}
	}
	
	//싱글턴
	public static MemberDAO newInstance()
	{
		if(dao==null) // 미생성시에는
			dao=new MemberDAO();
		return dao; // 이미 만들어진 dao객체를 사용한다
	}
	
	// 회원 기능 1. 아이디 중복 체크
	public int memberidCheck(String id)
	{
		int count=0;
		try
		{
			getConnection();
			String sql="SELECT COUNT(*) FROM project_member "
					+ "WHERE id=?";
			// count=0 : 사용가능한 ID / count=1 : 이미 사용중인 ID
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery(); // 데이터 얻어오기
			rs.next();
			count=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return count;
	}
	
	// 회원 기능 2. 우편번호 검색
	// 실제 데이터 가져온다
	public List<ZipcodeVO> postfind(String dong)
	{
		List<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		try
		{
			getConnection();
			String sql="SELECT zipcode, sido, gugun, dong, NVL(bunji, ' ') "
					+ "FROM zipcode "
					+ "WHERE dong LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dong);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ZipcodeVO vo=new ZipcodeVO();
				vo.setZipcode(rs.getString(1));
				vo.setSido(rs.getString(2));
				vo.setGugun(rs.getString(3));
				vo.setDong(rs.getString(4));
				vo.setBunji(rs.getString(5));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	
	// 총 갯수 확인
	public int postfindCount(String dong)
	{
		int count=0;
		try
		{
			getConnection();
			String sql="SELECT COUNT(*) "
					+ "FROM zipcode "
					+ "WHERE dong LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dong);
			ResultSet rs=ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return count;
	}
	
	// 회원 기능 3. 실제 회원가입
	public void memberJoinInsert(MemberVO vo)
	{
		try
		{
			getConnection();
			String sql="INSERT INTO project_member VALUES(?,?,?,?,?,"
					+ "?,?,?,?,?,'n')"; // admin (n=일반, y=관리자)
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getSex());
			ps.setString(5, vo.getBirthday());
			
			ps.setString(6, vo.getEmail());
			ps.setString(7, vo.getPost());
			ps.setString(8, vo.getAddr1());
			ps.setString(9, vo.getAddr2());
			ps.setString(10, vo.getTel());
			
			ps.executeUpdate();
		}catch(Exception ex)	
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	
	// 회원 기능 4. 로그인
	public String isLogin(String id, String pwd)
	{
		String result="";
		try
		{
			getConnection();
			String sql="SELECT COUNT(*) "
					+ "FROM project_member "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql); // id가 존재하는지 먼저 체크
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			
			if(count==0)// ID가 없는 상태
			{
				result="NOID";
			}
			else // ID가 있는 상태
			{
				sql="SELECT pwd, name, admin FROM project_member "
						+ "WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String name=rs.getString(2);
				String admin=rs.getString(3);
				rs.close();
				
				// 비밀번호 확인
				if(db_pwd.equals(pwd)) // 로그인
				{
					result=name+"|"+admin;
				}
				else
				{
					result="NOPWD";
				}
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return result;
	}

}

