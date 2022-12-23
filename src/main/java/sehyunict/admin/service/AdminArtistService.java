package sehyunict.admin.service;

import java.util.List;

import sehyunict.admin.entity.AdminArtistVo;
import sehyunict.admin.entity.PageVo;

public interface AdminArtistService {
	
	// 관리자 가수 리스트 조회
	List<AdminArtistVo> adminArtistList(PageVo pvo);
		
	// 페이징 전체 가수 조회
	int adminArtistCount();
	
	// 선택가수 정보 조회
	AdminArtistVo adminArtistInfo(AdminArtistVo vo);
	
	// 가수정보 수정
	int adminArtistUpdate(AdminArtistVo vo);
	
	// 가수 삭제
	int adminArtistDelete(AdminArtistVo vo);
	
	// 체크박스 선택가수 삭제
	String adminArtistChDelete(int[] checkList);

}
	