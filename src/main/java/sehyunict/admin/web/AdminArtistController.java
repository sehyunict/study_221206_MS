package sehyunict.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
