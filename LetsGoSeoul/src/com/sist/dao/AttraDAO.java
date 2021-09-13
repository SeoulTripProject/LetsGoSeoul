package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.AttraVO;





public class AttraDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static AttraDAO dao; 

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


	public static AttraDAO newInstance()
	{
		if(dao==null) //
			dao=new AttraDAO();
		return dao;
	}
	/*
	 *  TNO     NOT NULL NUMBER         
		NO               NUMBER         
		TITLE   NOT NULL VARCHAR2(1000) 
		POSTER           VARCHAR2(1000) 
		IMAGE            VARCHAR2(4000) 
		INTRO            VARCHAR2(1000) 
		TEL              VARCHAR2(1000) 
		WEBSITE          VARCHAR2(1000) 
		TIME             VARCHAR2(1000) 
		HOLIDAY          VARCHAR2(1000) 
		OPEN             VARCHAR2(1000) 
		PRICE            VARCHAR2(1000) 
		HANDI            VARCHAR2(1000) 
		CAUTION          VARCHAR2(1000) 
		ADDR             VARCHAR2(1000) 
		TRAFFIC          VARCHAR2(1000) 
	 */

	//Attraction 클릭시 6개 출력 (landmark)
	public List<AttraVO> LandmarkMainData()
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT tno,poster,title "
					+ "FROM trip_a "
					+ "WHERE tno<=6 and no=1 "
					+ "ORDER BY tno ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setTno(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setTitle(rs.getString(3));
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
	public int LandmarkTotalPage() //총페이지
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/8.0) FROM trip_a "
					+ "WHERE no=1";
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


	public List<AttraVO> LandmarkData(int page) //페이지 나누기
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT tno,no,poster,title,intro,num "
					+ "FROM (SELECT tno,no,poster,title,intro,rownum as num "
					+ "FROM (SELECT tno,no,poster,title,intro "
					+ "FROM trip_a ORDER BY tno ASC)) "
					+ "WHERE num BETWEEN ? AND ? "
					+ "AND no=1";
			ps=conn.prepareStatement(sql);

			int rowSize=8;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setTno(rs.getInt(1));
				vo.setNo(rs.getInt(2));
				vo.setPoster(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setIntro(rs.getString(5));
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
	// 고궁 
	public List<AttraVO> PalaceMainData()
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT tno,poster,title "
					+ "FROM trip_a "
					+ "WHERE 26<=tno and tno<=31 "
					+ "ORDER BY tno ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setTno(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setTitle(rs.getString(3));
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
	public int PalaceTotalPage() //총페이지
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/8.0) FROM trip_a "
					+ "WHERE no=2";
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


	public List<AttraVO> PalaceData(int page) //페이지 나누기
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT tno,no,poster,title,intro,num "
					+ "FROM (SELECT tno,no,poster,title,intro,rownum as num "
					+ "FROM (SELECT tno,no,poster,title,intro "
					+ "FROM trip_a ORDER BY tno ASC)) "
					+ "WHERE num BETWEEN ? AND ? "
					+ "AND no=2";
			ps=conn.prepareStatement(sql);

			int rowSize=8;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setTno(rs.getInt(1));
				vo.setNo(rs.getInt(2));
				vo.setPoster(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setIntro(rs.getString(5));
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
	// 역사적 장소
	public List<AttraVO> HistoricMainData()
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT tno,poster,title "
					+ "FROM trip_a "
					+ "WHERE 41<=tno and tno<=46  "
					+ "ORDER BY tno ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setTno(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setTitle(rs.getString(3));
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
	public int HistoricTotalPage() //총페이지
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/8.0) FROM trip_a "
					+ "WHERE no=3";
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


	public List<AttraVO> HistoricData(int page) //페이지 나누기
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT tno,no,poster,title,intro,num "
					+ "FROM (SELECT tno,no,poster,title,intro,rownum as num "
					+ "FROM (SELECT tno,no,poster,title,intro "
					+ "FROM trip_a ORDER BY tno ASC)) "
					+ "WHERE num BETWEEN ? AND ? "
					+ "AND no=3";
			ps=conn.prepareStatement(sql);

			int rowSize=8;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setTno(rs.getInt(1));
				vo.setNo(rs.getInt(2));
				vo.setPoster(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setIntro(rs.getString(5));
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
    // 오래된 가게
	public List<AttraVO> OldMainData()
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT tno,poster,title "
					+ "FROM trip_a "
					+ "WHERE 105<=tno and tno<=110 "
					+ "ORDER BY tno ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setTno(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setTitle(rs.getString(3));
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
	public int OldTotalPage() //총페이지
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/8.0) FROM trip_a "
					+ "WHERE no=4";
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


	public List<AttraVO> OldData(int page) //페이지 나누기
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT tno,no,poster,title,intro,num "
					+ "FROM (SELECT tno,no,poster,title,intro,rownum as num "
					+ "FROM (SELECT tno,no,poster,title,intro "
					+ "FROM trip_a ORDER BY tno ASC)) "
					+ "WHERE num BETWEEN ? AND ? "
					+ "AND no=4";
			ps=conn.prepareStatement(sql);

			int rowSize=8;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setTno(rs.getInt(1));
				vo.setNo(rs.getInt(2));
				vo.setPoster(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setIntro(rs.getString(5));
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
	// 박물관
	public List<AttraVO> MuseumMainData()
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT tno,poster,title "
					+ "FROM trip_a "
					+ "WHERE 133<=tno and tno<=138 "
					+ "ORDER BY tno ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setTno(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setTitle(rs.getString(3));
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
	public int MuseumTotalPage() //총페이지
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/8.0) FROM trip_a "
					+ "WHERE no=5";
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


	public List<AttraVO> MuseumData(int page) //페이지 나누기
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT tno,no,poster,title,intro,num "
					+ "FROM (SELECT tno,no,poster,title,intro,rownum as num "
					+ "FROM (SELECT tno,no,poster,title,intro "
					+ "FROM trip_a ORDER BY tno ASC)) "
					+ "WHERE num BETWEEN ? AND ? "
					+ "AND no=5";
			ps=conn.prepareStatement(sql);

			int rowSize=8;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setTno(rs.getInt(1));
				vo.setNo(rs.getInt(2));
				vo.setPoster(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setIntro(rs.getString(5));
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
	
}
