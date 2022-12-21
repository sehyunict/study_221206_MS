package sehyunict.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
