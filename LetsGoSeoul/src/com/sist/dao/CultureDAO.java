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
	public ExbitVO exbitDetailData(int no)
	{
		ExbitVO vo=new ExbitVO();
		try
		{
			getConnection();
			String sql="SELECT no,images,detail,period,tel,time,day,price,addr,trans,tag "
					  +"FROM trip_E "
					  +"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setImages(rs.getString(2));
			vo.setDetail(rs.getString(3));
			vo.setPeriod(rs.getString(4));
			vo.setTel(rs.getString(5));
			vo.setTime(rs.getString(6));
			vo.setDay(rs.getString(7));
			vo.setPrice(rs.getString(8));
			vo.setAddr(rs.getString(9));
			vo.setTrans(rs.getString(10));
			vo.setTag(rs.getString(11));
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
	public CultureVO playDetailData(int no)
	{
		CultureVO vo=new CultureVO();
		try
		{
			getConnection();
			String sql="SELECT no,title,poster,period,story,addr,tel "
					  +"FROM trip_C "
					  +"WHERE no=?";
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
