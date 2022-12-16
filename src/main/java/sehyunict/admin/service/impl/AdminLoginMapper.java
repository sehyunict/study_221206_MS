package sehyunict.admin.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.member.entity.MemberVo;

@Repository
public class AdminLoginMapper {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public int adminLoginCheck(MemberVo vo) {
		  
		return mybatis.selectOne("mybatis.admin.adminlogincheck", vo);
	 
	}
}
