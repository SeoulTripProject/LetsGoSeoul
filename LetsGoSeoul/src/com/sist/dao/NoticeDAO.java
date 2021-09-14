package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import com.sist.vo.*;
public class NoticeDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static NoticeDAO dao; // 싱글턴 패턴 (static:메모리 공간을 한개만 사용이 가능) => 재사용 
	 
	  public void getConnection()
	  {
		  try
		  {
			  Context init=new InitialContext(); // 저장된 위치에 접근 
			  Context c=(Context)init.lookup("java://comp//env");
			  DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			  conn=ds.getConnection();
		  }catch(Exception ex) 
		  {
			  ex.printStackTrace();
		  }
	  }
	  // 사용후 반환 -> 다른사람이 재사용이 가능하게 만든다 
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
	  
	  //공지사항 목록 출력
	  public List<NoticeVO> noticeListDate(int page)
	  {
		  List<NoticeVO> list=new ArrayList<NoticeVO>();
		  try
		  {
			  getConnection();
			  String sql="SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),hit,num "
			  		+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			  		+ "FROM (SELECT no,subject,name,regdate,hit "
			  		+ "FROM project_notice ORDER BY no DESC)) "
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
	  //총페이지
	  public int noticetotalPage()
	  {
		  int total=0;
		  try
		  {
			  getConnection();
			  String sql="SELECT CEIL(COUNT(*)/10.0) FROM project_notice";
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
	  
	  //상세보기
	  public NoticeVO noticeDetailDate(int no)
	  {
		  NoticeVO vo=new NoticeVO();
		  try
		  {
			  getConnection();
			  String sql="UPDATE project_notice SET "
			  		+ "hit=hit+1 "
			  		+ "WHERE no=?";
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, no);
			  ps.executeUpdate();
			  
			  sql="SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),hit "
			  		+ "FROM project_notice "
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
	  
	  //공지사항 추가
	  public void noticeInsert(NoticeVO vo)
	  {
		  try
		  {
			  getConnection();
			  String sql="INSERT INTO project_notice(no,name,subject,content) VALUES("
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
	  
	  //공지사항 수정
	  public NoticeVO noticeUpdateData(int no)
	  {
		  NoticeVO vo=new NoticeVO();
		  try
		  {
			  getConnection();
			  String sql="SELECT no,subject,content FROM project_notice "
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
	  
	  //공지사항 삭제
	  public void noticeDelete(int no)
	  {
		  try
		  {
			  getConnection();
			  String sql="DELETE FROM project_notice WHERE no=?";
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
			  String sql="UPDATE project_notice SET "
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