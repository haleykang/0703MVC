package com.haley.mvc.domain;

public class Login {
	
	// 1.폼에 있는 name과 일치하는 이름으로 생성
	private String id;
	private String pw;
	
	// 2.getter, setter 생성
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	// 3. toString()함수 생성
	@Override
	public String toString() {
		return "Login [id=" + id + ", pw=" + pw + "]";
	}

}
