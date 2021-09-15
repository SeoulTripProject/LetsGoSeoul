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
	
	//
	public List<FoodVO> foodMainData()
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		try
		{
			getConnection();
			String sql="SELECT no, poster, rname, score, rno "
					+ "FROM trip_R "
					+ "WHERE no<=12 "
					+ "ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo=new FoodVO();
				vo.setNo(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setRname(rs.getString(3));
				vo.setScore(rs.getDouble(4));
				vo.setRno(rs.getInt(5));
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
				String poster=rs.getString(2); 
				poster=poster.substring(0, poster.indexOf("^"));
				poster=poster.replace("#", "&");
				vo.setPoster(poster);
				vo.setRname(rs.getString(3));
				vo.setTel(rs.getString(4));
				String addr=rs.getString(5);
				addr=addr.substring(0,addr.lastIndexOf("지"));
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
	
/*	public FoodVO foodCookieInfoData(int no)
	{
		FoodVO vo=new FoodVO();
		try
		{
			getConnection();
			String sql="SELECT no, rname, poster "
					+ "FROM trip_R "
					+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setRname(rs.getString(2));
			String poster=rs.getString(3);
			poster=poster.substring(0,poster.indexOf("^"));
			poster=poster.replace("#", "&");
			vo.setPoster(poster);
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
	} */
	
	public List<FoodVO> foodListData(int page)
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		try
		{
			getConnection();
			String sql="SELECT no, rno, rname, poster, score, addr, num "
					+ "FROM (SELECT no, rno, rname, poster, score, addr, rownum as num "
					+ "FROM (SELECT no, rno, rname, poster, score, addr "
					+ "FROM trip_R ORDER BY no ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo=new FoodVO();
				vo.setNo(rs.getInt(1));
				vo.setRno(rs.getInt(2));
				vo.setRname(rs.getString(3));
				String poster=rs.getString(4);
				vo.setPoster(poster.substring(0,poster.indexOf("^")));
				vo.setScore(rs.getDouble(5));
				String addr=rs.getString(6);
				vo.setAddress(addr.substring(0, addr.indexOf("지")));
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
	
	public int foodTotalPage()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM trip_R";
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
	
	// 맛집 상세보기
	public FoodVO foodDetailData(int no)
	{
		FoodVO vo=new FoodVO();
		try
		{
			getConnection();
			String sql="SELECT * FROM "
					+ "(SELECT no, poster, rname, score, addr, tel, rtype, "
					+ "price, parking, openHour, menu, good, soso, bad, rno, rtag, "
					+ "LAG(no, 1, -1) OVER(ORDER BY no ASC) AS preno, " 
			  		+ "LEAD(no, 1, -1) OVER(ORDER BY no ASC) AS nextno "
					+ "FROM trip_R) WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setPoster(rs.getString(2));
			vo.setRname(rs.getString(3));
			vo.setScore(rs.getDouble(4));
			vo.setAddress(rs.getString(5));
			vo.setTel(rs.getString(6));
			vo.setRtype(rs.getString(7));
			vo.setPrice(rs.getString(8));
			vo.setParking(rs.getString(9));
			vo.setOpenHour(rs.getString(10));
			vo.setMenu(rs.getString(11));
			vo.setGood(rs.getInt(12));
			vo.setSoso(rs.getInt(13));
			vo.setBad(rs.getInt(14));
			vo.setRno(rs.getInt(15));
			vo.setRtag(rs.getString(16));
			vo.setPreno(rs.getInt(17));
			vo.setNextno(rs.getInt(18));
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
