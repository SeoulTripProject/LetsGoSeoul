package com.sist.vo;
/*
 *  TNO     NOT NULL NUMBER         
	NO               NUMBER         
	TITLE   NOT NULL VARCHAR2(500)  
	POSTER           VARCHAR2(400)  
	TEL              VARCHAR2(100)  
	WEBSITE          VARCHAR2(200)  
	TIME             VARCHAR2(400)  
	HOLIDAY          VARCHAR2(200)  
	OPEN             VARCHAR2(300)  
	PRICE            VARCHAR2(200)  
	HANDI            VARCHAR2(500)  
	CAUTION          VARCHAR2(1000) 
	ADDR             VARCHAR2(400)  
	TRAFFIC          VARCHAR2(500)  
); 
 */
public class AttraVO {
	private int tno,no;
	private String title,poster,tel,website,time,holiday,open,price,
	               handi,caution,addr,traffic;
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getHandi() {
		return handi;
	}
	public void setHandi(String handi) {
		this.handi = handi;
	}
	public String getCaution() {
		return caution;
	}
	public void setCaution(String caution) {
		this.caution = caution;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	
}
