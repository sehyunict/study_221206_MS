package sehyunict.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.music.entity.AlbumDetailVo;
import sehyunict.music.entity.ArtistDetailVo;
import sehyunict.music.entity.MusicDetailVo;
import sehyunict.music.entity.MusicSearchVo;
import sehyunict.music.service.MusicService;

@Service
public class MusicServiceImpl implements MusicService {

	@Autowired
	private MusicMapper dao;

	/* 음악 검색 */
	@Transactional
	@Override
	public List<MusicSearchVo> musicSearch(String search) {
		return dao.musicSearch(search);
	}

	/* 음악 상세 */
	@Transactional
	@Override
	public List<MusicDetailVo> musicDetail(int musicNo) {
		return dao.musicDetail(musicNo);
	}

	/* 앨범 상세 */
	@Transactional
	@Override
	public List<AlbumDetailVo> albumDetail(int albumNo) {
		return dao.albumDetail(albumNo);
	}

	/* 아티스트 상세 */
	@Transactional
	@Override
	public List<ArtistDetailVo> artistDetail(int artistNo) {
		return dao.artistDetail(artistNo);
	}

	/* 플레이리스트 추가 */
	@Transactional
	@Override
	public void playlistInsert(int musicNo) {
		dao.playlistInsert(musicNo);
	}
	
	
	/* 마이앨범 추가 */
	@Transactional
	@Override
	public void myAlbumInsert(MusicDetailVo musicDetail) {
		dao.myAlbumInsert(musicDetail);
	}
	
	

	/* 앨범 좋아요 */
	@Transactional
	@Override
	public void albumLikeInsert(int albumNo) {
		dao.albumLikeInsert(albumNo);	
	}

	/* 앨범 좋아요 취소*/
	@Transactional
	@Override
	public void albumLikeDelete(int albumNo) {
		dao.albumLikeDelete(albumNo);
	}		
	
	/* 노래 좋아요 */
	@Transactional
	@Override
	public void musicLikeInsert(int musicNo) {
		dao.musicLikeInsert(musicNo);	
	}

	/* 노래 좋아요 취소*/
	@Transactional
	@Override
	public void musicLikeDelete(int musicNo) {
		dao.musicLikeDelete(musicNo);
	}

	/*
	 * @Transactional
	 * 
	 * @Override public void albumLikeUpdate(int albumNo) {
	 * dao.albumLikeUpdate(albumNo); }
	 */
	
	
	/* 팬 */
	@Transactional
	@Override
	public void fanInsert(int artistNo) {
		dao.fanInsert(artistNo);	
	}

	/* 팬 취소*/
	@Transactional
	@Override
	public void fanDelete(int artistNo) {
		dao.fanDelete(artistNo);
	}
}
