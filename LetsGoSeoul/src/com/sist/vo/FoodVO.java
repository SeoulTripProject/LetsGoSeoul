package com.sist.vo;
/*
 * 	NO       NOT NULL NUMBER         
	RNO               NUMBER         
	POSTER            VARCHAR2(4000) 
	RNAME    NOT NULL VARCHAR2(300)  
	SCORE             NUMBER(2,1)    
	ADDR              VARCHAR2(1000) 
	TEL               VARCHAR2(20)   
	RTYPE    NOT NULL VARCHAR2(100)  
	PRICE             VARCHAR2(100)  
	PARKING           VARCHAR2(100)  
	OPENHOUR          VARCHAR2(500)  
	MENU              VARCHAR2(4000) 
	GOOD              NUMBER         
	SOSO              NUMBER         
	BAD               NUMBER         
	RTAG              VARCHAR2(1000) 
 */
public class FoodVO {
	private int no, rno, good, soso, bad;
	private double score;
	private String poster, rname, address, tel, rtype, price, parking, openHour, menu, rtag;
	private String addr1, addr2;
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
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getSoso() {
		return soso;
	}
	public void setSoso(int soso) {
		this.soso = soso;
	}
	public int getBad() {
		return bad;
	}
	public void setBad(int bad) {
		this.bad = bad;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getOpenHour() {
		return openHour;
	}
	public void setOpenHour(String openHour) {
		this.openHour = openHour;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getRtag() {
		return rtag;
	}
	public void setRtag(String rtag) {
		this.rtag = rtag;
	}
	
	

}
