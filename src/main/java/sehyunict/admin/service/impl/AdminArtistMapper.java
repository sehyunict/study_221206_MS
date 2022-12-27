package sehyunict.admin.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.admin.entity.AdminArtistVo;
import sehyunict.admin.entity.PageVo;

@Repository
public class AdminArtistMapper {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//관리자 가수 조회
	public List<AdminArtistVo> adminArtistList(PageVo pvo) {
		
		return mybatis.selectList("mybatis.admin.artistlist", pvo);
		
	}
	
	//관리자 총 가수 수 조회
	public int adminArtistCount(PageVo pvo) {
		
		return mybatis.selectOne("mybatis.admin.artistcount", pvo);
		
	}

	//관리자 가수 정보 조회
	public AdminArtistVo adminArtistInfo(AdminArtistVo vo) {
		
		return mybatis.selectOne("mybatis.admin.artistinfo", vo);
		
	}
	
	//관리자 가수 업데이트
	public int adminArtistUpdate(AdminArtistVo vo) {
		
		return mybatis.update("mybatis.admin.artistupdate", vo);
	
	}
	
	//가수 삭제
	public int adminArtistDelete(AdminArtistVo vo){
			
		return mybatis.delete("mybatis.admin.artistdelete", vo);
		
	}	
	
	//관리자 체크박스 선택 가수 삭제
	public int adminArtistChDelete(int checkNum) {
			
		return mybatis.delete("mybatis.admin.artistchdelete", checkNum);
		
	}

}
