package sehyunict.admin.service;

import java.util.List;

import sehyunict.admin.entity.AdminMemberVo;
import sehyunict.admin.entity.PageVo;

public interface AdminMemberService {
	
	//리스트
	List<AdminMemberVo> adminMemberList(PageVo pvo);
	
	//페이징 멤버 총 페이지 수
	int adminMemberCount(PageVo pvo);
	
	//선택회원 정보 불러오기
	AdminMemberVo adminMemberInfo(AdminMemberVo vo);
	
	//선택회원 정보 업테이트
	int adminMemberUpdate(AdminMemberVo vo);
	
	//선택회원 정보 삭제
	int adminMemberDelete(AdminMemberVo vo);
	
	//체크박스 선택회원 정보 삭제
	String adminMemberChDelete(int[] checkList);
}
