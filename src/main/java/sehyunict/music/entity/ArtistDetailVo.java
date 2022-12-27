package sehyunict.music.entity;

public class ArtistDetailVo {

	private int artistNo;
	private String artistName;
	private String artistType;


	private byte[] artistProfile;
	private String artistIntroduce;
	private String artistDebut;
	private String artistCompany;
	private String artistAwarded;
	private String artistGenre;
	private int artistFan;
	private int fanHeart;
	
	public int getFanHeart() {
		return fanHeart;
	}

	public void setFanHeart(int fanHeart) {
		this.fanHeart = fanHeart;
	}

	
	
	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}



	public String getArtistType() {
		return artistType;
	}

	public void setArtistType(String artistType) {
		this.artistType = artistType;
	}



	public String getArtistDebut() {
		return artistDebut;
	}

	public void setArtistDebut(String artistDebut) {
		this.artistDebut = artistDebut;
	}

	public String getArtistCompany() {
		return artistCompany;
	}

	public void setArtistCompany(String artistCompany) {
		this.artistCompany = artistCompany;
	}

	public String getArtistAwarded() {
		return artistAwarded;
	}

	public void setArtistAwarded(String artistAwarded) {
		this.artistAwarded = artistAwarded;
	}

	public String getArtistGenre() {
		return artistGenre;
	}

	public void setArtistGenre(String artistGenre) {
		this.artistGenre = artistGenre;
	}

	public int getArtistFan() {
		return artistFan;
	}

	public void setArtistFan(int artistFan) {
		this.artistFan = artistFan;
	}

	public int getArtistNo() {
		return artistNo;
	}

	public void setArtistNo(int artistNo) {
		this.artistNo = artistNo;
	}
	public byte[] getArtistProfile() {
		return artistProfile;
	}

	public void setArtistProfile(byte[] artistProfile) {
		this.artistProfile = artistProfile;
	}

	public String getArtistIntroduce() {
		return artistIntroduce;
	}

	public void setArtistIntroduce(String artistIntroduce) {
		this.artistIntroduce = artistIntroduce;
	}


}