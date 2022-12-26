package sehyunict.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sehyunict.admin.entity.AdminArtistVo;
import sehyunict.admin.entity.PageMaker;
import sehyunict.admin.entity.PageVo;
import sehyunict.admin.service.AdminArtistService;

@Controller
public class AdminArtistController {

	@Autowired
	private AdminArtistService adminArtistService;
	
	//앨범리스트
	@RequestMapping(value = "/adminArtist") 
	public String adminArtistList(PageVo pvo ,Model model) {
		
		model.addAttribute ("adminArtistList", adminArtistService.adminArtistList(pvo));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPvo(pvo);
		pageMaker.setTotalCount(adminArtistService.adminArtistCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		
		return "admin/adminArtist";
		
	}
	// info 페이지 이동
	@RequestMapping(value = "/adArtistInfo") 
	public String admArtistInfoPage(Model model, AdminArtistVo vo) {
		
		model.addAttribute("artist_no", vo.getArtist_no());
		
		return "admin/adArtistInfo";
	} 
	
	// info 선택 정보 출력
	@RequestMapping(value = "/adminArtist/info") 
	@ResponseBody
	public AdminArtistVo adArtistInfo(AdminArtistVo vo) {
		
		
		AdminArtistVo artistInfo = adminArtistService.adminArtistInfo(vo);
		System.out.println("앨범정보 불러오기" + artistInfo);
		
		return artistInfo;
	}
	
	// 앨범 업데이트
	@RequestMapping(value = "/adminArtist/update") 
	@ResponseBody
	public String admArtistUpdate(AdminArtistVo vo) {
		
		String data="";
		
		System.out.println("업데이트" + vo);
		
 		int result = adminArtistService.adminArtistUpdate(vo);
 		
 		if (result == 1 ) {
		
 			data = "success";
 			
 		}else {
 			
 			data = "fail";
 			
 		}
 		
		return data;
	}
	
	// AJAX 연결 앨범정보 삭제
	
	@ResponseBody
	@RequestMapping(value = "/adminArtist/delete")
	public String adminArtistDelete(AdminArtistVo vo) {
		
		System.out.println("음악정보 삭제");
		String data = "";
		
		int result = adminArtistService.adminArtistDelete(vo);
		
		if (result != 1) {
			
			data = "error";
			
		}else {
			
			data = "success";
		}
		
		return data;
		
	}
	
	// AJAX 연결 체크박스앨범 삭제
	
	@RequestMapping(value = "/adminArtist/chdelete") 
	@ResponseBody
	public String adminMusicChDelete(int[] checkList) {
		
		
		String data = adminArtistService.adminArtistChDelete(checkList);
		
		return data;
	}
		
	

}
