package sehyunict.member.service;

import sehyunict.member.entity.MemberVo;

public interface MemberService {
	
	// 회원 정보 조회
	public MemberVo memberInfo(int memberNo);
	
	// 회원 정보 수정
	public void memberUpdate(MemberVo memberVo);
	
	// 회원 삭제
	public int memberDelete(int memberNo);
	
}
