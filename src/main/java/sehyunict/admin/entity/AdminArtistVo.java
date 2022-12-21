package sehyunict.admin.entity;

import java.sql.Date;

public class AdminArtistVo {
	
	private int artist_no;
	private String artist_name;
	private Date artist_date;
	private String artist_profile;
	private String artist_type;
	private String artist_introduce;
	private String artist_company;
	private Date artist_debut;
	private String artist_award;
	private int artist_genre;
	private int artist_fan;
	private String com_code;
	
	
	public int getArtist_no() {
		return artist_no;
	}
	public void setArtist_no(int artist_no) {
		this.artist_no = artist_no;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public Date getArtist_date() {
		return artist_date;
	}
	public void setArtist_date(Date artist_date) {
		this.artist_date = artist_date;
	}
	public String getArtist_profile() {
		return artist_profile;
	}
	public void setArtist_profile(String artist_profile) {
		this.artist_profile = artist_profile;
	}
	public String getArtist_type() {
		return artist_type;
	}
	public void setArtist_type(String artist_type) {
		this.artist_type = artist_type;
	}
	public String getArtist_introduce() {
		return artist_introduce;
	}
	public void setArtist_introduce(String artist_introduce) {
		this.artist_introduce = artist_introduce;
	}
	public String getArtist_company() {
		return artist_company;
	}
	public void setArtist_company(String artist_company) {
		this.artist_company = artist_company;
	}
	public Date getArtist_debut() {
		return artist_debut;
	}
	public void setArtist_debut(Date artist_debut) {
		this.artist_debut = artist_debut;
	}
	public String getArtist_award() {
		return artist_award;
	}
	public void setArtist_award(String artist_award) {
		this.artist_award = artist_award;
	}
	public int getArtist_genre() {
		return artist_genre;
	}
	public void setArtist_genre(int artist_genre) {
		this.artist_genre = artist_genre;
	}
	public int getArtist_fan() {
		return artist_fan;
	}
	public void setArtist_fan(int artist_fan) {
		this.artist_fan = artist_fan;
	}
	public String getCom_code() {
		return com_code;
	}
	public void setCom_code(String com_code) {
		this.com_code = com_code;
	}
	
	
	
	@Override
	public String toString() {
		return "AdminArtistVo [artist_no=" + artist_no + ", artist_name=" + artist_name + ", artist_date=" + artist_date
				+ ", artist_profile=" + artist_profile + ", artist_type=" + artist_type + ", artist_introduce="
				+ artist_introduce + ", artist_company=" + artist_company + ", artist_debut=" + artist_debut
				+ ", artist_award=" + artist_award + ", artist_genre=" + artist_genre + ", artist_fan=" + artist_fan
				+ ", com_code=" + com_code + "]";
	}
	
}
