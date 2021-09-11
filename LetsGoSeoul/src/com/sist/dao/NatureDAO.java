package com.sist.dao;
/*
 * Table TRIP_N
이름      널?       유형             
------- -------- -------------- 
TNO     NOT NULL NUMBER         
TITLE   NOT NULL VARCHAR2(1000) 
POSTER  NOT NULL VARCHAR2(260)  
INTRO            VARCHAR2(1000) 
REV_HIT          NUMBER         
TYPE    NOT NULL NUMBER 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sist.vo.NatureVO;

public class NatureDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@211.238.142.211:1521/XE";
	private static NatureDAO dao;

	// 드라이버 등록
	public NatureDAO() {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) { }
	}

	// 연결
	public void getConnection() {
		try
		{
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception ex) {}
	}

	// 종료
	public void disConnection() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) { }
	}
	
	//
	public static NatureDAO newInstance() {
		if (dao == null) // 없으면 생성하고, 있으면 기존 꺼 사용
			dao = new NatureDAO();
		return dao;
	}
	
	// inser함수
	public void NatureInsert(NatureVO vo) {
		try {
			/*
 TNO     NOT NULL NUMBER      
NO               NUMBER         
TITLE   NOT NULL VARCHAR2(1000) 
POSTER           VARCHAR2(4000) 
IMAGE            VARCHAR2(4000) 
INTRO            CLOB           
NTAG             VARCHAR2(1000) 
CONTENT          CLOB           
TEL              VARCHAR2(500)        
WEBSITE          VARCHAR2(1000) 
TIME             VARCHAR2(1000) 
HOLIDAY          VARCHAR2(500)  
OPEN             VARCHAR2(1000) 
PRICE            VARCHAR2(500)  
HANDI            VARCHAR2(2000) 
CAUTION          VARCHAR2(2000) 
SITE             VARCHAR2(1000) 
TRAFFIC          VARCHAR2(1000) 
*/    
			getConnection();					//	1 2 3 4 5 6 1 1 1 1 1 1 1 1 1 1 1 1 1 
			String sql = "INSERT INTO trip_n VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //18개
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getTno());
			ps.setInt(2, vo.getNo());
			ps.setString(3, vo.getTitle());
			ps.setString(4, vo.getPoster());
			ps.setString(5, vo.getImage());
			ps.setString(6, vo.getIntro());
			ps.setString(7, vo.getNtag());
			ps.setString(8, vo.getContent());
			ps.setString(9, vo.getTel());
			ps.setString(10, vo.getWebsite());
			ps.setString(11, vo.getTime());
			ps.setString(12, vo.getHoliday());
			ps.setString(13, vo.getOpen());
			ps.setString(14, vo.getPrice());
			ps.setString(15, vo.getHandi());
			ps.setString(16, vo.getCaution());
			ps.setString(17, vo.getSite());
			ps.setString(18, vo.getTraffic());
			// 실행 요청
			ps.executeUpdate();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally 
		{
			disConnection();
		}

	}
}