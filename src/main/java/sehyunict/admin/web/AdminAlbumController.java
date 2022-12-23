package sehyunict.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sehyunict.admin.entity.AdminAlbumVo;
import sehyunict.admin.entity.PageMaker;
import sehyunict.admin.entity.PageVo;
import sehyunict.admin.service.AdminAlbumService;

@Controller
public class AdminAlbumController {
	
	@Autowired
	private AdminAlbumService adminAlbumService;
	
	//앨범리스트
		@RequestMapping(value = "/adminAlbum") 
		public String adminAlbumList(PageVo pvo ,Model model) {
			
			model.addAttribute ("adminAlbumList", adminAlbumService.adminAlbumList(pvo));
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setPvo(pvo);
			pageMaker.setTotalCount(adminAlbumService.adminAlbumCount());
			
			model.addAttribute("pageMaker", pageMaker);
			
			
			return "admin/adminAlbum";
			
		}

		// info 페이지 이동
		@RequestMapping(value = "/adAlbumInfo") 
		public String admAlbumInfoPage(Model model, AdminAlbumVo vo) {
			
			model.addAttribute("album_no", vo.getAlbum_no());
			
			return "admin/adAlbumInfo";
		} 
		
		// info 선택 정보 출력
		@RequestMapping(value = "/adminAlbum/info") 
		@ResponseBody
		public AdminAlbumVo adAlbumInfo(AdminAlbumVo vo) {
			
			
			AdminAlbumVo albumInfo = adminAlbumService.adminAlbumInfo(vo);
			System.out.println("앨범정보 불러오기" + albumInfo);
			
			return albumInfo;
		}
		
		// 앨범 업데이트
		@RequestMapping(value = "/adminAlbum/update") 
		@ResponseBody
		public String admAlbumUpdate(AdminAlbumVo vo) {
			
			String data="";
			
			System.out.println("업데이트" + vo);
			
	 		int result = adminAlbumService.adminAlbumUpdate(vo);
	 		
	 		if (result == 1 ) {
			
	 			data = "success";
	 			
	 		}else {
	 			
	 			data = "fail";
	 			
	 		}
	 		
			return data;
		}
		
		// AJAX 연결 앨범정보 삭제
		
		@ResponseBody
		@RequestMapping(value = "/adminAlbum/delete")
		public String adminAlbumDelete(AdminAlbumVo vo) {
			
			System.out.println("음악정보 삭제");
			String data = "";
			
			int result = adminAlbumService.adminAlbumDelete(vo);
			
			if (result != 1) {
				
				data = "error";
				
			}else {
				
				data = "success";
			}
			
			return data;
			
		}
		
		// AJAX 연결 체크박스앨범 삭제
		
		@RequestMapping(value = "/adminAlbum/chdelete") 
		@ResponseBody
		public String adminMusicChDelete(int[] checkList) {
			
			
			String data = adminAlbumService.adminAlbumChDelete(checkList);
			
			return data;
		}
		
	
}
