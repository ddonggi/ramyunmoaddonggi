package com.ramyunmoa.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ramyunmoa.web.entity.member.Member;

//component가 아니라서 IoC에 담기지 않는데,
//스프링에는 IOC에 얹어질 수 있게끔 하는 어노테이션이 있다.
//그것은 MAPPER 이다.

@Mapper
public interface MemberDao {
//===========================일반회원=======================
	// 회원가입
	@Insert("INSERT INTO Member(uid,pwd,email,nickname,gender) values(#{uid},#{pwd},#{email},#{nickname},#{gender})")
	int insert(Member member) throws SQLException, ClassNotFoundException;

	// 아이디 중복확인
	@Select("SELECT uid FROM Member WHERE uid=#{uid}")
	boolean checkUid(String uid) throws SQLException, ClassNotFoundException;

	// 이메일 체크
	@Select("SELECT email FROM Member WHERE email=#{email}")
	boolean checkEmail(String email) throws SQLException, ClassNotFoundException;

	// 닉네임체크
	@Select("SELECT nickname FROM Member WHERE nickname=#{nickname}")
	boolean checkNick(String nickname) throws SQLException, ClassNotFoundException;

	// 로그인
	@Select("SELECT nickname FROM Member WHERE uid=#{uid} AND pwd=#{pwd}")
	boolean loginCheck(String uid, String pwd) throws ClassNotFoundException, SQLException;

	// 회원리스트
	@Select("SELECT * FROM Member ORDER BY regdate DESC")
	List<Member> getMemberList() throws SQLException, ClassNotFoundException;
	// 회원글 리스트
	
	// 회원댓글 리스트

	// 회원정보출력
	@Select("SELECT * FROM Member WHERE ID=#{id}")
	String getMember();
	// 비밀번호 변경
	//@Update("UPDATE Member SET pwd = #{pwd} WHERE id = #{id}")

	// 회원탈퇴
	@Delete("DELETE FROM Member WHERE uid=#{uid} AND pwd=#{pwd}")
	int deleteMember();
	//public int deleteMember(String uid, String pwd) throws ClassNotFoundException, SQLException;
	// ====================관리자 전용====================
	// 회원 정보 출력

}
