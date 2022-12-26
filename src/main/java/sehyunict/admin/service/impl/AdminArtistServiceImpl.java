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
	
	
	//관리자 가수 리스트 조회
	public List<AdminArtistVo> adminArtistList(PageVo pvo){
		
		return adminArtistMapper.adminArtistList(pvo);
		
	};
	
	//관리자 가수 총명수 조회
	public int adminArtistCount() {
		
		return adminArtistMapper.adminArtistCount();
		
	}
	
	//관리자 가수정보 불러오기
	public AdminArtistVo adminArtistInfo(AdminArtistVo vo) {
		
		return adminArtistMapper.adminArtistInfo(vo);
		
	}
	
	//관리자 가수정보 수정
	public int adminArtistUpdate(AdminArtistVo vo) {
		
		return adminArtistMapper.adminArtistUpdate(vo);
	}
	
	//가수 삭제
	public int adminArtistDelete(AdminArtistVo vo) {
		
		return adminArtistMapper.adminArtistDelete(vo);
		
	}
	
	//체크박스 선택가수 삭제
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
