package sehyunict.member.album.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sehyunict.member.album.entity.AlbumVo;
import sehyunict.member.album.service.MemberAlbumService;

@Controller
public class MemberAlbumController {

	@Autowired
	private MemberAlbumService memberAlbumService;

	//사용자 앨범목록 조회
	@RequestMapping(value = "/ma", method = RequestMethod.GET)
	public String memberAlbum(Model model) {
		List<AlbumVo> list = memberAlbumService.selectMemberAlbum();
		model.addAttribute("list", list);
		return "album/MemberAlbumList";
	}
	

	//사용자 앨범 상세 조회
	@RequestMapping(value = "/ma/detail", method = RequestMethod.GET)
	public String memberAlbumDetail(@RequestParam("memberAlbumNo") Integer memberAlbumNo, Model model) {
		List<AlbumVo> list = memberAlbumService.selectMemberAlbumDetail(memberAlbumNo);
		model.addAttribute("memberDetailsList", list);
		return "album/MemberAlbumDetail";
	}
	
	//사용자 앨범이름 수정 화면
	@RequestMapping(value = "/ma/update", method = RequestMethod.GET)
	public String memberAblumTitleUpdateForm(@RequestParam("memberAlbumNo") Integer memberAlbumNo, Model model) {
		System.out.println(memberAlbumNo);
		AlbumVo mav = memberAlbumService.selectAlbumUpdate(memberAlbumNo);
		System.out.println(mav);
		model.addAttribute("mav", mav);
		return "album/MemberAlbumUpdateForm";
	}
	
	//사용자 앨범이름 수정 처리
	@RequestMapping(value = "/ma/update", method = RequestMethod.POST)
	public String memberAblumTitleUpdate(AlbumVo memberAlbumVo) {
		int result = memberAlbumService.updateMemberAlbumDetail(memberAlbumVo);
		System.out.println(result);
		return "redirect:/ma";
		
	}

	//사용자 앨범 삭제
	@ResponseBody
	@RequestMapping(value = "/ma/delete", method = RequestMethod.POST)
	public void memberAblumTitleDelete(@RequestBody Integer memberAlbumNo,
			HttpServletRequest request) {
		memberAlbumService.deleteMemberAlubm(memberAlbumNo);
	}
}
