package sehyunict.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.admin.entity.AdminMemberVo;
import sehyunict.admin.service.AdminLoginService;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	@Autowired
	private AdminLoginMapper adMpper;
	
	
	public int adminLoginCheck(AdminMemberVo vo) {
		
		return adMpper.adminLoginCheck(vo);
		
	}
	
	
}
