package sehyunict.member.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.member.entity.MemberVo;
import sehyunict.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper dao;
	
	// 회원 정보 조회
	@Transactional
	@Override
	public MemberVo memberInfo(int memberNo) {
		return dao.selectMember(memberNo);
	}
	
	// 회원 정보 수정
	@Transactional
	@Override
	public void memberUpdate(MemberVo memberVo) {
		try {
			dao.updateMember(memberVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 회원 탈퇴
	@Transactional
	@Override
	public int memberDelete(int memberNo) {
		return dao.deleteMemeber(memberNo);
	}
	
}
