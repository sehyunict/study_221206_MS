package sehyunict.music.entity;

public class MusicSearchVo {
//	private byte[] MUSIC_MV;
	private String musicTitle;
	private String artistName;
	private String albumTitle;
	private int musicLike;
	private int musicNumber;
	private String musicFile;

	private byte[] musicMv;
	private int musicNo;	
	private String musicAdult;
	private String musicAlbumorder;
	private int albumNo;
	private int musicHeart;
	
	private int artistNo;
		
	public int getMusicHeart() {
		return musicHeart;
	}
	public void setMusicHeart(int musicHeart) {
		this.musicHeart = musicHeart;
	}

	

	
	public byte[] getMusicMv() {
		return musicMv;
	}
	public void setMusicMv(byte[] musicMv) {
		this.musicMv = musicMv;
	}
	
	public int getAlbumNo() {
		return albumNo;
	}
	public void setAlbumNo(int albumNo) {
		this.albumNo = albumNo;
	}
	public String getMusicTitle() {
		return musicTitle;
	}
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
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
	public int getMusicLike() {
		return musicLike;
	}
	public void setMusicLike(int musicLike) {
		this.musicLike = musicLike;
	}
	public int getMusicNumber() {
		return musicNumber;
	}
	public void setMusicNumber(int musicNumber) {
		this.musicNumber = musicNumber;
	}
	public String getMusicFile() {
		return musicFile;
	}
	public void setMusicFile(String musicFile) {
		this.musicFile = musicFile;
	}

	public int getMusicNo() {
		return musicNo;
	}
	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}
	public String getMusicAdult() {
		return musicAdult;
	}
	public void setMusicAdult(String musicAdult) {
		this.musicAdult = musicAdult;
	}
	public String getMusicAlbumorder() {
		return musicAlbumorder;
	}
	public void setMusicAlbumorder(String musicAlbumorder) {
		this.musicAlbumorder = musicAlbumorder;
	}
	public int getArtistNo() {
		return artistNo;
	}
	public void setArtistNo(int artistNo) {
		this.artistNo = artistNo;
	}
}