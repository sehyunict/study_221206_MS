package sehyunict.member.entity;

import java.util.Date;

public class MemberFanVo {
	private int fan_no;
	private int artist_no;
	private String artist_name;
	private byte[] artist_profile;
	private String artist_introduce;
	private String artist_company;
	private Date artist_debut;
	public int getFan_no() {
		return fan_no;
	}
	public void setFan_no(int fan_no) {
		this.fan_no = fan_no;
	}
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
	public byte[] getArtist_profile() {
		return artist_profile;
	}
	public void setArtist_profile(byte[] artist_profile) {
		this.artist_profile = artist_profile;
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
}
