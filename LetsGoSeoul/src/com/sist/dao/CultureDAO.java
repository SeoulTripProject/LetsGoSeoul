package com.sist.dao;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
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

}
