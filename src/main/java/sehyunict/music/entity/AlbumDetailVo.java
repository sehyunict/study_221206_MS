package sehyunict.music.entity;

public class AlbumDetailVo {

	private String albumTitle;
	private int albumNo;
	private String albumDate;
	private String artistName;
	private String artistNo;
	private String albumCompany;
	private String albumAgency;
	private String albumGenre;
	private int albumLike;
	private String musicTitle;
	private byte[] albumJacket;
	private String albumIntroduce;

	private int likeAlbumNo;
	private int memberNo;
	private String likeAlbumDate;
	
	private int albumHeart;
	
	public int getAlbumHeart() {
		return albumHeart;
	}

	public void setAlbumHeart(int albumHeart) {
		this.albumHeart = albumHeart;
	}	
	
	public int getLikeAlbumNo() {
		return likeAlbumNo;
	}

	public void setLikeAlbumNo(int likeAlbumNo) {
		this.likeAlbumNo = likeAlbumNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getLikeAlbumDate() {
		return likeAlbumDate;
	}

	public void setLikeAlbumDate(String likeAlbumDate) {
		this.likeAlbumDate = likeAlbumDate;
	}
	
	
	
	public String getAlbumIntroduce() {
		return albumIntroduce;
	}

	public void setAlbumIntroduce(String albumIntroduce) {
		this.albumIntroduce = albumIntroduce;
	}
	
	public byte[] getAlbumJacket() {
		return albumJacket;
	}

	public void setAlbumJacket(byte[] albumJacket) {
		this.albumJacket = albumJacket;
	}

	public String getArtistNo() {
		return artistNo;
	}
	public void setArtistNo(String artistNo) {
		this.artistNo = artistNo;
	}	
	public String getMusicTitle() {
		return musicTitle;
	}
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	public String getAlbumDate() {
		return albumDate;
	}
	public void setAlbumDate(String albumDate) {
		this.albumDate = albumDate;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public int getAlbumNo() {
		return albumNo;
	}
	public void setAlbumNo(int albumNo) {
		this.albumNo = albumNo;
	}
	public String getAlbumCompany() {
		return albumCompany;
	}
	public void setAlbumCompany(String albumCompany) {
		this.albumCompany = albumCompany;
	}
	public String getAlbumAgency() {
		return albumAgency;
	}
	public void setAlbumAgency(String albumAgency) {
		this.albumAgency = albumAgency;
	}
	public String getAlbumGenre() {
		return albumGenre;
	}
	public void setAlbumGenre(String albumGenre) {
		this.albumGenre = albumGenre;
	}
	public int getAlbumLike() {
		return albumLike;
	}
	public void setAlbumLike(int albumLike) {
		this.albumLike = albumLike;
	}

}