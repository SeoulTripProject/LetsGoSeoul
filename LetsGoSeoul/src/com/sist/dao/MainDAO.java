package com.sist.dao;

import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

import com.sist.vo.*;

public class MainDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static MainDAO dao;
	 
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
	
	public static MainDAO newInstance()
	{
		if(dao==null)
			dao=new MainDAO();
		return dao;
	}
	
	public List<AttraVO> AttrMainData()
	{
		List<AttraVO> list=new ArrayList<AttraVO>();
		try
		{
			getConnection();
			String sql="SELECT no, poster, title, ano "
					+ "FROM trip_A "
					+ "ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AttraVO vo=new AttraVO();
				vo.setNo(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setAno(rs.getInt(4));
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
