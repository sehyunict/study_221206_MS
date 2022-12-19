package sehyunict.main.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sehyunict.main.entity.MainRankVo;
import sehyunict.main.entity.MainPlayListVo;
import sehyunict.main.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping("/")
	public String index(Model model) {
		int memberNo = 1;
		
		List<MainRankVo> rankList = mainService.selectRankList(memberNo);
		List<MainPlayListVo> playList = mainService.selectPlayList(memberNo);
		
		model.addAttribute("rankList", rankList);
		model.addAttribute("playList", playList);
		return "main";
	}
	
	@RequestMapping("/MIP")
	@ResponseBody
	public List<MainPlayListVo> InsertPlayList(@RequestBody List<Integer> musicList) {
		int memberNo = 1;
		
		return mainService.insertPlayList(memberNo, musicList);
	}
	
	@RequestMapping("/MDP")
	@ResponseBody
	public void deletePlayList(@RequestBody int musicNo) {
		mainService.deletePlayList(musicNo);
	}
	
	@RequestMapping("/MDCP")
	@ResponseBody
	public int deleteCheckPlayList(@RequestBody List<Integer> musicList) {
		return mainService.deleteCheckPlayList(musicList);
	}
	
	@RequestMapping("/MIL")
	@ResponseBody
	public void insertLike(@RequestBody int musicNo) {
		int memberNo = 1;
		
		mainService.insertLike(memberNo, musicNo);
	}
	
	@RequestMapping("/MDL")
	@ResponseBody
	public void deleteLike(@RequestBody int musicNo) {
		int memberNo = 1;
		
		mainService.deleteLike(memberNo, musicNo);
	}
	
	@RequestMapping("/MUP")
	@ResponseBody
	public int updatePlayCount(@RequestBody List<Integer> musicList) {
		return mainService.updatePlayCount(musicList);
	}
}