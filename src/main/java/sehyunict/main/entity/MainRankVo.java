package sehyunict.main.entity;

public class MainRankVo {
	private int music_no;
	private String music_title;
	private String artist_name;
	private String album_title;
	private int music_like;
	private int member_like;
	
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
	public int getMusic_like() {
		return music_like;
	}
	public void setMusic_like(int music_like) {
		this.music_like = music_like;
	}
	public int getMember_like() {
		return member_like;
	}
	public void setMember_like(int member_like) {
		this.member_like = member_like;
	}
}