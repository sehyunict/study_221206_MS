package sehyunict.admin.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.admin.entity.PageVo;
import sehyunict.member.entity.MemberVo;

@Repository
public class AdminMemberMapper {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	
	//어드민 회원 조회
	public List<MemberVo> adminMemberList(PageVo pvo) {
		
		return mybatis.selectList("mybatis.admin.memberlist", pvo);
		
	}
	
	//페이징 게시물 총 갯수
	public int adminMemberCount(PageVo pvo) {
		
		return mybatis.selectOne("mybatis.admin.membercount", pvo);
				
	}
	
	//회원 검색
	public List<MemberVo> adminMemberSearch(){
		
		return mybatis.selectList("mybatis.admin.memberserach");
		
	}
	
	//선택회원 정보 불러오기
	public MemberVo adminMemberInfo(MemberVo vo){
		
		return mybatis.selectOne("mybatis.admin.memberinfo", vo);
		
	}
	
	//선택회원 정보 업데이트
	public int adminMemberUpdate(MemberVo vo){
		
		return mybatis.update("mybatis.admin.memberupdate", vo);
	
	}
	
	//선택회원 정보 삭제
	public int adminMemberDelete(MemberVo vo){
		
		return mybatis.delete("mybatis.admin.memberdelete", vo);
	
	}
}
