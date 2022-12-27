package sehyunict.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sehyunict.admin.entity.AdminMemberVo;
import sehyunict.admin.entity.PageMaker;
import sehyunict.admin.entity.PageVo;
import sehyunict.admin.service.AdminMemberService;

@Controller
public class AdminMemberController {
	
	@Autowired
	private AdminMemberService adminMemberService;


	// 관리자 인덱스 페이지

	@RequestMapping(value = "/admin/Member") // 인덱스
	public String adminIndex(Model model, PageVo pvo) {
			
			
			model.addAttribute("adminMemberList", adminMemberService.adminMemberList(pvo));
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setPvo(pvo);
			pageMaker.setTotalCount(adminMemberService.adminMemberCount(pvo));
			System.out.println(pageMaker);
			
			model.addAttribute("pageMaker", pageMaker);
		
		return "admin/adminIndex";
		
	}
	
	// 선택회원 관리페이지 이동 및 no 값 전달만 (단일회원정보)
	
	@RequestMapping(value = "/admin/Member/user")
	public String admMemberInfo(Model model, AdminMemberVo vo) {
		
		model.addAttribute("member_no", vo.getMember_no());
		
		
		return "admin/adMemberInfo";
	} 
	
	// AJAX 연결 회원정보 출력
	
	@ResponseBody
	@RequestMapping(value = "/admin/Member/info", method = RequestMethod.POST)
	public AdminMemberVo adminMemberInfo(AdminMemberVo vo) {
		
		System.out.println("회원정보 출력");
		AdminMemberVo memberInfo = adminMemberService.adminMemberInfo(vo);
		System.out.println(vo);
		
		return memberInfo;
		
	}
	
	// AJAX 연결 회원정보 수정
	
	@ResponseBody
	@RequestMapping(value = "/admin/Member/update")
	public String adminMemberUpdate(AdminMemberVo vo) {
		
		System.out.println("회원정보 업데이트");
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
	@RequestMapping(value = "/admin/Member/delete")
	public String adminMemberDelete(AdminMemberVo vo) {
		
		System.out.println("회정정보 삭제");
		String data = "";
		
		int result = adminMemberService.adminMemberDelete(vo);
		
		if (result != 1) {
			
			data = "error";
			
		}else {
			
			data = "success";
		}
		
		return data;
		
	}
	
	
	// AJAX 연결 체크박스회원 삭제
	
	@ResponseBody
	@RequestMapping(value = "/admin/Member/chdelete")
	public String adminMemberChDelete(int[] checkList) {
		
		System.out.println(checkList[0]);
		
		String data = adminMemberService.adminMemberChDelete(checkList);
		
		return data;
	}
	
}