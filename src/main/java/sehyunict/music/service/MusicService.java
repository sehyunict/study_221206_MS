package sehyunict.music.service;

import java.util.List;

import sehyunict.music.entity.AlbumDetailVo;
import sehyunict.music.entity.ArtistDetailVo;
import sehyunict.music.entity.MusicDetailVo;
import sehyunict.music.entity.MusicSearchVo;

public interface MusicService {
	
	public List<MusicSearchVo> musicSearch(String search);
	public List<MusicDetailVo> musicDetail(int musicNo);
	public List<AlbumDetailVo> albumDetail(int albumNo);
	public List<ArtistDetailVo> artistDetail(int artistNo);
	public void playlistInsert(int musicNo); 
	
	public void myAlbumInsert(MusicDetailVo musicDetail);
	
	public void albumLikeInsert(int albumNo);
	public void albumLikeDelete(int albumNo);
	/* public void albumLikeUpdate(int albumNo); */

	public void musicLikeInsert(int musicNo);
	public void musicLikeDelete(int musicNo);

	public void fanInsert(int artistNo);
	public void fanDelete(int artistNo);


	 }
