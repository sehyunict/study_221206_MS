package sehyunict.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.admin.entity.AdminMemberVo;
import sehyunict.admin.service.AdminLoginService;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	@Autowired
	private AdminLoginMapper adMpper;
	
	@Transactional
	public int adminLoginCheck(AdminMemberVo vo) {
		
		return adMpper.adminLoginCheck(vo);
		
	}
	
	
}
