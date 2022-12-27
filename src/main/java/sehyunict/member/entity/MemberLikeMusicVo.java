package sehyunict.member.entity;

public class MemberLikeMusicVo {
	
	private int like_music_no;
	private int music_no;
	private String music_title;
	private String artist_name;
	private String album_title;
	public int getLike_music_no() {
		return like_music_no;
	}
	public void setLike_music_no(int like_music_no) {
		this.like_music_no = like_music_no;
	}
	public int getMusic_no() {
		return music_no;
	}
	public void setMusic_no(int music_no) {
		this.music_no = music_no;
	}
	public String getMusic_title() {
		return music_title;
	}
	public void setMusic_title(String music_title) {
		this.music_title = music_title;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getAlbum_title() {
		return album_title;
	}
	public void setAlbum_title(String album_title) {
		this.album_title = album_title;
	}
}
