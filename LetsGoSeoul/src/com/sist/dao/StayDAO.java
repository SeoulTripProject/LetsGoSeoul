package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class StayDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static StayDAO dao; 

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
	public static StayDAO newInstance()
	{
		if(dao==null) // 미생성시에는
			dao=new StayDAO();
		return dao; // 이미 만들어진 dao객체를 사용한다
	}
	// 호텔
	public List<StayVO> stayMainData()
	{
		List<StayVO> list=new ArrayList<StayVO>();
		try
		{
			getConnection();
			String sql="SELECT no,poster,sname,score "
					+ "FROM trip_S "
					+ "WHERE no<=6 "
					+ "ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				StayVO vo=new StayVO();
				vo.setNo(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setSname(rs.getString(3));
				vo.setScore(rs.getDouble(4));
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
	
	//게스트 하우스
	public List<StayVO> stayMainData2()
	{
		List<StayVO> list=new ArrayList<StayVO>();
		try
		{
			getConnection();
			String sql="SELECT no,poster,sname "
					+ "FROM trip_S "
					+ "WHERE 388<=no and no<=393 "
					+ "ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				StayVO vo=new StayVO();
				vo.setNo(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setSname(rs.getString(3));
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
	
	public int HotelTotalPage()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM trip_S "
					+ "WHERE sno=1";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return total;
	}
	
	// 호텔
		public List<StayVO> HotelData(int page)
		{
			List<StayVO> list=new ArrayList<StayVO>();
			try
			{
				getConnection();
				String sql="SELECT no,sno,poster,sname,score,num "
						+ "FROM (SELECT no,sno,poster,sname,score,rownum as num "
						+ "FROM (SELECT no,sno,poster,sname,score "
						+ "FROM trip_S ORDER BY no ASC)) "
						+ "WHERE num BETWEEN ? AND ? "
						+ "AND sno=1";
				ps=conn.prepareStatement(sql);
				
				int rowSize=12;
				int start=(rowSize*page)-(rowSize-1);
				int end=rowSize*page;
				ps.setInt(1, start);
				ps.setInt(2, end);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					StayVO vo=new StayVO();
					vo.setNo(rs.getInt(1));
					vo.setSno(rs.getInt(2));
					vo.setPoster(rs.getString(3));
					vo.setSname(rs.getString(4));
					vo.setScore(rs.getDouble(5));
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
		
		public int GhouseTotalPage()
		{
			int total=0;
			try
			{
				getConnection();
				String sql="SELECT CEIL(COUNT(*)/12.0) FROM trip_S "
						+ "WHERE sno=2";
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				rs.next();
				total=rs.getInt(1);
				rs.close();
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				disConnection();
			}
			return total;
		}
		
		// 게스트하우스
		public List<StayVO> GhouseData(int page)
		{
			List<StayVO> list=new ArrayList<StayVO>();
			try
			{
				getConnection();
				String sql="SELECT no,sno,poster,sname,num "
						+ "FROM (SELECT no,sno,poster,sname,rownum as num "
						+ "FROM (SELECT no,sno,poster,sname "
						+ "FROM trip_S ORDER BY no ASC)) "
						+ "WHERE num BETWEEN ? AND ? "
						+ "AND sno=2";

				ps=conn.prepareStatement(sql);
				
				int rowSize=12;
				int start=(rowSize*page)-(rowSize-1);
				int end=rowSize*page;
			
			    ps.setInt(1, start+387);
			    ps.setInt(2, end+387);
			 
				
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					StayVO vo=new StayVO();
					vo.setNo(rs.getInt(1));
					vo.setSno(rs.getInt(2));
					vo.setPoster(rs.getString(3));
					vo.setSname(rs.getString(4));
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
		
		//호텔 상세보기
		public StayVO HotelDetailData(int no)
		{
			StayVO vo=new StayVO();
			try
			{
				getConnection();
				String sql="SELECT no,sno,sname,score,poster,images,webLink,addr "
						+ "FROM trip_S "
						+ "WHERE no=? AND sno=1";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, no);
				ResultSet rs=ps.executeQuery();
				rs.next();
				vo.setNo(rs.getInt(1));
				vo.setSno(rs.getInt(2));
				vo.setSname(rs.getString(3));
				vo.setScore(rs.getDouble(4));
				vo.setPoster(rs.getString(5));
				vo.setImages(rs.getString(6));
				vo.setWebLink(rs.getString(7));
				vo.setAddr(rs.getString(8));
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
		
		//게하 상세보기
		public StayVO GhouseDetailData(int no)
		{
			StayVO vo=new StayVO();
			try
			{
				getConnection();
				String sql="SELECT no,sno,sname,time,poster,images,tel,email,"
						+ "webLink,addr,langu,info,roomInfo,bus "
						+ "FROM trip_S "
						+ "WHERE no=? AND sno=2";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, no);
				ResultSet rs=ps.executeQuery();
				rs.next();
				vo.setNo(rs.getInt(1));
				vo.setSno(rs.getInt(2));
				vo.setSname(rs.getString(3));
				vo.setTime(rs.getString(4));
				vo.setPoster(rs.getString(5));
				vo.setImages(rs.getString(6));
				vo.setTel(rs.getString(7));
				vo.setEmail(rs.getString(8));
				vo.setWebLink(rs.getString(9));
				vo.setAddr(rs.getString(10));
				vo.setLangu(rs.getString(11));
				vo.setInfo(rs.getString(12));
				vo.setRoomInfo(rs.getString(13));
				vo.setBus(rs.getString(14));
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

























