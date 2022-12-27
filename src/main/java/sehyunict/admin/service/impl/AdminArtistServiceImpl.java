package sehyunict.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.admin.entity.AdminArtistVo;
import sehyunict.admin.entity.PageVo;
import sehyunict.admin.service.AdminArtistService;

@Service
public class AdminArtistServiceImpl implements AdminArtistService {
	
	@Autowired AdminArtistMapper adminArtistMapper;
	
	
	//관리자 가수 리스트 조회
	@Transactional
	public List<AdminArtistVo> adminArtistList(PageVo pvo){
		
		return adminArtistMapper.adminArtistList(pvo);
		
	};
	
	//관리자 가수 총명수 조회
	@Transactional
	public int adminArtistCount(PageVo pvo) {
		
		return adminArtistMapper.adminArtistCount(pvo);
		
	}
	
	//관리자 가수정보 불러오기
	@Transactional
	public AdminArtistVo adminArtistInfo(AdminArtistVo vo) {
		
		return adminArtistMapper.adminArtistInfo(vo);
		
	}
	
	//관리자 가수정보 수정
	@Transactional
	public int adminArtistUpdate(AdminArtistVo vo) {
		
		return adminArtistMapper.adminArtistUpdate(vo);
	}
	
	//가수 삭제
	@Transactional
	public int adminArtistDelete(AdminArtistVo vo) {
		
		return adminArtistMapper.adminArtistDelete(vo);
		
	}
	
	//체크박스 선택가수 삭제
	@Transactional
	public String adminArtistChDelete(int[] checkList) {
		
		int result = 0;
		String data = "";
		
		for (int i = 0; i < checkList.length; i++) {
			
			result += adminArtistMapper.adminArtistChDelete(checkList[i]);
		}
		
		if (result == checkList.length) {
			
			data = "success";
			
		}else {
			
			data = "fail";
		
		};
		
		
		return data;
		
	}


}
