package com.sist.vo;

import java.util.Date;

public class NoticeVO {
	private int no,hit;
	private String name,subject,content,dbday;
	private Date regdate;
	private int preno, nextno;
	
	public int getPreno() {
		return preno;
	}
	public void setPreno(int preno) {
		this.preno = preno;
	}
	public int getNextno() {
		return nextno;
	}
	public void setNextno(int nextno) {
		this.nextno = nextno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	

}
