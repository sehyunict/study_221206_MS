package sehyunict.admin.service;

import java.util.List;

import sehyunict.admin.entity.PageVo;
import sehyunict.member.entity.MemberVo;

public interface AdminMemberService {
	
	//리스트
	List<MemberVo> adminMemberList(PageVo pvo);
	
	//페이징 멤버 총 페이지 수
	int adminMemberCount(PageVo pvo);
	
	//멤버 검색
	List<MemberVo> adminMemberSearch();
	
	//선택회원 정보 불러오기
	MemberVo adminMemberInfo(MemberVo vo);
	
	//선택회원 정보 업테이트
	int adminMemberUpdate(MemberVo vo);
	
	//선택회원 정보 삭제
	int adminMemberDelete(MemberVo vo);
	
	
}
