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
	
	

}

























