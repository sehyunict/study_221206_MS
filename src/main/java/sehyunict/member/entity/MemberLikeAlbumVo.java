package sehyunict.member.entity;

import java.util.Date;

public class MemberLikeAlbumVo {
	private int like_album_no;
	private int album_no;
	private byte[] album_jacket;
	private String album_title;
	private String artist_name;
	private Date album_date;
	public int getLike_album_no() {
		return like_album_no;
	}
	public void setLike_album_no(int like_album_no) {
		this.like_album_no = like_album_no;
	}
	public int getAlbum_no() {
		return album_no;
	}
	public void setAlbum_no(int album_no) {
		this.album_no = album_no;
	}
	public byte[] getAlbum_jacket() {
		return album_jacket;
	}
	public void setAlbum_jacket(byte[] album_jacket) {
		this.album_jacket = album_jacket;
	}
	public String getAlbum_title() {
		return album_title;
	}
	public void setAlbum_title(String album_title) {
		this.album_title = album_title;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public Date getAlbum_date() {
		return album_date;
	}
	public void setAlbum_date(Date album_date) {
		this.album_date = album_date;
	}
}
