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
	
	//관리자 앨범 정보 불러오기
	public AdminAlbumVo adminAlbumInfo(AdminAlbumVo vo) {
		
		return adminAlbumMapper.adminAlbumInfo(vo);
		
	}
	
	//관리자 앨범정보 수정
	public int adminAlbumUpdate(AdminAlbumVo vo) {
		
		return adminAlbumMapper.adminAlbumUpdate(vo);
	}
	
	//앨범 삭제
	public int adminAlbumDelete(AdminAlbumVo vo) {
		
		return adminAlbumMapper.adminAlbumDelete(vo);
		
	}
	
	//체크박스 선택앨범 삭제
	public String adminAlbumChDelete(int[] checkList) {
		
		int result = 0;
		String data = "";
		
		for (int i = 0; i < checkList.length; i++) {
			
			result += adminAlbumMapper.adminAlbumChDelete(checkList[i]);
		}
		
		if (result == checkList.length) {
			
			data = "success";
			
		}else {
			
			data = "fail";
		
		};
		
		
		return data;
		
	}
}
