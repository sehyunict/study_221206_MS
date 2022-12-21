package sehyunict.admin.entity;

import java.sql.Date;

public class AdminAlbumVo {
	
	private int album_no;
	private int artist_no;
	private String album_title;
	private String album_type;
	private String album_jacket;
	private int album_genre;
	private String album_introduce;
	private String album_commany;
	private String album_agency;
	private Date album_date;
	private int album_like;
	private String artist_name;
	private String com_code;
	
	
	
	public int getAlbum_no() {
		return album_no;
	}
	public void setAlbum_no(int album_no) {
		this.album_no = album_no;
	}
	public int getArtist_no() {
		return artist_no;
	}
	public void setArtist_no(int artist_no) {
		this.artist_no = artist_no;
	}
	public String getAlbum_title() {
		return album_title;
	}
	public void setAlbum_title(String album_title) {
		this.album_title = album_title;
	}
	public String getAlbum_type() {
		return album_type;
	}
	public void setAlbum_type(String album_type) {
		this.album_type = album_type;
	}
	public String getAlbum_jacket() {
		return album_jacket;
	}
	public void setAlbum_jacket(String album_jacket) {
		this.album_jacket = album_jacket;
	}
	public int getAlbum_genre() {
		return album_genre;
	}
	public void setAlbum_genre(int album_genre) {
		this.album_genre = album_genre;
	}
	public String getAlbum_introduce() {
		return album_introduce;
	}
	public void setAlbum_introduce(String album_introduce) {
		this.album_introduce = album_introduce;
	}
	public String getAlbum_commany() {
		return album_commany;
	}
	public void setAlbum_commany(String album_commany) {
		this.album_commany = album_commany;
	}
	public String getAlbum_agency() {
		return album_agency;
	}
	public void setAlbum_agency(String album_agency) {
		this.album_agency = album_agency;
	}
	public Date getAlbum_date() {
		return album_date;
	}
	public void setAlbum_date(Date album_date) {
		this.album_date = album_date;
	}
	public int getAlbum_like() {
		return album_like;
	}
	public void setAlbum_like(int album_like) {
		this.album_like = album_like;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getCom_code() {
		return com_code;
	}
	public void setCom_code(String com_code) {
		this.com_code = com_code;
	}
	
	
	@Override
	public String toString() {
		
		return "AdminAlbumVo [album_no=" + album_no + ", artist_no=" + artist_no + ", album_title=" + album_title
				+ ", album_type=" + album_type + ", album_jacket=" + album_jacket + ", album_genre=" + album_genre
				+ ", album_introduce=" + album_introduce + ", album_commany=" + album_commany + ", album_agency="
				+ album_agency + ", album_date=" + album_date + ", album_like=" + album_like + ", artist_name="
				+ artist_name + ", com_code=" + com_code + "]";
	}
	
}
