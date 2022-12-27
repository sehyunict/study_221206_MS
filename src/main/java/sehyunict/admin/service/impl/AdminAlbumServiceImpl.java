package sehyunict.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.admin.entity.AdminAlbumVo;
import sehyunict.admin.entity.PageVo;
import sehyunict.admin.service.AdminAlbumService;

@Service
public class AdminAlbumServiceImpl implements AdminAlbumService{
	
	@Autowired AdminAlbumMapper adminAlbumMapper;
	
	
	//관리자 앨범 리스트 조회
	@Transactional
	public List<AdminAlbumVo> adminAlbumList(PageVo pvo){
		
		return adminAlbumMapper.adminAlbumList(pvo);
		
	};
	
	//관리자 앨범 총 갯수 조회
	@Transactional
	public int adminAlbumCount(PageVo pvo) {
		
		return adminAlbumMapper.adminAlbumCount(pvo);
		
	}
	
	//관리자 앨범 정보 불러오기
	@Transactional
	public AdminAlbumVo adminAlbumInfo(AdminAlbumVo vo) {
		
		return adminAlbumMapper.adminAlbumInfo(vo);
		
	}
	
	//관리자 앨범정보 수정
	@Transactional
	public int adminAlbumUpdate(AdminAlbumVo vo) {
		
		return adminAlbumMapper.adminAlbumUpdate(vo);
	}
	
	//앨범 삭제
	@Transactional
	public int adminAlbumDelete(AdminAlbumVo vo) {
		
		return adminAlbumMapper.adminAlbumDelete(vo);
		
	}
	
	//체크박스 선택앨범 삭제
	@Transactional
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
