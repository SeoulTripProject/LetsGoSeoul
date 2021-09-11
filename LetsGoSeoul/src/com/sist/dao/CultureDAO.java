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
			  String sql="SELECT no,title,images "
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
				  vo.setImages(rs.getString(3));
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


}
