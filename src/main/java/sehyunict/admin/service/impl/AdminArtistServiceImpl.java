package sehyunict.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.admin.entity.AdminArtistVo;
import sehyunict.admin.entity.PageVo;
import sehyunict.admin.service.AdminArtistService;

@Service
public class AdminArtistServiceImpl implements AdminArtistService {
	
	@Autowired AdminArtistMapper adminArtistMapper;
	
	
	//관리자 앨범 리스트 조회
	public List<AdminArtistVo> adminArtistList(PageVo pvo){
		
		return adminArtistMapper.adminArtistList(pvo);
		
	};
	
	//관리자 앨범 총 갯수 조회
	public int adminArtistCount() {
		
		return adminArtistMapper.adminArtistCount();
		
	}


}
