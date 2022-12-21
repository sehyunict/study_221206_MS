package sehyunict.admin.service;

import java.util.List;

import sehyunict.admin.entity.AdminArtistVo;
import sehyunict.admin.entity.PageVo;

public interface AdminArtistService {
	
	// 관리자 가수 리스트 조회
	List<AdminArtistVo> adminArtistList(PageVo pvo);
		
	// 페이징 전체 가수 조회
	int adminArtistCount();

}
