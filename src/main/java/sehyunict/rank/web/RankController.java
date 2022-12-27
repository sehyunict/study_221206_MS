package sehyunict.rank.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sehyunict.main.entity.MainRankVo;
import sehyunict.rank.entity.RankAlbumVo;
import sehyunict.rank.service.RankService;

@Controller
public class RankController {
	
	@Autowired
	private RankService rankService;
	
	@RequestMapping("/RD")
	public String rankDay(Model model) {
		int memberNo = 1;
		
		List<MainRankVo> rankList = rankService.selectRankDayList(memberNo);
		List<RankAlbumVo> albumList = rankService.selectAlbumList(memberNo);
		
		model.addAttribute("albumList", albumList);
		model.addAttribute("rankList", rankList);
		return "rank/rankDay";
	}
	
	@RequestMapping("/RIA")
	@ResponseBody
	public int rankInsertAlbum(@RequestBody List<Integer> musicList) {
		return rankService.insertAlbum(musicList);
	}
}