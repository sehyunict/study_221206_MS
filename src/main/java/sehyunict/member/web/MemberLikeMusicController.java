package sehyunict.member.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sehyunict.member.entity.Criteria;
import sehyunict.member.entity.MemberFanVo;
import sehyunict.member.entity.MemberLikeAlbumVo;
import sehyunict.member.entity.MemberLikeMusicVo;
import sehyunict.member.entity.PageVo;
import sehyunict.member.service.MemberLikeMusicService;

@Controller
public class MemberLikeMusicController {
	
	@Autowired
	private MemberLikeMusicService service;
	
	// 좋아요 한 곡 조회 (페이징 적용)
	@RequestMapping("/MLM")
	public String memberLikeMusicList(Model model, Criteria cri) {
		
		List<MemberLikeMusicVo> memberMusicVo = service.selectMusicList(cri);
		
		model.addAttribute("memberMusicVo", memberMusicVo);
		
		int total = service.getMusicTotal();
		
		PageVo vo = new PageVo(cri, total);
		
		model.addAttribute("pageMaker", vo);

		return "member/memberLikeMusic";
	}
	
	// 좋아요 한 곡 삭제
	@RequestMapping("/MLMD")
	@ResponseBody
	public int memberLikeMusicDelete(@RequestBody int musicNo) {
		
		return service.deleteMusic(musicNo);
	}
	
	// 좋아요 한 앨범 조회 (페이징 적용)
	@RequestMapping("/MLA")
	public String memberLikeAlbum(Model model, Criteria cri) {
		
		List<MemberLikeAlbumVo> memberAlbumVo = service.selectAlbumList(cri);

		model.addAttribute("memberAlbumVo", memberAlbumVo);
		
		int total = service.getAlbumTotal();
		
		PageVo vo = new PageVo(cri, total);
		
		model.addAttribute("pageMaker", vo);
		
		return "member/memberLikeAlbum";
	}
	
	// 좋아요 한 앨범 삭제
	@RequestMapping("/MLAD")
	@ResponseBody
	public int memberLikeAlbumDelete(@RequestBody int albumNo) {
		
		return service.deleteAlbum(albumNo);
	}
	
	// 좋아요 한 팬 조회 (페이징 적용)
	@RequestMapping("/MF")
	public String memberFan(Model model, Criteria cri) {
		
		List<MemberFanVo> memberFanVo = service.selectFanList(cri);
		
		model.addAttribute("memberFanVo", memberFanVo);
		
		int total = service.getFanTotal();
		
		PageVo vo = new PageVo(cri, total);
		
		model.addAttribute("pageMaker", vo);
		
		return "member/memberFan";
	}
	
	// 좋아요 한 팬 삭제
	@RequestMapping("/MFD")
	@ResponseBody
	public int memberLikeFanDelete(@RequestBody int fanNo) {
		
		return service.deleteFan(fanNo);
	}
	
}
