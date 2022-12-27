package sehyunict.admin.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.admin.entity.AdminAlbumVo;
import sehyunict.admin.entity.PageVo;

@Repository
public class AdminAlbumMapper {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//관리자 앨범 조회
	public List<AdminAlbumVo> adminAlbumList(PageVo pvo) {
		
		return mybatis.selectList("mybatis.admin.albumlist", pvo);
		
	}
	
	//관리자 총 앨범수 조회
	public int adminAlbumCount(PageVo pvo) {
		
		return mybatis.selectOne("mybatis.admin.albumcount", pvo);
		
	}
	
	//관리자 앨범 정보 조회
	public AdminAlbumVo adminAlbumInfo(AdminAlbumVo vo) {
		
		return mybatis.selectOne("mybatis.admin.albuminfo", vo);
		
	}
	
	//관리자 앨범 업데이트
	public int adminAlbumUpdate(AdminAlbumVo vo) {
		
		return mybatis.update("mybatis.admin.albumupdate", vo);
	
	}
	
	//선택 앨범 삭제
	public int adminAlbumDelete(AdminAlbumVo vo){
			
		return mybatis.delete("mybatis.admin.albumdelete", vo);
		
	}	
	
	//관리자 체크박스 선택 앨범 삭제
	public int adminAlbumChDelete(int checkNum) {
			
		return mybatis.delete("mybatis.admin.albumchdelete", checkNum);
		
	}
}
