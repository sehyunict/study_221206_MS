package sehyunict.music.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.music.entity.AlbumDetailVo;
import sehyunict.music.entity.ArtistDetailVo;
import sehyunict.music.entity.MusicDetailVo;
import sehyunict.music.entity.MusicSearchVo;

@Repository
public class MusicMapper {

	@Autowired
	private SqlSession sqlSession;

	public List<MusicSearchVo> musicSearch(String search) {
		return sqlSession.selectList("mybatis.music.musicSearch", search);
	}

	public List<MusicDetailVo> musicDetail(int musicNo) {
		return sqlSession.selectList("mybatis.music.musicDetail", musicNo);
	}

	public List<AlbumDetailVo> albumDetail(int albumNo) {
		return sqlSession.selectList("mybatis.music.albumDetail", albumNo);
	}

	public List<ArtistDetailVo> artistDetail(int artistNo) {
		return sqlSession.selectList("mybatis.music.artistDetail", artistNo);
	}

	public void playlistInsert(int musicNo) {
		sqlSession.insert("mybatis.music.playlistInsert", musicNo);
	}
		
	
	public void myAlbumInsert(MusicDetailVo musicDetail) {
		sqlSession.insert("mybatis.music.myAlbumInsert", musicDetail);
	}
	
	public void albumLikeInsert(int albumNo) {
		sqlSession.insert("mybatis.music.albumLikeInsert", albumNo); 
	}
	
	/*
	 * public void albumLikeUpdate(int albumNo) {
	 * sqlSession.update("mybatis.music.albumLikeUpdate", albumNo); }
	 */
	 
	public void albumLikeDelete(int albumNo) {
		sqlSession.delete("mybatis.music.albumLikeDelete", albumNo); 
	}	
	
	
	public void musicLikeInsert(int musicNo) {
		sqlSession.insert("mybatis.music.musicLikeInsert", musicNo); 
	}
	
	public void musicLikeDelete(int musicNo) {
		sqlSession.delete("mybatis.music.musicLikeDelete", musicNo); 
	}
	
	
	public void fanInsert(int artistNo) {
		sqlSession.insert("mybatis.music.fanInsert", artistNo); 
	}
	
	public void fanDelete(int artistNo) {
		sqlSession.delete("mybatis.music.fanDelete", artistNo); 
	}
}
