package com.sist.vo;
import java.util.*;
/*
 *  -------- -------- -------------- 
	NO       NOT NULL NUMBER         
	NAME     NOT NULL VARCHAR2(34)   
	SUBJECT  NOT NULL VARCHAR2(1000) 
	CONTENT  NOT NULL CLOB           
	REGDATE           DATE           
	HIT               NUMBER         
	GROUP_NO NOT NULL NUMBER         
	TYPE     NOT NULL NUMBER   
 */

public class QnAVO {
	private int no,hit,group_no,type;   // type=0 질문, type=1 답변
	private String name,subject,content,pwd,dbday;
	private Date regdate;
	
	
	public int getGroup_no() {
		return group_no;
	}
	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
