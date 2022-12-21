package sehyunict.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sehyunict.admin.entity.AdminMemberVo;
import sehyunict.admin.entity.AdminMusicVo;
import sehyunict.admin.entity.PageMaker;
import sehyunict.admin.entity.PageVo;
import sehyunict.admin.service.AdminMusicService;

@Controller
public class AdminMusicController {
	
	@Autowired
	private AdminMusicService adminMusicService;

	
	//뮤직리스트
	@RequestMapping(value = "/adminMusic") 
	public String adminMusicList(PageVo pvo ,Model model) {
		
		model.addAttribute ("adminMusicList", adminMusicService.adminMusicList(pvo));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPvo(pvo);
		pageMaker.setTotalCount(adminMusicService.adminMusicCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		
		return "admin/adminMusic";
		
	}
	
	// insert 페이지 이동
	@RequestMapping(value = "/adMusicInsert") 
	public String adminMuscicInsertPage() {
		

		return "admin/adMusicInsert";
	}
	
	
	//음악 인서트 (미구현)
	@RequestMapping(value = "/adminMusic/insert") 
	public void adminMuscicInsert(AdminMusicVo vo) {
		
		
	}
	
	// info 페이지 이동
	@RequestMapping(value = "/adMusicInfo") 
	public String admMusicInfoPage(Model model, AdminMusicVo vo) {
		
		model.addAttribute("music_no", vo.getMusic_no());
		
		return "admin/adMusicInfo";
	} 
	
	// info 선택 정보 출력
	@RequestMapping(value = "/adminMusic/info") 
	@ResponseBody
	public AdminMusicVo adMusicInfo(AdminMusicVo vo) {
		
		
		AdminMusicVo musicInfo = adminMusicService.adminMusicInfo(vo);
		
		
		return musicInfo;
	}
	
	// 음악 업데이트
	@RequestMapping(value = "/adminMusic/update") 
	@ResponseBody
	public String admMusicUpdate(AdminMusicVo vo) {
		
		String data="";
		
		System.out.println("업데이트" + vo);
		
 		int result = adminMusicService.adminMusicUpdate(vo);
 		
 		if (result == 1 ) {
		
 			data = "success";
 			
 		}else {
 			
 			data = "fail";
 			
 		}
 		
		return data;
	}
	
	// AJAX 연결 음악정보 삭제
	
	@ResponseBody
	@RequestMapping(value = "/adminMusic/delete")
	public String adminMusicDelete(AdminMusicVo vo) {
		
		System.out.println("음악정보 삭제");
		String data = "";
		
		int result = adminMusicService.adminMusicDelete(vo);
		
		if (result != 1) {
			
			data = "error";
			
		}else {
			
			data = "success";
		}
		
		return data;
		
	}
	
	// AJAX 연결 체크박스회원 삭제
	@RequestMapping(value = "/adminMusic/chdelete") 
	@ResponseBody
	public String adminMusicChDelete(int[] checkList) {
		
		
		String data = adminMusicService.adminMusicChDelete(checkList);
		
		return data;
	}
	
}

