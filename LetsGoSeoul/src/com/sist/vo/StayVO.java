package com.sist.vo;
/*
 *  NO       NOT NULL NUMBER         
	SNO               NUMBER         
	SCORE             NUMBER(2,1)    
	SNAME             VARCHAR2(1000) 
	TIME              VARCHAR2(2000) 
	POSTER            VARCHAR2(4000) 
	IMAGES            VARCHAR2(4000) 
	TEL               VARCHAR2(1000) 
	EMAIL             VARCHAR2(1000) 
	LINK              VARCHAR2(1000) 
	WEBLINK           VARCHAR2(1000) 
	ADDR              VARCHAR2(1000) 
	LANGU             VARCHAR2(1000) 
	INFO              VARCHAR2(4000) 
	ROOMINFO          CLOB           
	OPT               VARCHAR2(1000) 
	BUS               VARCHAR2(1000) 
 */
public class StayVO {
	private int no,sno;
	private double score;
	private String sname,time,poster,images,tel,email,link,webLink,addr,langu,info,roomInfo,opt,bus;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getWebLink() {
		return webLink;
	}
	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getLangu() {
		return langu;
	}
	public void setLangu(String langu) {
		this.langu = langu;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getRoomInfo() {
		return roomInfo;
	}
	public void setRoomInfo(String roomInfo) {
		this.roomInfo = roomInfo;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	public String getBus() {
		return bus;
	}
	public void setBus(String bus) {
		this.bus = bus;
	}
	
	
	
	
	
	
	
}
