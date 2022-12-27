package sehyunict.music.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sehyunict.music.entity.AlbumDetailVo;
import sehyunict.music.entity.ArtistDetailVo;
import sehyunict.music.entity.MusicDetailVo;
import sehyunict.music.entity.MusicSearchVo;
import sehyunict.music.service.MusicService;

@Controller
public class MusicController {

	@Autowired
	private MusicService musicService;

	/* 음악검색 */
	@RequestMapping("/MS")
	public String musicSearch(HttpServletRequest request, Model model) throws Exception {
		String search = request.getParameter("search");
		List<MusicSearchVo> list = musicService.musicSearch(search);
		model.addAttribute("list", list);
		return "/music/musicSearch";
	}

	/* 음악상세페이지 */
	@RequestMapping("/MD")
	public String musicDetail(Model model, int musicNo) throws Exception {
		List<MusicDetailVo> list = musicService.musicDetail(musicNo);
		model.addAttribute("list", list);
		return "/music/musicDetail";
	}

	/* 앨범상세페이지 */
	@RequestMapping("/AD")
	public String albumDetail(Model model, int albumNo) throws Exception {
		List<AlbumDetailVo> list = musicService.albumDetail(albumNo);
		model.addAttribute("list", list);
		return "/music/albumDetail";
	}

	/* 아티스트상세페이지 */
	@RequestMapping("/ATD")
	public String artistDetail(Model model, int artistNo) throws Exception{
		List<ArtistDetailVo> list = musicService.artistDetail(artistNo);
		model.addAttribute("list", list);
		return "/music/artistDetail";
	}

	/* 플레이리스트 추가 */
	@RequestMapping("/MD/PLI")
	public void playlistInsertMusic(@RequestBody int musicNo) throws Exception {
		musicService.playlistInsert(musicNo);
	}

	
	/* 마이앨범 추가 */	  
	  @RequestMapping("/MD/MAI") 
	  public void myAlbumInsertMusic(@RequestBody  MusicDetailVo musicDetail) throws Exception {
		  musicService.myAlbumInsert(musicDetail); 
		}

	/* 앨범 좋아요 */
	@ResponseBody
	@RequestMapping("/AD/LI")
	public void albumLikeInsertHeart(@RequestBody int albumNo) throws Exception {
		musicService.albumLikeInsert(albumNo);
	}
	
	/* 앨범 좋아요 취소 */
	@ResponseBody
	@RequestMapping("/AD/LD")
	public void albumLikeDeleteHeart(@RequestBody int albumNo) throws Exception {
		musicService.albumLikeDelete(albumNo);
	}

	/* 노래 좋아요 */
	@ResponseBody
	@RequestMapping("/MD/LI")
	public void musicLikeInsertHeart(@RequestBody int musicNo) throws Exception {
		musicService.musicLikeInsert(musicNo);
	}	

	/* 노래 좋아요 취소 */
	@ResponseBody
	@RequestMapping("/MD/LD")
	public void musicLikeDeleteHeart(@RequestBody int musicNo) throws Exception {
		musicService.musicLikeDelete(musicNo);
	}

	/* 팬 */
	@ResponseBody
	@RequestMapping("/ATD/FI")
	public void fanInsertHeart(@RequestBody int artistNo) throws Exception {
		musicService.fanInsert(artistNo);
	}

	/* 팬 취소 */
	@ResponseBody
	@RequestMapping("/ATD/FD")
	public void fanDeleteHeart(@RequestBody int artistNo) throws Exception {
		musicService.fanDelete(artistNo);
	}
}