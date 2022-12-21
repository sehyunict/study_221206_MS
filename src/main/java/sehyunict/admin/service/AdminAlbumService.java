package sehyunict.admin.service;

import java.util.List;

import sehyunict.admin.entity.AdminAlbumVo;
import sehyunict.admin.entity.PageVo;

public interface AdminAlbumService {

	// 관리자 앨범 리스트 조회
	List<AdminAlbumVo> adminAlbumList(PageVo pvo);
		
	// 페이징 전체 앨범수 조회
	int adminAlbumCount();
	
}
