package sehyunict.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sehyunict.admin.entity.PageMaker;
import sehyunict.admin.entity.PageVo;
import sehyunict.admin.service.AdminMemberService;
import sehyunict.member.entity.MemberVo;

@Controller
public class AdminMemberController {
	
	@Autowired
	private AdminMemberService adminMemberService;
	
	
	// 관리자 인덱스 페이지

	@RequestMapping(value = "/adminMember") // 인덱스
	public String adminIndex(Model model, PageVo pvo) {
		
			System.out.println("유저리스트");// 콘솔출력용
			
			model.addAttribute("adminMemberList", adminMemberService.adminMemberList(pvo));
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setPvo(pvo);
			pageMaker.setTotalCount(adminMemberService.adminMemberCount(pvo));
			System.out.println(pageMaker);
			
			model.addAttribute("pageMaker", pageMaker);
		
		return "/adminIndex";
		
	}
	
	// 선택회원 관리페이지 이동 및 no 값 전달만 (단일회원정보)
	
	@RequestMapping(value = "/admember/info")
	public String admMemberInfo(Model model, MemberVo vo) {
		
		model.addAttribute("Member_No", vo.getMEMBER_No());
		
		return "/adMemberInfo";
	} 
	
	// AJAX 연결 회원리스트 출력
	
	@ResponseBody
	@RequestMapping(value = "/adminmember/info")
	public MemberVo adminMemberInfo(MemberVo vo) {
		
		System.out.println(vo);
		MemberVo memberInfo = adminMemberService.adminMemberInfo(vo);
		System.out.println(vo);
		
		return memberInfo;
		
	}
	
	// AJAX 연결 회원정보 수정
	
	@ResponseBody
	@RequestMapping(value = "/adminmember/update")
	public String adminMemberUpdate(MemberVo vo) {
		
		System.out.println(vo);
		String data = "";
		
		int result = adminMemberService.adminMemberUpdate(vo);
		
		if (result != 1) {
			
			data = "error";
			
		}else {
			
			data = "success";
		}
		
		return data;
		
	}
	
	// AJAX 연결 회원정보 삭제
	
	@ResponseBody
	@RequestMapping(value = "/adminmember/delete")
	public String adminMemberDelete(MemberVo vo) {
		
		System.out.println("회정 정보 삭제");
		System.out.println(vo);
		String data = "";
		
		int result = adminMemberService.adminMemberDelete(vo);
		
		if (result != 1) {
			
			data = "error";
			
		}else {
			
			data = "success";
		}
		
		return data;
		
	}
	
	
	
	
}