package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import com.sist.vo.*;
public class NoticeDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static NoticeDAO dao; 
	 
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
			  if(ps!=null) ps.close();
			  if(conn!=null) conn.close();
		  }catch(Exception ex) {}
	  }
	  
	  public static NoticeDAO newInstance()
	  {
		  if(dao==null)
			  dao=new NoticeDAO();
		  return dao;
	  }
	  

	  public List<NoticeVO> noticeListDate(int page)
	  {
		  List<NoticeVO> list=new ArrayList<NoticeVO>();
		  try
		  {
			  getConnection();
			  String sql="SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),hit,num "
			  		+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			  		+ "FROM (SELECT no,subject,name,regdate,hit "
			  		+ "FROM trip_notice ORDER BY no DESC)) "
			  		+ "WHERE num BETWEEN ? AND ?";
			  ps=conn.prepareStatement(sql);
			  
			  int rowSize=10;
			  int start=(rowSize*page)-(rowSize-1);
			  int end=rowSize*page;
			  
			  ps.setInt(1, start);
			  ps.setInt(2, end);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next())
			  {
				  NoticeVO vo=new NoticeVO();
				  vo.setNo(rs.getInt(1));
				  vo.setSubject(rs.getString(2));
				  vo.setName(rs.getString(3));
				  vo.setDbday(rs.getString(4));
				  vo.setHit(rs.getInt(5));
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

	  public int noticeTotalPage()
	  {
		  int total=0;
		  try
		  {
			  getConnection();
			  String sql="SELECT CEIL(COUNT(*)/10.0) FROM trip_notice";
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
	  

	  public NoticeVO noticeDetailDate(int no)
	  {
		  NoticeVO vo=new NoticeVO();
		  try
		  {
			  getConnection();
			  String sql="UPDATE trip_notice SET "
			  		+ "hit=hit+1 "
			  		+ "WHERE no=?";
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, no);
			  ps.executeUpdate();
			  
			  sql="SELECT * "
			  		+ "FROM (SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),hit, "
			  		+ "LAG(no, 1, -1) OVER(ORDER BY no ASC) AS preno, " 
			  		+ "LEAD(no, 1, -1) OVER(ORDER BY no ASC) AS nextno " 
			  		+ "FROM trip_notice) "
			  		+ "WHERE no=?";
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, no);
			  ResultSet rs=ps.executeQuery();
			  rs.next();
			  vo.setNo(rs.getInt(1));
			  vo.setName(rs.getString(2));
			  vo.setSubject(rs.getString(3));
			  vo.setContent(rs.getString(4));
			  vo.setDbday(rs.getString(5));
			  vo.setHit(rs.getInt(6));
			  vo.setPreno(rs.getInt(7));
			  vo.setNextno(rs.getInt(8));
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
	  

	  public void noticeInsert(NoticeVO vo)
	  {
		  try
		  {
			  getConnection();
			  String sql="INSERT INTO trip_notice(no,name,subject,content) VALUES("
			  		+ "pn_no_seq.nextval,?,?,?)";
			  ps=conn.prepareStatement(sql);
			  ps.setString(1, vo.getName());
			  ps.setString(2, vo.getSubject());
			  ps.setString(3, vo.getContent());
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
	  

	  public NoticeVO noticeUpdateData(int no)
	  {
		  NoticeVO vo=new NoticeVO();
		  try
		  {
			  getConnection();
			  String sql="SELECT no,subject,content FROM trip_notice "
			  		+ "WHERE no=?";
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, no);
			  ResultSet rs=ps.executeQuery();
			  rs.next();
			  vo.setNo(rs.getInt(1));
			  vo.setSubject(rs.getString(2));
			  vo.setContent(rs.getString(3));
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
	  

	  public void noticeDelete(int no)
	  {
		  try
		  {
			  getConnection();
			  String sql="DELETE FROM trip_notice WHERE no=?";
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, no);
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
	  
	  public void noticeUpdate(NoticeVO vo)
	  {
		  try
		  {
			  getConnection();
			  String sql="UPDATE trip_notice SET "
			  		+ "subject=?,content=? "
			  		+ "WHERE no=?";
			  ps=conn.prepareStatement(sql);
			  ps.setString(1, vo.getSubject());
			  ps.setString(2, vo.getContent());
			  ps.setInt(3, vo.getNo());
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
	  
	  
	  

}