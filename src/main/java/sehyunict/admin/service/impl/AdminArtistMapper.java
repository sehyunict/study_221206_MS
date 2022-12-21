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
	
	//관리자 앨범 조회
	public List<AdminArtistVo> adminArtistList(PageVo pvo) {
		
		return mybatis.selectList("mybatis.admin.artistlist", pvo);
		
	}
	
	//관리자 총 앨범수 조회
	public int adminArtistCount() {
		
		return mybatis.selectOne("mybatis.admin.artistcount");
		
	}

}
