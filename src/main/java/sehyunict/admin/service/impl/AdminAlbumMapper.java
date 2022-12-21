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
	public int adminAlbumCount() {
		
		return mybatis.selectOne("mybatis.admin.albumcount");
		
	}
}
