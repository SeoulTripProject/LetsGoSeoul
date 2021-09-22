/*package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import com.sist.vo.*;
public class QnADAO {
	private Connection conn;
	   private PreparedStatement ps;
	   private static QnADAO dao;

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

	   public static QnADAO newInstance()
	   {
		   if(dao==null)
			   dao=new QnADAO();
		   return dao;
	   }
	   public List<QnAVO> qnaListData(int page)
	   {
		   List<QnAVO> list=new ArrayList<QnAVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT no,subject,name,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),hit,group_no,type,num "
					     +"FROM (SELECT no,subject,name,content,regdate,hit,group_no,type,rownum as num "
					     +"FROM (SELECT no,subject,name,content,regdate,hitgroup_no,type, "
					     +"FROM trip_qna ORDER BY group_no DESC)) "
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
				   QnAVO vo=new QnAVO();
				   vo.setNo(rs.getInt(1));
				   vo.setSubject(rs.getString(2));
				   vo.setName(rs.getString(3));
				   vo.setContent(rs.getString(4));
				   vo.setDbday(rs.getString(5));
				   vo.setHit(rs.getInt(6));
				   vo.setGroup_no(rs.getInt(7));
				   vo.setType(rs.getInt(8));
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

	   public int qnaTotalPage()
	   {
		   int total=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT CEIL(COUNT(*)/10.0) FROM trip_qna";
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

	   public QnAVO qnaDetailData(int no)
	   {
		   QnAVO vo=new QnAVO();
		   try
		   {
			   getConnection();
			   String sql="UPDATE trip_qna SET "
					     +"hit=hit+1 "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.executeUpdate(); 

			   sql="SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),hit "
				  +"FROM trip_qna "
				  +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   vo.setNo(rs.getInt(1));
			   vo.setSubject(rs.getString(3));
			   vo.setName(rs.getString(2));
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

	   public QnAVO qnaUpdateData(int no)
	   {
		   QnAVO vo=new QnAVO();
		   try
		   {
			   getConnection();

			   String sql="SELECT no,name,subject,content "
				  +"FROM trip_qna "
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

	   public boolean qnaUpdate(QnAVO vo)
	   {
		   boolean bCheck=false;
		   try
		   {
			   getConnection();
			   String sql="SELECT pwd FROM trip_qna "
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
				   sql="UPDATE trip_qna SET "
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
	   public boolean qnaDelete(int no,String pwd)
	   {
		   boolean bCheck=false;
		   try
		   {
			   getConnection();
			   conn.setAutoCommit(false);
			   // 비밀번호 체크 
			   String sql="SELECT pwd FROM trip_qna "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   String db_pwd=rs.getString(1);
			   rs.close();
			   if(pwd.equals(db_pwd)) 
			   {
				   bCheck=true;
				   sql="DELETE FROM trip_qQReply "
					  +"WHERE bno=?";
				   ps=conn.prepareStatement(sql);
				   ps.setInt(1, no);
				   ps.executeUpdate();
				   
				   sql="DELETE FROM trip_qna "
					  +"WHERE no=?";
				   ps=conn.prepareStatement(sql);
				   ps.setInt(1, no);
				   ps.executeUpdate();
				   conn.commit();
			   }
			   else
			   {
				   bCheck=false;
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
	   public void qnaInsert(QnAVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO trip_qna(no,name,subject,content,pwd) "
					     +"VALUES(tq_no_seq.nextval,?,?,?,?,tq_gno_seq)";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getName());
			   ps.setString(2, vo.getSubject());
			   ps.setString(3, vo.getContent());
			   ps.setString(4, vo.getPwd());
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
}*/
	   