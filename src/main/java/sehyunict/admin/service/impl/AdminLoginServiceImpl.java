package sehyunict.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.admin.service.AdminLoginService;
import sehyunict.member.entity.MemberVo;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	@Autowired
	private AdminLoginMapper adMpper;
	
	
	public int adminLoginCheck(MemberVo vo) {
		
		return adMpper.adminLoginCheck(vo);
		
	}
	
	
}
