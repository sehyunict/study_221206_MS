package sehyunict.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.admin.entity.AdminMusicVo;
import sehyunict.admin.entity.PageVo;

@Repository
public class AdminMusicMapper {

	@Autowired
	private SqlSessionTemplate mybatis;

	
	//관리자 음악 조회
	public List<AdminMusicVo> adminMusicList(PageVo pvo) {
		
		return mybatis.selectList("mybatis.admin.musiclist", pvo);
		
	}
	
	//관리자 총 음악수 조회
	public int adminMusicCount() {
		
		return mybatis.selectOne("mybatis.admin.musiccount");
		
	}
	
	//관리자 음악 정보 조회
	public AdminMusicVo adminMusicInfo(AdminMusicVo vo) {
		
		return mybatis.selectOne("mybatis.admin.musicinfo", vo);
		
	}
	
	//관리자 음악 업데이트
	public int adminMusicUpdate(AdminMusicVo vo) {
		
		return mybatis.update("mybatis.admin.musicupdate", vo);
	
	}
	
	//선택회원 정보 삭제
	public int adminMusicDelete(AdminMusicVo vo){
			
		return mybatis.delete("mybatis.admin.musicdelete", vo);
		
	}	
	
	//관리자 체크박스 선택 음악 삭제
	public int adminMusicChDelete(int checkNum) {
			
			return mybatis.delete("mybatis.admin.musicchdelete", checkNum);
		
	}
	
	//insert 페이지 콤보박스 출력 album 정보 조회
	public List<Map<String, Object>> adminComboAlbum(String artistNo) {
		
		return mybatis.selectList("mybatis.admin.comboalbum", artistNo);
		
	}
	
	//insert 페이지 콤보박스 출력 artist 정보 조회
	public List<Map<String, Object>> adminComboArtist() {
		
		return mybatis.selectList("mybatis.admin.comboartist");
		
	}
	
	//음악 추가
	public int adminMusicInsert(AdminMusicVo vo) {

		return mybatis.insert("mybatis.admin.musicinsert", vo);
		
	}
}
