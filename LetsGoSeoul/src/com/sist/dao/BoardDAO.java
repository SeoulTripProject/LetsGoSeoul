package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import com.sist.vo.*;
public class BoardDAO {
	private Connection conn;
	   private PreparedStatement ps;
	   private static BoardDAO dao;
	   // 공통으로 사용되는 소스를 모아서 따라 관리 (공통모듈) => 관리(AOP:스프링)
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
			  }catch(Exception ex) {}
	   }
	// 메모리 누수현상을 처리 => 한개의 공간을 이용해서 메모리 관리(싱글턴패턴) = 스프링은 거의 싱글턴 
	   public static BoardDAO newInstance()
	   {
		   if(dao==null)
			   dao=new BoardDAO();
		   return dao;
	   }
	   public List<BoardVO> freeboardListData(int page)
	   {
		   List<BoardVO> list=new ArrayList<BoardVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT no,subject,name,regdate,hit,num "
					     +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
					     +"FROM (SELECT no,subject,name,regdate,hit "
					     +"FROM project_freeboard ORDER BY no DESC)) "
					     +"WHERE num BETWEEN ? AND ?";
			   ps=conn.prepareStatement(sql);
			   int rowSize=10;
			   int start=(rowSize*page)-(rowSize-1);
			   int end=rowSize*page;
			   ps.setInt(1, start);
			   ps.setInt(2, end);
			   
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   BoardVO vo=new BoardVO();
				   vo.setNo(rs.getInt(1));
				   vo.setSubject(rs.getString(2));
				   vo.setName(rs.getString(3));
				   vo.setRegdate(rs.getDate(4));
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
	// 총페이지 
	   public int freeboardTotalPage()
	   {
		   int total=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT CEIL(COUNT(*)/10.0) FROM project_freeboard";
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
	// 상세보기 
	   public BoardVO freeboardDetailData(int no)
	   {
		   BoardVO vo=new BoardVO();
		   try
		   {
			   getConnection();
			   // 조회수 증가 
			   String sql="UPDATE project_freeboard SET "
					     +"hit=hit+1 "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.executeUpdate(); 
			   
			   // 상세볼 게시물 읽기
			   sql="SELECT no,name,subject,content,regdate,hit "
				  +"FROM project_freeboard "
				  +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   vo.setNo(rs.getInt(1));
			   vo.setSubject(rs.getString(3));
			   vo.setName(rs.getString(2));
			   vo.setContent(rs.getString(4));
			   vo.setRegdate(rs.getDate(5));
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
	// 수정 
	   public BoardVO freeboardUpdateData(int no)
	   {
		   BoardVO vo=new BoardVO();
		   try
		   {
			   getConnection();
			   // 조회수 증가 
			   String sql="SELECT no,name,subject,content "
				  +"FROM project_freeboard "
				  +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   vo.setNo(rs.getInt(1));
			   vo.setSubject(rs.getString(3));
			   vo.setName(rs.getString(2));
			   vo.setContent(rs.getString(4));
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
	// 실제 수정 
	   public boolean freeboardUpdate(BoardVO vo)
	   {
		   boolean bCheck=false;// 비밀번호 체크 (true/수정,false/다시 입력)
		   try
		   {
			   getConnection();
			   // 비밀번호 확인 
			   String sql="SELECT pwd FROM project_freeboard "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, vo.getNo());
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   String db_pwd=rs.getString(1);
			   rs.close();
			   
			   if(db_pwd.equals(vo.getPwd())) 
			   {
				   bCheck=true;
				   // 실제 수정 
				   sql="UPDATE project_freeboard SET "
					  +"name=?,subject=?,content=? "
					  +"WHERE no=?";
				   ps=conn.prepareStatement(sql);
				   ps.setString(1, vo.getName());
				   ps.setString(2, vo.getSubject());
				   ps.setString(3, vo.getContent());
				   ps.setInt(4, vo.getNo());
				   ps.executeUpdate();
			   }
			   else
			   {
				   bCheck=false;
			   }
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return bCheck;
	   }
	// 삭제 => 트랜잭션 프로그램 (일괄처리) => SQL 문장 전체가 실행, error가 났을경우에 전체를 취소
	   public boolean freeboardDelete(int no,String pwd)
	   {
		   boolean bCheck=false;
		   try
		   {
			   getConnection();
			   // 비밀번호 체크 
			   String sql="SELECT pwd FROM project_freeboard "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   String db_pwd=rs.getString(1);
			   rs.close();
			   if(pwd.equals(db_pwd)) 
			   {
				   bCheck=true;//freeboard/list.jsp
				   // 삭제 한다 
				   sql="DELETE FROM project_reply "
					  +"WHERE bno=?";
				   ps=conn.prepareStatement(sql);
				   ps.setInt(1, no);
				   ps.executeUpdate(); // 참조하고 있는 데이터를 먼저 삭제한다
				   
				   sql="DELETE FROM project_freeboard "
					  +"WHERE no=?";
				   ps=conn.prepareStatement(sql);
				   ps.setInt(1, no);
				   ps.executeUpdate();
			   }
			   else
			   {
				   bCheck=false;// history.back()
			   }
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
			   try
			   {
				   conn.rollback();
			   }catch(Exception e)
			   {
				   e.printStackTrace();
			   }
		   }
		   finally
		   {
			   try
			   {
				   conn.setAutoCommit(true);
			   }catch(Exception ex) {}
			   disConnection();
		   }
		   return bCheck;
	   }
	   public void freeboardInsert(BoardVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO project_freeboard(no,name,subject,content,pwd) "
					     +"VALUES(pf_no_seq.nextval,?,?,?,?)";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getName());
			   ps.setString(2, vo.getSubject());
			   ps.setString(3, vo.getContent());
			   ps.setString(4, vo.getPwd());
			   ps.executeUpdate(); //commit이 존재  => autocommit()
			   // INSERT , UPDATE ,DELETE
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
	   }
	   public List<ReplyVO> replyListData(int bno,int type)
	   {
		   List<ReplyVO> list=new ArrayList<ReplyVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT no,bno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:ss') "
					     +"FROM project_reply "
					     +"WHERE bno=? AND type=?";
			   // bno => 어떤 게시물 ,어떤 맛집
			   // type => 구분 (맛집,게시판)
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, bno);
			   ps.setInt(2, type);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   ReplyVO vo=new ReplyVO();
				   vo.setNo(rs.getInt(1));
				   vo.setBno(rs.getInt(2));
				   vo.setId(rs.getString(3));
				   vo.setName(rs.getString(4));
				   vo.setMsg(rs.getString(5));
				   vo.setDbday(rs.getString(6));
				   list.add(vo);
			   }
			   rs.close();
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
