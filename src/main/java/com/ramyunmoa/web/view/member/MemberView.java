package com.ramyunmoa.web.view.member;

public class MemberView {

	private int id;
	private int roleId;
	private String roleGrade;
	private String uid;
	private String nickname;
	private String gender;
	private String regdate;
	private String email;

	public MemberView() {
		// TODO Auto-generated constructor stub
	}

	//마이페이지 내 정보
	public MemberView(int id,int roleId, String roleGrade,String nickname, String regdate,String email) {
		this.id=id;
		this.roleId=roleId;
		this.roleGrade=roleGrade;
		this.nickname = nickname;
		this.regdate=regdate;
		this.email=email;
	}
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleGrade() {
		return roleGrade;
	}

	public void setRoleGrade(String roleGrade) {
		this.roleGrade = roleGrade;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberView [id=" + id + ", roleId=" + roleId + ", roleGrade=" + roleGrade + ", uid=" + uid
				+ ", nickname=" + nickname + ", gender=" + gender + ", regdate=" + regdate + ", email=" + email + "]";
	}

	
	
}
