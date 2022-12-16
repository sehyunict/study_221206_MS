package sehyunict.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.admin.entity.PageVo;
import sehyunict.admin.service.AdminMemberService;
import sehyunict.member.entity.MemberVo;

@Service
public class AdminMemberServiceImpl implements AdminMemberService{
	
	@Autowired
	private AdminMemberMapper adminMemberMapper;
	
	//유저 리스트 출력
	public List<MemberVo> adminMemberList(PageVo pvo) {
		
		return adminMemberMapper.adminMemberList(pvo);
		
	}
	
	//페이징 멤버 총 수
	public int adminMemberCount(PageVo pvo) {
		
		return adminMemberMapper.adminMemberCount(pvo);
		
	}
	
	//멤버 검색
	public List<MemberVo> adminMemberSearch() {
		
		return adminMemberMapper.adminMemberSearch();
				
	}
	
	//선택회원 관리페이지 (단일회원정보)
	public MemberVo adminMemberInfo(MemberVo vo) {
		
		return adminMemberMapper.adminMemberInfo(vo);
		
	}
	
	//선택회원 정보 업데이트
	public int adminMemberUpdate(MemberVo vo) {
		
		return adminMemberMapper.adminMemberUpdate(vo);
		
	}
	
	//선택회원 정보 삭제
	public int adminMemberDelete(MemberVo vo) {
		
		return adminMemberMapper.adminMemberDelete(vo);
		
	}
	
}
