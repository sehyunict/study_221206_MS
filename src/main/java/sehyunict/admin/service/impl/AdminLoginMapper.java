package sehyunict.admin.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.admin.entity.AdminMemberVo;

@Repository
public class AdminLoginMapper {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public int adminLoginCheck(AdminMemberVo vo) {
		  
		return mybatis.selectOne("mybatis.admin.adminlogincheck", vo);
	 
	}
}
