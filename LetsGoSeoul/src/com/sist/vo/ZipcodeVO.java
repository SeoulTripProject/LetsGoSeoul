package com.sist.vo;
/*
 * 	1. Ajax를 쓰는 부분 : 우편번호 검색, id중복 체크, 예매|예약, 검색, 페이지 나누기, 추천, 레시피 만들기
 *  
 */
public class ZipcodeVO {
	private String zipcode, sido, gugun, dong, bunji, address;

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getBunji() {
		return bunji;
	}

	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	
	// VO는 데이터 베이스의 컬럼명 + 기타 (컬럼이 아닌 다른 변수를 포함할 수 있다)
	// 출력용으로만 사용 (데이터 받지 않는다)
	public String getAddress() {
		return sido+" "+gugun+" "+dong+" "+bunji;
	}
	
}
