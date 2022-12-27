package sehyunict.member.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sehyunict.member.entity.MemberVo;
import sehyunict.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// 회원 정보 조회
	@RequestMapping("/MI")
	public String memberInfo(Model model) {
		
		int memberNo = 1;
		
		MemberVo memberVo = memberService.memberInfo(memberNo);
		
		model.addAttribute("memberVo", memberVo);
		
		return "member/memberInfo";
	}
	
	// 회원 수정 페이지로 이동
	@RequestMapping("/MUF")
	public String memberUpdateForm(@RequestParam("memberNo") int memberNo, Model model) {
		
		MemberVo memberVo = memberService.memberInfo(memberNo);
		
		model.addAttribute("memberVo", memberVo);
		
		return "member/memberUpdateForm";
	}
	
	// 회원 정보 수정
	@RequestMapping("/MU")
	public String memberUpdate(HttpServletRequest request) {
		
		MemberVo memberVo = new MemberVo();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(request.getParameter("memberBirth"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		memberVo.setMember_no(Integer.parseInt(request.getParameter("memberNo")));
		memberVo.setMember_pw(request.getParameter("pw"));
		memberVo.setMember_name(request.getParameter("name"));
		memberVo.setMember_gender(request.getParameter("gender"));
		memberVo.setMember_birthdate(date);
		memberVo.setMember_introduce(request.getParameter("introduce"));
		memberVo.setMember_email(request.getParameter("email"));
		memberVo.setMember_phone(request.getParameter("phone"));
		memberVo.setMember_marketingCheck(request.getParameter("marketing"));
		
		memberService.memberUpdate(memberVo);
		
		return "redirect:MI";
	}
	
	// 회원 탈퇴
	@RequestMapping("/MDT")
	public String memberDelete(@RequestParam("memberNo") int memberNo, Model model) {
		
		int result = memberService.memberDelete(memberNo);
		
		model.addAttribute("result", result);
		
		return "member/memberInfo";
	}
	
}
