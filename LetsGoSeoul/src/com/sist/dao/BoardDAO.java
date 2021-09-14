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
	   // 怨듯넻�쑝濡� �궗�슜�릺�뒗 �냼�뒪瑜� 紐⑥븘�꽌 �뵲�씪 愿�由� (怨듯넻紐⑤뱢) => 愿�由�(AOP:�뒪�봽留�)
	   public void getConnection()
	   {
		      try
			  {
				  Context init=new InitialContext(); // ���옣�맂 �쐞移섏뿉 �젒洹� 
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
	// 硫붾え由� �늻�닔�쁽�긽�쓣 泥섎━ => �븳媛쒖쓽 怨듦컙�쓣 �씠�슜�빐�꽌 硫붾え由� 愿�由�(�떛湲��꽩�뙣�꽩) = �뒪�봽留곸� 嫄곗쓽 �떛湲��꽩 
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
			   String sql="SELECT no,subject,name,content,regdate,hit,num "
					     +"FROM (SELECT no,subject,name,content,regdate,hit,rownum as num "
					     +"FROM (SELECT no,subject,name,content,regdate,hit "
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
				   vo.setContent(rs.getString(4));
				   vo.setRegdate(rs.getDate(5));
				   vo.setHit(rs.getInt(6));
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
	// 珥앺럹�씠吏� 
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
	// �긽�꽭蹂닿린 
	   public BoardVO freeboardDetailData(int no)
	   {
		   BoardVO vo=new BoardVO();
		   try
		   {
			   getConnection();
			   // 議고쉶�닔 利앷� 
			   String sql="UPDATE project_freeboard SET "
					     +"hit=hit+1 "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.executeUpdate(); 
			   
			   // �긽�꽭蹂� 寃뚯떆臾� �씫湲�
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
	// �닔�젙 
	   public BoardVO freeboardUpdateData(int no)
	   {
		   BoardVO vo=new BoardVO();
		   try
		   {
			   getConnection();
			   // 議고쉶�닔 利앷� 
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
	// �떎�젣 �닔�젙 
	   public boolean freeboardUpdate(BoardVO vo)
	   {
		   boolean bCheck=false;// 鍮꾨�踰덊샇 泥댄겕 (true/�닔�젙,false/�떎�떆 �엯�젰)
		   try
		   {
			   getConnection();
			   // 鍮꾨�踰덊샇 �솗�씤 
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
				   // �떎�젣 �닔�젙 
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
	   public boolean freeboardDelete(int no,String pwd)
	   {
		   boolean bCheck=false;
		   try
		   {
			   getConnection();
			   conn.setAutoCommit(false);
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
				   sql="DELETE FROM project_reply "
					  +"WHERE bno=?";
				   ps=conn.prepareStatement(sql);
				   ps.setInt(1, no);
				   ps.executeUpdate();
				   
				   sql="DELETE FROM project_freeboard "
					  +"WHERE no=?";
				   ps=conn.prepareStatement(sql);
				   ps.setInt(1, no);
				   ps.executeUpdate();
				   conn.commit();
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
			   ps.executeUpdate(); //commit�씠 議댁옱  => autocommit()
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
			   // bno => �뼱�뼡 寃뚯떆臾� ,�뼱�뼡 留쏆쭛
			   // type => 援щ텇 (留쏆쭛,寃뚯떆�뙋)
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
	   
	// 댓글 쓰기
	   public void replyInsert(ReplyVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO project_reply VALUES("
			   		+ "pr_no_seq.nextval,?,?,?,?,?,SYSDATE)";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, vo.getBno());
			   ps.setInt(2, vo.getType());
			   ps.setString(3, vo.getId());
			   ps.setString(4, vo.getName());
			   ps.setString(5, vo.getMsg());
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
	   // 댓글 수정 
	   public void replyUpdate(int no,String msg)
	   {
		   try
		   {
			   getConnection();
			   String sql="UPDATE project_reply SET "
			   		+ "msg=? "
			   		+ "WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, msg);
			   ps.setInt(2, no);
			   ps.executeUpdate();
		   }
		   catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
	   }
	   // 댓글 삭제 
	   public void replyDelete(int no)
	   {
		   try
		   {
			   getConnection();
			   String sql="DELETE FROM project_reply WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.executeUpdate();
		   }
		   catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
	   }
}
