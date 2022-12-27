package sehyunict.member.service.impl;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.member.entity.MemberVo;

@Repository
public class MemberMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 회원 정보 조회
	public MemberVo selectMember(int memberNo) {
		
		return sqlSession.selectOne("mybatis.member.selectMember", memberNo);
	}
	
	// 회원 정보 수정
	public void updateMember(MemberVo memberVo) throws SQLException {
		sqlSession.update("mybatis.member.updateMember", memberVo);
	}
	
	// 회원 탈퇴
	public int deleteMemeber(int memberNo) {
		// 탈퇴 방지위해 주석처리
		//return sqlSession.delete("mybatis.member.deleteMember", memberNo);
		return 1;
	}
	
}