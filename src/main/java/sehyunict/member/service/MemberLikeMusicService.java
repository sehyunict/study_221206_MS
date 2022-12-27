package sehyunict.member.service;

import java.util.List;

import sehyunict.member.entity.Criteria;
import sehyunict.member.entity.MemberFanVo;
import sehyunict.member.entity.MemberLikeAlbumVo;
import sehyunict.member.entity.MemberLikeMusicVo;

public interface MemberLikeMusicService {
	
	// 좋아요 한 곡 조회
	public List<MemberLikeMusicVo> selectMusicList(Criteria cri);
	
	// 좋아요 한 곡 삭제
	public int deleteMusic(int no);
	
	// 곡 전체 갯수
	public int getMusicTotal();
	
	// 좋아요 한 앨범 조회
	public List<MemberLikeAlbumVo> selectAlbumList(Criteria cri);
	
	// 좋아요 한 앨범 삭제
	public int deleteAlbum(int no);
	
	// 앨범 총 갯수
	public int getAlbumTotal();
	
	// 좋아요 한 가수 조회
	public List<MemberFanVo> selectFanList(Criteria cri);
	
	// 좋아요 한 가수 삭제
	public int deleteFan(int no);
	
	// 가수 총 카운트
	public int getFanTotal();
	
}


