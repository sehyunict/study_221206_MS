package sehyunict.main.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sehyunict.main.entity.MusicVo;
import sehyunict.main.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<MusicVo> list = mainService.selectMusic();
		
		model.addAttribute("list", list);
		return "Main";
	}
}