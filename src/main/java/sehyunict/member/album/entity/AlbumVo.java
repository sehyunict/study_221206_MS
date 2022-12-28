package sehyunict.member.album.entity;

import java.util.Arrays;

public class AlbumVo {
	private Integer MEMBER_ALBUM_No;
	private String MEMBER_ALBUM_Title;
	private String MEMBER_ALBUM_Date;
	private byte[] MEMBER_ALBUM_Jacket;
	
	private String MEMBER_Name;
	private Integer MEMBER_No;
	
	private Integer MUSIC_No;
	private String MUSIC_Title;
	private String ARTIST_Name;
	private String MAM_date;
	
	public Integer getMEMBER_ALBUM_No() {
		return MEMBER_ALBUM_No;
	}
	public void setMEMBER_ALBUM_No(Integer mEMBER_ALBUM_No) {
		MEMBER_ALBUM_No = mEMBER_ALBUM_No;
	}
	public String getMEMBER_ALBUM_Title() {
		return MEMBER_ALBUM_Title;
	}
	public void setMEMBER_ALBUM_Title(String mEMBER_ALBUM_Title) {
		MEMBER_ALBUM_Title = mEMBER_ALBUM_Title;
	}
	public String getMEMBER_ALBUM_Date() {
		return MEMBER_ALBUM_Date;
	}
	public void setMEMBER_ALBUM_Date(String mEMBER_ALBUM_Date) {
		MEMBER_ALBUM_Date = mEMBER_ALBUM_Date;
	}
	public byte[] getMEMBER_ALBUM_Jacket() {
		return MEMBER_ALBUM_Jacket;
	}
	public void setMEMBER_ALBUM_Jacket(byte[] mEMBER_ALBUM_Jacket) {
		MEMBER_ALBUM_Jacket = mEMBER_ALBUM_Jacket;
	}
	public String getMEMBER_Name() {
		return MEMBER_Name;
	}
	public void setMEMBER_Name(String mEMBER_Name) {
		MEMBER_Name = mEMBER_Name;
	}
	public Integer getMEMBER_No() {
		return MEMBER_No;
	}
	public void setMEMBER_No(Integer mEMBER_No) {
		MEMBER_No = mEMBER_No;
	}
	public Integer getMUSIC_No() {
		return MUSIC_No;
	}
	public void setMUSIC_No(Integer mUSIC_No) {
		MUSIC_No = mUSIC_No;
	}
	public String getMUSIC_Title() {
		return MUSIC_Title;
	}
	public void setMUSIC_Title(String mUSIC_Title) {
		MUSIC_Title = mUSIC_Title;
	}
	public String getARTIST_Name() {
		return ARTIST_Name;
	}
	public void setARTIST_Name(String aRTIST_Name) {
		ARTIST_Name = aRTIST_Name;
	}
	public String getMAM_date() {
		return MAM_date;
	}
	public void setMAM_date(String mAM_date) {
		MAM_date = mAM_date;
	}
	
	
	@Override
	public String toString() {
		return "MemberAlbumVo [MEMBER_ALBUM_No=" + MEMBER_ALBUM_No + ", MEMBER_ALBUM_Title=" + MEMBER_ALBUM_Title
				+ ", MEMBER_ALBUM_Date=" + MEMBER_ALBUM_Date + ", MEMBER_ALBUM_Jacket="
				+ Arrays.toString(MEMBER_ALBUM_Jacket) + ", MEMBER_Name=" + MEMBER_Name + ", MEMBER_No=" + MEMBER_No
				+ ", MUSIC_No=" + MUSIC_No + ", MUSIC_Title=" + MUSIC_Title + ", ARTIST_Name=" + ARTIST_Name
				+ ", MAM_date=" + MAM_date + "]";
	}
	
	
	
	
}