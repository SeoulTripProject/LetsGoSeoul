package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import com.sist.dao.*;
import com.sist.vo.*;

public class NatureDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static NatureDAO dao; 

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
	
	
	public static NatureDAO newInstance()
	{
		if(dao==null) 
			dao=new NatureDAO();
		return dao; 
	}
	

		
		public int NatureTotalPage()
		{
			int total=0;
			try
			{
				getConnection();
				String sql="SELECT CEIL(COUNT(*)/12.0) FROM trip_N";
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
		
			public List<NatureVO> NatureData(int page)
			{
				List<NatureVO> list=new ArrayList<NatureVO>();
				try
				{
					getConnection();
					String sql="SELECT no,poster,title,subject,num "
							+ "FROM (SELECT no,poster,title,subject,rownum as num "
							+ "FROM (SELECT no,poster,title,subject "
							+ "FROM trip_N ORDER BY no ASC)) "
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
						NatureVO vo=new NatureVO();
						vo.setNo(rs.getInt(1));
						vo.setPoster(rs.getString(2));
						vo.setTitle(rs.getString(3));
						vo.setSubject(rs.getString(4));
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
	
			
			public NatureVO NatureDetailData(int no)
			{
				NatureVO vo=new NatureVO();
				try
				{
					getConnection();
					String sql="SELECT no,title,subject,poster,images,info,webLink,info2,addr,bus,Ntag "
							+ "FROM trip_N "
							+ "WHERE no=?";
					ps=conn.prepareStatement(sql);
					ps.setInt(1, no);
					ResultSet rs=ps.executeQuery();
					rs.next();
					vo.setNo(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setSubject(rs.getString(3));
					vo.setPoster(rs.getString(4));
					vo.setImages(rs.getString(5));
					vo.setInfo(rs.getString(6));
					vo.setWebLink(rs.getString(7));
					vo.setInfo2(rs.getString(8));
					String addr=rs.getString(9);
					addr=addr.substring(addr.indexOf(" "));
					addr=addr.trim();
					vo.setAddr(addr);
					vo.setBus(rs.getString(10));
					vo.setNtag(rs.getString(11));
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
































