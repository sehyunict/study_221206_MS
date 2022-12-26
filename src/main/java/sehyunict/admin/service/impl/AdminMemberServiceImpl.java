package sehyunict.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.admin.entity.AdminMemberVo;
import sehyunict.admin.entity.PageVo;
import sehyunict.admin.service.AdminMemberService;

@Service
public class AdminMemberServiceImpl implements AdminMemberService{
	
	@Autowired
	private AdminMemberMapper adminMemberMapper;
	
	//유저 리스트 출력
	public List<AdminMemberVo> adminMemberList(PageVo pvo) {
		
		return adminMemberMapper.adminMemberList(pvo);
		
	}
	
	//페이징 멤버 총 수
	public int adminMemberCount(PageVo pvo) {
		
		return adminMemberMapper.adminMemberCount(pvo);
		
	}
	
	//선택회원 관리페이지 (단일회원정보)
	public AdminMemberVo adminMemberInfo(AdminMemberVo vo) {
		
		return adminMemberMapper.adminMemberInfo(vo);
		
	}
	
	//선택회원 정보 업데이트
	public int adminMemberUpdate(AdminMemberVo vo) {
		
		return adminMemberMapper.adminMemberUpdate(vo);
		
	}
	
	//선택회원 정보 삭제
	public int adminMemberDelete(AdminMemberVo vo) {
		
		return adminMemberMapper.adminMemberDelete(vo);
		
	}
	
	//체크박스 회원 정보 삭제
	public String adminMemberChDelete(int[] checkList) {
		
		int result = 0;
		String data = "";
		
		for (int i = 0; i < checkList.length; i++) {
			
			result += adminMemberMapper.adminMemberChDelete(checkList[i]);
			
		}
		
		if (result == checkList.length) {
			
			data = "success";
			
		}else {
			
			data = "fail";
		
		};
		
		
		return data;
		
	}
	
}
