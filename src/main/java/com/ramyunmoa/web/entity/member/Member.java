package com.ramyunmoa.web.entity.member;

import java.util.Date;

public class Member {
	private int id;
	private String uid;
	private String email;
	private String email1;
	private String email2;
	private String pwd;
	private String nickname;
	private String gender;
	private Date regdate;
	
	public Member() {

	}

	public Member(int id, String uid, String email, String email1, String email2, String pwd, String nickname,
			String gender, Date regdate) {
		this.id = id;
		this.uid = uid;
		this.email = email;
		this.email1 = email1;
		this.email2 = email2;
		this.pwd = pwd;
		this.nickname = nickname;
		this.gender = gender;
		this.regdate = regdate;
	}

	


	public Member(String uid, String email, String email1, String email2, String pwd, String nickname, String gender) {
		super();
		this.uid = uid;
		this.email = email;
		this.email1 = email1;
		this.email2 = email2;
		this.pwd = pwd;
		this.nickname = nickname;
		this.gender = gender;
	}



	public Member(int id, String uid, String email, String nickname,String pwd , String gender, Date regdate) {
		super();
		this.id = id;
		this.uid = uid;
		this.email = email;
		this.pwd = pwd;
		this.nickname = nickname;
		this.gender = gender;
		this.regdate = regdate;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", uid=" + uid + ", email=" + email + ", email1=" + email1 + ", email2=" + email2
				+ ", pwd=" + pwd + ", nickname=" + nickname + ", gender=" + gender + ", regdate=" + regdate +"]";
	}

	
	
}
