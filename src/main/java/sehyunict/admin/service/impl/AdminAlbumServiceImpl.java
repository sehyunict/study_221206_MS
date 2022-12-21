package sehyunict.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.admin.entity.AdminAlbumVo;
import sehyunict.admin.entity.PageVo;
import sehyunict.admin.service.AdminAlbumService;

@Service
public class AdminAlbumServiceImpl implements AdminAlbumService{
	
	@Autowired AdminAlbumMapper adminAlbumMapper;

	
	//관리자 앨범 리스트 조회
	public List<AdminAlbumVo> adminAlbumList(PageVo pvo){
		
		return adminAlbumMapper.adminAlbumList(pvo);
		
	};
	
	//관리자 앨범 총 갯수 조회
	public int adminAlbumCount() {
		
		return adminAlbumMapper.adminAlbumCount();
		
	}
}
