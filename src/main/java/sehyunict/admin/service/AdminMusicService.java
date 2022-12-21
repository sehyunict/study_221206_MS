package sehyunict.admin.service;

import java.util.List;

import sehyunict.admin.entity.AdminMemberVo;
import sehyunict.admin.entity.AdminMusicVo;
import sehyunict.admin.entity.PageVo;

public interface AdminMusicService {

	// 관리자 노래 리스트 조회
	List<AdminMusicVo> adminMusicList(PageVo pvo);
	
	// 페이징 전체 음악수 조회
	int adminMusicCount();
	
	// 선택음악 정보 조회
	AdminMusicVo adminMusicInfo(AdminMusicVo vo);
	
	// 음악정보 수정
	int adminMusicUpdate(AdminMusicVo vo);
	
	//	음악 삭제
	int adminMusicDelete(AdminMusicVo vo);
	
	// 체크박스 선택음악 삭제
	String adminMusicChDelete(int[] checkList);
}
