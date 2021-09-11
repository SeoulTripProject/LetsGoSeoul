package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;

import com.sist.vo.*;

import javax.naming.*;
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static FoodDAO dao;
	
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
	
	public static FoodDAO newInstance()
	{
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}

	public void foodInsert(FoodVO vo)
	{
		try
		{
			getConnection();
			String sql="INSERT INTO trip_R VALUES("
					+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getNo());
			ps.setInt(2, vo.getRno());
			ps.setString(3, vo.getPoster());
			ps.setString(4, vo.getRname());
			ps.setDouble(5, vo.getScore());
			ps.setString(6, vo.getAddress());
			ps.setString(7, vo.getTel());
			ps.setString(8, vo.getRtype());
			ps.setString(9, vo.getPrice());
			ps.setString(10, vo.getParking());
			ps.setString(11, vo.getOpenHour());
			ps.setString(12, vo.getMenu());
			ps.setInt(13, vo.getGood());
			ps.setInt(14, vo.getSoso());
			ps.setInt(15, vo.getBad());
			ps.setString(16, vo.getRtag());
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
	
	// 기능 => 테이블 단위로 넘어가는 상태
		public List<FoodVO> foodCategoryData()
		{
			List<FoodVO> list=new ArrayList<FoodVO>();
			try
			{
				getConnection();
				String sql="SELECT rno, rname, poster "
						+ "FROM trip_R";
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					FoodVO vo=new FoodVO();
					vo.setRno(rs.getInt(1));
					vo.setRname(rs.getString(2));
					vo.setPoster(rs.getString(3));
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
		
		// 카테고리별 목록 읽기
		public List<FoodVO> foodCategoryListData(int rno)
		{
			List<FoodVO> list=new ArrayList<FoodVO>();
			try
			{
				getConnection();
				String sql="SELECT no, poster, rname, tel, addr, rtype, score "
						+ "FROM trip_R "
						+ "WHERE rno=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, rno);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					FoodVO vo=new FoodVO();
					vo.setNo(rs.getInt(1));
					String poster=rs.getString(2); // 이미지 5개를 묶어서 저장 (1개만 가지고 온다)
					poster=poster.substring(0, poster.indexOf("^")); // 첫번째 그림 하나를 달라
					poster=poster.replace("#", "&");
					vo.setPoster(poster);
					vo.setRname(rs.getString(3));
					vo.setTel(rs.getString(4));
					String addr=rs.getString(5);
					addr=addr.substring(0,addr.lastIndexOf("지")); // 길/ 지번 => 길만 가지고 온다 
					vo.setAddress(addr);
					vo.setRtype(rs.getString(6));
					vo.setScore(rs.getDouble(7));
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
		
		// 카테고리별 제목 읽기
		public FoodVO foodCategoryInfoData(int rno)
		{
			FoodVO vo=new FoodVO();
			try
			{
				getConnection();
				String sql="SELECT title FROM trip_R "
						+ "WHERE rno=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, rno);
				ResultSet rs=ps.executeQuery();
				rs.next();
				vo.setRname(rs.getString(1));
				rs.close();
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				disConnection();
			}
			return vo;
		}
}
