package sehyunict.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.admin.entity.AdminMusicVo;
import sehyunict.admin.entity.PageVo;
import sehyunict.admin.service.AdminMusicService;

@Service
public class AdminMusicServiceImpl implements AdminMusicService{

	@Autowired AdminMusicMapper adminMusicMapper;
	
	//관리자 뮤직 리스트 조회
	public List<AdminMusicVo> adminMusicList(PageVo pvo){
		
		return adminMusicMapper.adminMusicList(pvo);
		
	};
	
	//관리자 뮤직 총 갯수 조회
	public int adminMusicCount() {
		
		return adminMusicMapper.adminMusicCount();
		
	}
	
	//관리자 뮤직 정보 불러오기
	public AdminMusicVo adminMusicInfo(AdminMusicVo vo) {
		
		return adminMusicMapper.adminMusicInfo(vo);
		
	}
	
	//관리자 음악정보 수정
	public int adminMusicUpdate(AdminMusicVo vo) {
		
		return adminMusicMapper.adminMusicUpdate(vo);
	}
	
	//음악 삭제
	public int adminMusicDelete(AdminMusicVo vo) {
		
		return adminMusicMapper.adminMusicDelete(vo);
		
	}
	
	//체크박스 선택음악 삭제
	public String adminMusicChDelete(int[] checkList) {
		
		int result = 0;
		String data = "";
		
		for (int i = 0; i < checkList.length; i++) {
			
			result += adminMusicMapper.adminMusicChDelete(checkList[i]);
		}
		
		if (result == checkList.length) {
			
			data = "success";
			
		}else {
			
			data = "fail";
		
		}
		
		
		return data;
		
	}
	
	// insert 페이지 콤보박스 출력 album 정보 조회
	public List<Map<String, Object>> adminComboAlbum(String artistNo){
		
		return adminMusicMapper.adminComboAlbum(artistNo);
		
	}
	
	// insert 페이지 콤보박스 출력 artist 정보 조회
	public List<Map<String, Object>> adminComboArtist(){
		
		return adminMusicMapper.adminComboArtist();
		
	}

	// 음악 추가
	public int adminMusicInsert(AdminMusicVo vo) {
		
		return adminMusicMapper.adminMusicInsert(vo);
		
	}
}
