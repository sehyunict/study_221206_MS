package sehyunict.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.member.entity.Criteria;
import sehyunict.member.entity.MemberFanVo;
import sehyunict.member.entity.MemberLikeAlbumVo;
import sehyunict.member.entity.MemberLikeMusicVo;
import sehyunict.member.service.MemberLikeMusicService;

@Service
public class MemberLikeMusicServiceImpl implements MemberLikeMusicService{
	
	@Autowired
	private MemberLikeMusicMapper dao;
	
	// 좋아요 한 곡 조회
	@Transactional
	@Override
	public List<MemberLikeMusicVo> selectMusicList(Criteria cri) {
		
		return dao.selectMusicList(cri);
	}
	
	// 좋아요 한 곡 삭제
	@Transactional
	@Override
	public int deleteMusic(int musicNo) {
		
		return dao.deleteMusic(musicNo);
	}
	
	// 곡 전체 갯수
	@Transactional
	@Override
	public int getMusicTotal() {
		
		return dao.getMusicTotal();
	}
	
	// 좋아요 한 앨범 조회
	@Transactional
	@Override
	public List<MemberLikeAlbumVo> selectAlbumList(Criteria cri) {
		
		return dao.selectAlbumList(cri);
	}
	
	// 좋아요 한 앨범 삭제
	@Transactional
	@Override
	public int deleteAlbum(int albumNo) {
		
		return dao.deleteAlbum(albumNo);
	}
	
	// 앨범 총 갯수
	@Transactional
	@Override
	public int getAlbumTotal() {
		
		return dao.getAlbumTotal();
	}
	
	// 좋아요 한 가수 조회
	@Transactional
	@Override
	public List<MemberFanVo> selectFanList(Criteria cri) {
		
		return dao.selectFanList(cri);
	}
	
	// 좋아요 한 가수 삭제
	@Transactional
	@Override
	public int deleteFan(int fanNo) {
		
		return dao.deleteFan(fanNo);
	}
	
	// 가수 총 카운트
	@Transactional
	@Override
	public int getFanTotal() {
		
		return dao.getFanTotal();
	}
	
}
