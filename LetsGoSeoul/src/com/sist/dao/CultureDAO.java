package com.sist.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.*;
public class CultureDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static CultureDAO dao;
	
	public void getConnection()
	{
		try
		{
			Context init=new InitialContext(); // 저장된 위치에 접근 
			  // JNDI (java naming directory interface)
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
			if(ps!=null) ps.close();
			  if(conn!=null) conn.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public static CultureDAO newInstance()
	{
		if(dao==null) // 미생성시에는 
			  dao=new CultureDAO();
		  return dao; // 이미 만들어진 dao객체를 사용한다 
	}
	
	public List<ExbitVO> exbitData()
	  {
		  List<ExbitVO> list=new ArrayList<ExbitVO>();
		  try
		  {
			  getConnection();
			  String sql="SELECT no,title,poster "
					    +"FROM trip_E "
					    +"WHERE no<=6 "
					    +"ORDER BY no ASC";
			  ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next())
			  {
				  ExbitVO vo=new ExbitVO();
				  vo.setNo(rs.getInt(1));
				  vo.setTitle(rs.getString(2));
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
	public int exbitTotalPage()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/8.0) FROM trip_E";
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
	public ExbitVO exbitListData(int no)
	{
		ExbitVO vo=new ExbitVO();
		try
		{
			getConnection();
			String sql="SELECT no,poster,title,period "
					  +"FROM trip_E"
					  +"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setPoster(rs.getString(2));
			vo.setTitle(rs.getString(3));
			vo.setPeriod(rs.getString(4));
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
	public List<ExbitVO> exbitData(int page)
	{
		List<ExbitVO> list=new ArrayList<ExbitVO>();
		try
		{
			getConnection();
			String sql="SELECT no,eno,poster,title,period,num "
					  +"FROM (SELECT no,eno,poster,title,period,rownum as num "
					  +"FROM (SELECT no,eno,poster,title,period "
					  +"FROM trip_E ORDER BY no ASC)) "
					  +"WHERE num BETWEEN ? AND ? "
					  +"AND eno=1";
			ps=conn.prepareStatement(sql);
			int rowSize=8;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ExbitVO vo=new ExbitVO();
				vo.setNo(rs.getInt(1));
				vo.setEno(rs.getInt(1));
				vo.setPoster(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setPeriod(rs.getString(5));
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
	public ExbitVO exbitDetailData(int no)
	{
		ExbitVO vo=new ExbitVO();
		try
		{
			getConnection();
			String sql="SELECT * FROM "
					+ "(SELECT no,images,title,detail,period,tel,time,day,price, "
					+ "addr,trans,tag, "
					+ "LAG(no, 1, -1) OVER(ORDER BY no ASC) as preno, " 
			  		+ "LEAD(no, 1, -1) OVER(ORDER BY no ASC) as nextno "
					+ "FROM trip_E) WHERE no=?";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setImages(rs.getString(2));
			vo.setTitle(rs.getString(3));
			vo.setDetail(rs.getString(4));
			vo.setPeriod(rs.getString(5));
			vo.setTel(rs.getString(6));
			vo.setTime(rs.getString(7));
			vo.setDay(rs.getString(8));
			vo.setPrice(rs.getString(9));
			vo.setAddr(rs.getString(10));
			vo.setTrans(rs.getString(11));
			vo.setTag(rs.getString(12));
			vo.setPreno(rs.getInt(13));
			vo.setNextno(rs.getInt(14));
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
	
	public List<CultureVO> playData()
	  {
		  List<CultureVO> list=new ArrayList<CultureVO>();
		  try
		  {
			  getConnection();
			  String sql="SELECT no,title,poster "
					    +"FROM trip_C "
					    +"WHERE no<=6 "
					    +"ORDER BY no ASC";
			  ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next())
			  {
				  CultureVO vo=new CultureVO();
				  vo.setNo(rs.getInt(1));
				  vo.setTitle(rs.getString(2));
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
	public int playTotalPage()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/8.0) FROM trip_C";
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
	public CultureVO playListData(int no)
	{
		CultureVO vo=new CultureVO();
		try
		{
			getConnection();
			String sql="SELECT no,poster,title,period "
					  +"FROM trip_C";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setPoster(rs.getString(2));
			vo.setTitle(rs.getString(3));
			vo.setPeriod(rs.getString(4));
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
	public List<CultureVO> playData(int page)
	{
		List<CultureVO> list=new ArrayList<CultureVO>();
		try
		{
			getConnection();
			String sql="SELECT no,cno,poster,title,period,num "
					  +"FROM (SELECT no,cno,poster,title,period,rownum as num "
					  +"FROM (SELECT no,cno,poster,title,period "
					  +"FROM trip_C ORDER BY no ASC)) "
					  +"WHERE num BETWEEN ? AND ? "
					  +"AND cno=1";
			ps=conn.prepareStatement(sql);
			int rowSize=8;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				CultureVO vo=new CultureVO();
				vo.setNo(rs.getInt(1));
				vo.setCno(rs.getInt(1));
				vo.setPoster(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setPeriod(rs.getString(5));
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
	public CultureVO playDetailData(int no)
	{
		CultureVO vo=new CultureVO();
		try
		{
			getConnection();
			String sql="SELECT * FROM "
					+ "(SELECT no,title,poster,period,story,addr,tel, "
					+ "LAG(no, 1, -1) OVER(ORDER BY no ASC) as preno, " 
			  		+ "LEAD(no, 1, -1) OVER(ORDER BY no ASC) as nextno "
					+ "FROM trip_C) WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setPeriod(rs.getString(4));
			vo.setStory(rs.getString(5));
			vo.setAddr(rs.getString(6));
			vo.setTel(rs.getString(7));
			vo.setPreno(rs.getInt(8));
			vo.setNextno(rs.getInt(9));
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
	public ArrayList<CultureVO> cultureFindData(String cfd)
	{
		ArrayList<CultureVO> list=new ArrayList<CultureVO>();
		try
		{
			getConnection();
			String sql="";
			
			if(cfd.equals("all"))
			{
				sql="SELECT title,poster,num "
					+"FROM (SELECT title,poster,rownum as num "
					+"FROM (SELECT title,poster "
					+"FROM trip_c ORDER BY no ASC)) "
					+"WHERE rownum<=28";
				ps=conn.prepareStatement(sql);
			}
			else
			{
				sql="SELECT title,poster "
					+"FROM trip_c "
					+"WHERE title LIKE '%'||?||'%'";
				ps=conn.prepareStatement(sql);
				ps.setString(1, cfd);
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				CultureVO vo=new CultureVO();
				vo.setTitle(rs.getString(1));
				vo.setPoster(rs.getString(2));
				list.add(vo);
			}
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
	public List<FoodVO> seoulFoodListData(String gu)
	{
	  List<FoodVO> list=new ArrayList<FoodVO>();
	  try
	  {
		  getConnection();
		  String sql="SELECT no,poster,rname,rownum "
		  		+ "FROM (SELECT no,poster,rname "
		  		+ "FROM trip_R WHERE addr LIKE '%'||?||'%' ORDER BY no ASC) "
		  		+ "WHERE rownum<=8";
		  ps=conn.prepareStatement(sql);
		  ps.setString(1, gu);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  FoodVO vo=new FoodVO();
			  vo.setNo(rs.getInt(1));
			  String image=rs.getString(2);
			  image=image.substring(0,image.indexOf("^"));
			  image=image.replace("#", "&");
			  vo.setPoster(image);
			  vo.setRname(rs.getString(3));
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
