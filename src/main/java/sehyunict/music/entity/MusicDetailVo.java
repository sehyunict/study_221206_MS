package sehyunict.music.entity;

public class MusicDetailVo {
	private int musicNo;
	private String musicTitle;
	private String musicComposition;
	private String musicWrite;
	private String musicArrange;	
	private String artistName;
	private String albumTitle;
	private String albumDate;
	private String musicGenre;	
	private String musicLike;
	private byte[] musicMv;
	private String musicFile;
	private String musicLyrics;
	private int albumNo;
	private int artistNo;
	private byte[] albumJacket;
	private int musicHeart;

	private int memberAlbumNo;
	private String musicAdult;
	
	
	public String getMusicAdult() {
		return musicAdult;
	}

	public void setMusicAdult(String musicAdult) {
		this.musicAdult = musicAdult;
	}

	
	public int getMemberAlbumNo() {
		return memberAlbumNo;
	}

	public void setMemberAlbumNo(int memberAlbumNo) {
		this.memberAlbumNo = memberAlbumNo;
	}
	
	public int getMusicHeart() {
		return musicHeart;
	}

	public void setMusicHeart(int musicHeart) {
		this.musicHeart = musicHeart;
	}

	public byte[] getAlbumJacket() {
		return albumJacket;
	}

	public void setAlbumJacket(byte[] albumJacket) {
		this.albumJacket = albumJacket;
	}	
	
	public int getArtistNo() {
		return artistNo;
	}

	public void setArtistNo(int artistNo) {
		this.artistNo = artistNo;
	}

	public int getAlbumNo() {
		return albumNo;
	}

	public void setAlbumNo(int albumNo) {
		this.albumNo = albumNo;
	}

	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}

	public String getMusicTitle() {
		return musicTitle;
	}

	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	public String getMusicComposition() {
		return musicComposition;
	}

	public void setMusicCompose(String musicComposition) {
		this.musicComposition = musicComposition;
	}

	public String getMusicWrite() {
		return musicWrite;
	}

	public void setMusicWrite(String musicWrite) {
		this.musicWrite = musicWrite;
	}

	public String getMusicArrange() {
		return musicArrange;
	}

	public void setMusicArrange(String musicArrange) {
		this.musicArrange = musicArrange;
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

	public String getAlbumDate() {
		return albumDate;
	}

	public void setAlbumDate(String albumDate) {
		this.albumDate = albumDate;
	}

	public String getMusicGenre() {
		return musicGenre;
	}

	public void setMusicGenre(String musicGenre) {
		this.musicGenre = musicGenre;
	}

	public void setMusicComposition(String musicComposition) {
		this.musicComposition = musicComposition;
	}
	
	public String getMusicLike() {
		return musicLike;
	}

	public void setMusicLike(String musicLike) {
		this.musicLike = musicLike;
	}

	public byte[] getMusicMv() {
		return musicMv;
	}

	public void setMusicMv(byte[] musicMv) {
		this.musicMv = musicMv;
	}

	public String getMusicFile() {
		return musicFile;
	}

	public void setMusicFile(String musicFile) {
		this.musicFile = musicFile;
	}

	public String getMusicLyrics() {
		return musicLyrics;
	}

	public void setMusicLyrics(String musicLyrics) {
		this.musicLyrics = musicLyrics;
	}
	
	
}