package sehyunict.admin.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.admin.entity.AdminMemberVo;
import sehyunict.admin.entity.PageVo;

@Repository
public class AdminMemberMapper {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	
	//어드민 회원 조회
	public List<AdminMemberVo> adminMemberList(PageVo pvo) {
		
		return mybatis.selectList("mybatis.admin.memberlist", pvo);
		
	}
	
	//페이징 게시물 총 갯수
	public int adminMemberCount(PageVo pvo) {
		
		return mybatis.selectOne("mybatis.admin.membercount", pvo);
				
	}
	
	//선택회원 정보 불러오기
	public AdminMemberVo adminMemberInfo(AdminMemberVo vo){
		
		return mybatis.selectOne("mybatis.admin.memberinfo", vo);
		
	}
	
	//선택회원 정보 업데이트
	public int adminMemberUpdate(AdminMemberVo vo){
		
		return mybatis.update("mybatis.admin.memberupdate", vo);
	
	}
	
	//선택회원 정보 삭제
	public int adminMemberDelete(AdminMemberVo vo){
		
		return mybatis.delete("mybatis.admin.memberdelete", vo);
	
	}
	
	//체크박스 선택회원 정보 삭제
	public int adminMemberChDelete(int checkNum){
		
		return mybatis.delete("mybatis.admin.memberchdelete", checkNum);
	
	}
}
