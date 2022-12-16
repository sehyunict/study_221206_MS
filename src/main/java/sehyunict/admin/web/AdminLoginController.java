package sehyunict.admin.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sehyunict.admin.service.AdminLoginService;
import sehyunict.member.entity.MemberVo;

@Controller
public class AdminLoginController {
	
	@Autowired
	private AdminLoginService adminLoginService;
	
	// 관리자 로그인페이지

	@RequestMapping(value = "/admin")
	public String adminLogin() {

		return "/adminLogin";
	}

	// 관리자 로그인 체크

	@RequestMapping(value = "/adminLoginCheck")
	public String adminLoginCheck(MemberVo vo, HttpSession session) {

		String adminId = vo.getMEMBER_Id();
		String url;

		if (adminId.equals("admin")) {
			
			int result = adminLoginService.adminLoginCheck(vo);
			
			if (result == 0) {
				
				System.out.println("비밀번호가 일치하지 않습니다.");
				
				url = "/adminLogin";
			} else {
				
				session.setAttribute("adminId", adminId);
				  
				url = "redirect:/adminMember";
				  
			}
			
		} else {
			
			System.out.println("올바른 아이디로 로그인 바랍니다.");
			
			url = "/adminLogin";
			
		}

		System.out.println(vo);

		return url;
	}
	
}
