package sehyunict.main.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.main.entity.MusicVo;

@Repository
public class MainMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<MusicVo> selectMusic() {
		return sqlSession.selectList("mybatis.main.selectMusic");
	}
}
