package sehyunict.main.entity;

import java.util.Date;

public class MainPlayListVo {
	private int now_playList_no;
	private int music_no;
	private String music_title;
	private String artist_name;
	private int now_playList_count;
	private Date now_playList_date;
	private int artist_no;
	
	public int getArtist_no() {
		return artist_no;
	}
	public void setArtist_no(int artist_no) {
		this.artist_no = artist_no;
	}
	public int getNow_playList_no() {
		return now_playList_no;
	}
	public void setNow_playList_no(int now_playList_no) {
		this.now_playList_no = now_playList_no;
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
	public int getNow_playList_count() {
		return now_playList_count;
	}
	public void setNow_playList_count(int now_playList_count) {
		this.now_playList_count = now_playList_count;
	}
	public Date getNow_playList_date() {
		return now_playList_date;
	}
	public void setNow_playList_date(Date now_playList_date) {
		this.now_playList_date = now_playList_date;
	}
}