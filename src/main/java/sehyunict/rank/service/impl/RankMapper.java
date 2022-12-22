package sehyunict.rank.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.main.entity.MainRankVo;
import sehyunict.rank.entity.RankAlbumVo;

@Repository
public class RankMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<MainRankVo> selectRankDayList(Map<String, String> map) {
		return sqlSession.selectList("mybatis.rank.selectRankDayList", map);
	}

	public List<RankAlbumVo> selectAlbumList(int memberNo) {
		return sqlSession.selectList("mybatis.rank.selectAlbumList", memberNo);
	}

	public int insertAlbum(Map<String, Integer> map) {
		return sqlSession.insert("mybatis.rank.insertAlbum", map);
	}
}