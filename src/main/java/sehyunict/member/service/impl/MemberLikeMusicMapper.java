package sehyunict.member.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.member.entity.Criteria;
import sehyunict.member.entity.MemberFanVo;
import sehyunict.member.entity.MemberLikeAlbumVo;
import sehyunict.member.entity.MemberLikeMusicVo;

@Repository
public class MemberLikeMusicMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 좋아요 한 곡 조회 (페이징 적용)
	public List<MemberLikeMusicVo> selectMusicList(Criteria cri) {
		
		int memberNo = 1;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		cri.setStartNum((cri.getPageNum() - 1) * cri.getAmount());
		
		map.put("memberNo", memberNo);
		map.put("pageNum", cri.getPageNum());
		map.put("amount", cri.getAmount());
		
		return sqlSession.selectList("mybatis.member.selectMusic", map);
	}
	
	// 좋아요 한 곡 삭제
	public int deleteMusic(int musicNo) {
		
		return sqlSession.delete("mybatis.member.deleteMusic", musicNo);
	}
	
	// 곡 전체 갯수
	public int getMusicTotal() {
		
		int memberNo = 1;
		
		return sqlSession.selectOne("mybatis.member.getMusicTotal", memberNo);
	}
	
	// 좋아요 한 앨범 조회 (페이징 적용)
	public List<MemberLikeAlbumVo> selectAlbumList(Criteria cri) {
		
		int memberNo = 1;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		cri.setStartNum((cri.getPageNum() - 1) * cri.getAmount());
		
		map.put("memberNo", memberNo);
		map.put("pageNum", cri.getPageNum());
		map.put("amount", cri.getAmount());
		
		return sqlSession.selectList("mybatis.member.selectAlbum", map);
	}
	
	// 좋아요 한 앨범 삭제
	public int deleteAlbum(int albumNo) {
		
		return sqlSession.delete("mybatis.member.deleteAlbum", albumNo);
	}
	
	// 앨범 총 갯수
	public int getAlbumTotal() {
		
		int memberNo = 1;
		
		return sqlSession.selectOne("mybatis.member.getAlbumTotal", memberNo);
	}
	
	// 좋아요 한 가수 조회 (페이징 적용)
	public List<MemberFanVo> selectFanList(Criteria cri) {
		
		int memberNo = 1;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		cri.setStartNum((cri.getPageNum() - 1) * cri.getAmount());
		
		map.put("memberNo", memberNo);
		map.put("pageNum", cri.getPageNum());
		map.put("amount", cri.getAmount());
		
		return sqlSession.selectList("mybatis.member.selectFan", map);
	}
	
	// 좋아요 한 가수 삭제
	public int deleteFan(int fanNo) {
		
		return sqlSession.delete("mybatis.member.deleteFan", fanNo);
	}
	
	// 가수 총 카운트
	public int getFanTotal() {
		
		int memberNo = 1;
		
		return sqlSession.selectOne("mybatis.member.getFanTotal", memberNo);
	}
	
}


