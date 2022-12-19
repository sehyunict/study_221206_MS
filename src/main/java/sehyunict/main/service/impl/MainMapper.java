package sehyunict.main.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.main.entity.MainRankVo;
import sehyunict.main.entity.MainPlayListVo;

@Repository
public class MainMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<MainRankVo> selectRankList(int memberNo) {
		return sqlSession.selectList("mybatis.main.selectRankList", memberNo);
	}

	public List<MainPlayListVo> selectPlayList(int memberNo) {
		return sqlSession.selectList("mybatis.main.selectPlayList", memberNo);
	}
	
	public void insertPlayList(Map<String, Integer> map) {
		sqlSession.insert("mybatis.main.insertPlayList", map);
	}
	
	public List<MainPlayListVo> selectInsertPlayList(Map<String, Integer> map) {
		return sqlSession.selectList("mybatis.main.selectInsertPlayList", map);
	}
	
	public int deletePlayList(int musicNo) {
		return sqlSession.delete("mybatis.main.deletePlayList", musicNo);
	}
	
	public void insertLike(Map<String, Integer> map) {
		sqlSession.insert("mybatis.main.insertLike", map);
	}
	
	public void updateInertLike(int musicNo) {
		sqlSession.update("mybatis.main.updateInertLike", musicNo);
	}
	
	public void deleteLike(Map<String, Integer> map) {
		sqlSession.delete("mybatis.main.deleteLike", map);
	}
	
	public void updateDeleteLike(int musicNo) {
		sqlSession.update("mybatis.main.updateDeleteLike", musicNo);
	}
	
	public int updatePlayCount(int musicNo) {
		return sqlSession.update("mybatis.main.updatePlayCount", musicNo);
	}
}