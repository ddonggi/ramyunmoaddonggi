package com.ramyunmoa.web.controller.member;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramyunmoa.web.dao.MemberDao;
import com.ramyunmoa.web.entity.member.Member;
import com.ramyunmoa.web.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	//컨트롤러 - 서비스 - 다오
	@Autowired
	private MemberService memberService;
	

	@GetMapping("login")
	public String login() throws ClassNotFoundException, SQLException {
		
	return "member.login";
	}
	
	@PostMapping("login")
	public String login(Member member) throws ClassNotFoundException, SQLException {
		
	return "redirect:/main";
	}
	
	@GetMapping("logout")
	public String loout() throws ClassNotFoundException, SQLException {
		
	return "member.logout";
	}
	@GetMapping("regist")
	public String regist() throws ClassNotFoundException, SQLException {
		
	return "member.regist";
	}
	@GetMapping("member-term")
	public String memberTerm() throws ClassNotFoundException, SQLException {
		
	return "member.member-term";
	}
/*==============================중복체크 부분...JS로 바꾸는게 좋을 듯=======================*/

	@GetMapping("emailCheck")
	public String emailCheck() throws ClassNotFoundException, SQLException {
		
	return "popup.emailCheck"; //inc 를 낀 타일즈는 어떻게?
	}
	
	@GetMapping("uidCheck")
	public String uidCheck() throws ClassNotFoundException, SQLException {
		
		return "popup.uidCheck";
	}
	
	@GetMapping("nickCheck")
	public String nickCheck() throws ClassNotFoundException, SQLException {
		
		return "popup.nickCheck";
	}

/*===============================회원 탈퇴===============================*/
	@GetMapping("change-pwd-check")
	public String pwdCheck() throws ClassNotFoundException, SQLException {
		
		return "member.pwdCheck";
	}



}
