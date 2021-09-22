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
import com.sist.vo.ExbitVO;





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
			String sql="SELECT no,poster,title "
					+ "FROM trip_a "
					+ "WHERE no<=6 "
					+ "ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setNo(rs.getInt(1));
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
					+ "WHERE ano=1";
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
			String sql="SELECT no,ano,poster,title,intro,num "
					+ "FROM (SELECT no,ano,poster,title,intro,rownum as num "
					+ "FROM (SELECT no,ano,poster,title,intro "
					+ "FROM trip_a ORDER BY no ASC)) "
					+ "WHERE num BETWEEN ? AND ? "
					+ "AND ano=1";
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
				vo.setNo(rs.getInt(1));
				vo.setAno(rs.getInt(2));
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
	/*
	 *  NO      NOT NULL NUMBER         
		ANO              NUMBER         
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
	public AttraVO LandmarkDetailData(int no) // 상세보기
	{
		AttraVO vo=new AttraVO();
		try
		{
			getConnection();
			String sql="SELECT no,title,poster,image,intro,tel,website,time,holiday,open,price,handi,caution,addr,traffic "
					  +"FROM trip_a "
					  +"WHERE no=? and ano=1";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setImage(rs.getString(4));
			vo.setIntro(rs.getString(5));
			vo.setTel(rs.getString(6));
			vo.setWebsite(rs.getString(7));
			vo.setTime(rs.getString(8));
			vo.setHoliday(rs.getString(9));
			vo.setOpen(rs.getString(10));
			vo.setPrice(rs.getString(11));
			vo.setHandi(rs.getString(12));
			vo.setCaution(rs.getString(13));
			vo.setAddr(rs.getString(14));
			vo.setTraffic(rs.getString(15));
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
	///////////////////////////////////////////////////// 고궁 
	public List<AttraVO> PalaceMainData()
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT no,poster,title "
					+ "FROM trip_a "
					+ "WHERE 26<=no and no<=31 "
					+ "ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setNo(rs.getInt(1));
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
					+ "WHERE ano=2";
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
			String sql="SELECT no,ano,poster,title,intro,num "
					+ "FROM (SELECT no,ano,poster,title,intro,rownum as num "
					+ "FROM (SELECT no,ano,poster,title,intro "
					+ "FROM trip_a ORDER BY no ASC)) "
					+ "WHERE num BETWEEN ? AND ? "
					+ "AND ano=2";
			ps=conn.prepareStatement(sql);

			int rowSize=8;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start+25);
			ps.setInt(2, end+25);

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setNo(rs.getInt(1));
				vo.setAno(rs.getInt(2));
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
	public AttraVO PalaceDetailData(int no) // 상세보기
	{
		AttraVO vo=new AttraVO();
		try
		{
			getConnection();
			String sql="SELECT no,title,poster,image,intro,tel,website,time,holiday,open,price,handi,caution,addr,traffic "
					  +"FROM trip_a "
					  +"WHERE no=? and ano=2";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setImage(rs.getString(4));
			vo.setIntro(rs.getString(5));
			vo.setTel(rs.getString(6));
			vo.setWebsite(rs.getString(7));
			vo.setTime(rs.getString(8));
			vo.setHoliday(rs.getString(9));
			vo.setOpen(rs.getString(10));
			vo.setPrice(rs.getString(11));
			vo.setHandi(rs.getString(12));
			vo.setCaution(rs.getString(13));
			vo.setAddr(rs.getString(14));
			vo.setTraffic(rs.getString(15));
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
	// 역사적 장소
	public List<AttraVO> HistoricMainData()
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT no,poster,title "
					+ "FROM trip_a "
					+ "WHERE 41<=no and no<=46  "
					+ "ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setNo(rs.getInt(1));
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
					+ "WHERE ano=3";
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
			String sql="SELECT no,ano,poster,title,intro,num "
					+ "FROM (SELECT no,ano,poster,title,intro,rownum as num "
					+ "FROM (SELECT no,ano,poster,title,intro "
					+ "FROM trip_a ORDER BY no ASC)) "
					+ "WHERE num BETWEEN ? AND ? "
					+ "AND ano=3";
			ps=conn.prepareStatement(sql);

			int rowSize=8;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start+40);
			ps.setInt(2, end+40);

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setNo(rs.getInt(1));
				vo.setAno(rs.getInt(2));
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
	public AttraVO HistoricDetailData(int no) // 상세보기
	{
		AttraVO vo=new AttraVO();
		try
		{
			getConnection();
			String sql="SELECT no,title,poster,image,intro,tel,website,time,holiday,open,price,handi,caution,addr,traffic "
					  +"FROM trip_a "
					  +"WHERE no=? and ano=3";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setImage(rs.getString(4));
			vo.setIntro(rs.getString(5));
			vo.setTel(rs.getString(6));
			vo.setWebsite(rs.getString(7));
			vo.setTime(rs.getString(8));
			vo.setHoliday(rs.getString(9));
			vo.setOpen(rs.getString(10));
			vo.setPrice(rs.getString(11));
			vo.setHandi(rs.getString(12));
			vo.setCaution(rs.getString(13));
			vo.setAddr(rs.getString(14));
			vo.setTraffic(rs.getString(15));
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
    //////////////////////////// 오래된 가게///////////////////////////////////
	public List<AttraVO> OldMainData()
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT no,poster,title "
					+ "FROM trip_a "
					+ "WHERE 105<=no and no<=110 "
					+ "ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setNo(rs.getInt(1));
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
					+ "WHERE ano=4";
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
			String sql="SELECT no,ano,poster,title,intro,num "
					+ "FROM (SELECT no,ano,poster,title,intro,rownum as num "
					+ "FROM (SELECT no,ano,poster,title,intro "
					+ "FROM trip_a ORDER BY no ASC)) "
					+ "WHERE num BETWEEN ? AND ? "
					+ "AND ano=4";
			ps=conn.prepareStatement(sql);

			int rowSize=8;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start+104);
			ps.setInt(2, end+104);

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setNo(rs.getInt(1));
				vo.setAno(rs.getInt(2));
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
	public AttraVO OldDetailData(int no) // 상세보기
	{
		AttraVO vo=new AttraVO();
		try
		{
			getConnection();
			String sql="SELECT no,title,poster,image,intro,tel,website,time,holiday,open,price,handi,caution,addr,traffic "
					  +"FROM trip_a "
					  +"WHERE no=? and ano=4";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setImage(rs.getString(4));
			vo.setIntro(rs.getString(5));
			vo.setTel(rs.getString(6));
			vo.setWebsite(rs.getString(7));
			vo.setTime(rs.getString(8));
			vo.setHoliday(rs.getString(9));
			vo.setOpen(rs.getString(10));
			vo.setPrice(rs.getString(11));
			vo.setHandi(rs.getString(12));
			vo.setCaution(rs.getString(13));
			vo.setAddr(rs.getString(14));
			vo.setTraffic(rs.getString(15));
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
	/////////////////////////////// 박물관////////////////////////////
	public List<AttraVO> MuseumMainData()
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT no,poster,title "
					+ "FROM trip_a "
					+ "WHERE 133<=no and ano<=138 "
					+ "ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setNo(rs.getInt(1));
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
					+ "WHERE ano=5";
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
			String sql="SELECT no,ano,poster,title,intro,num "
					+ "FROM (SELECT no,ano,poster,title,intro,rownum as num "
					+ "FROM (SELECT no,ano,poster,title,intro "
					+ "FROM trip_a ORDER BY no ASC)) "
					+ "WHERE num BETWEEN ? AND ? "
					+ "AND ano=5";
			ps=conn.prepareStatement(sql);

			int rowSize=8;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start+132);
			ps.setInt(2, end+132);

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setNo(rs.getInt(1));
				vo.setAno(rs.getInt(2));
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
	public AttraVO MuseumDetailData(int no) // 상세보기
	{
		AttraVO vo=new AttraVO();
		try
		{
			getConnection();
			String sql="SELECT no,title,poster,image,intro,tel,website,time,holiday,open,price,handi,caution,addr,traffic "
					  +"FROM trip_a "
					  +"WHERE no=? and ano=5";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setImage(rs.getString(4));
			vo.setIntro(rs.getString(5));
			vo.setTel(rs.getString(6));
			vo.setWebsite(rs.getString(7));
			vo.setTime(rs.getString(8));
			vo.setHoliday(rs.getString(9));
			vo.setOpen(rs.getString(10));
			vo.setPrice(rs.getString(11));
			vo.setHandi(rs.getString(12));
			vo.setCaution(rs.getString(13));
			vo.setAddr(rs.getString(14));
			vo.setTraffic(rs.getString(15));
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
