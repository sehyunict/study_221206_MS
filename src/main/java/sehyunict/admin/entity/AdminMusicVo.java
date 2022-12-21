package sehyunict.admin.entity;

import java.util.Arrays;

public class AdminMusicVo {
	
	private int music_no;
	private int album_no;
	private int artist_no;
	private String music_title;
	private String music_lyrics;
	private String music_composition;
	private String music_write;
	private String music_arrange;
	private int music_genre;
	private int music_like;
	private int music_playcount;
	private byte[] music_mv;
	private String music_adult;
	private String music_file;
	private int music_albumorder;
	private String album_title;
	private String artist_name;
	private String com_code;
	
	
	

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
	public String getCom_code() {
		return com_code;
	}
	public void setCom_code(String com_code) {
		this.com_code = com_code;
	}
	public int getMusic_no() {
		return music_no;
	}
	public void setMusic_no(int music_no) {
		this.music_no = music_no;
	}
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
	public String getMusic_title() {
		return music_title;
	}
	public void setMusic_title(String music_title) {
		this.music_title = music_title;
	}
	public String getMusic_lyrics() {
		return music_lyrics;
	}
	public void setMusic_lyrics(String music_lyrics) {
		this.music_lyrics = music_lyrics;
	}
	public String getMusic_composition() {
		return music_composition;
	}
	public void setMusic_composition(String music_composition) {
		this.music_composition = music_composition;
	}
	public String getMusic_write() {
		return music_write;
	}
	public void setMusic_write(String music_write) {
		this.music_write = music_write;
	}
	public String getMusic_arrange() {
		return music_arrange;
	}
	public void setMusic_arrange(String music_arrange) {
		this.music_arrange = music_arrange;
	}
	public int getMusic_genre() {
		return music_genre;
	}
	public void setMusic_genre(int music_genre) {
		this.music_genre = music_genre;
	}
	public int getMusic_like() {
		return music_like;
	}
	public void setMusic_like(int music_like) {
		this.music_like = music_like;
	}
	public int getMusic_playcount() {
		return music_playcount;
	}
	public void setMusic_playcount(int music_playcount) {
		this.music_playcount = music_playcount;
	}
	public byte[] getMusic_mv() {
		return music_mv;
	}
	public void setMusic_mv(byte[] music_mv) {
		this.music_mv = music_mv;
	}
	public String getMusic_adult() {
		return music_adult;
	}
	public void setMusic_adult(String music_adult) {
		this.music_adult = music_adult;
	}
	public String getMusic_file() {
		return music_file;
	}
	public void setMusic_file(String music_file) {
		this.music_file = music_file;
	}
	public int getMusic_albumorder() {
		return music_albumorder;
	}
	public void setMusic_albumorder(int music_albumorder) {
		this.music_albumorder = music_albumorder;
	}
	
	
	@Override
	public String toString() {
		return "AdminMusicVo [music_no=" + music_no + ", album_no=" + album_no + ", artist_no=" + artist_no
				+ ", music_title=" + music_title + ", music_lyrics=" + music_lyrics + ", music_composition="
				+ music_composition + ", music_write=" + music_write + ", music_arrange=" + music_arrange
				+ ", music_genre=" + music_genre + ", music_like=" + music_like + ", music_playcount=" + music_playcount
				+ ", music_mv=" + Arrays.toString(music_mv) + ", music_adult=" + music_adult + ", music_file="
				+ music_file + ", music_albumorder=" + music_albumorder + ", album_title=" + album_title
				+ ", artist_name=" + artist_name + ", com_code=" + com_code + "]";
	}
}
