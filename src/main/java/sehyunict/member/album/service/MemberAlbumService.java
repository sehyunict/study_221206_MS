package sehyunict.member.album.service;

import java.util.List;

import sehyunict.member.album.entity.AlbumVo;
import sehyunict.member.entity.MemberVo;

public interface MemberAlbumService {
	
	public List<AlbumVo> selectMemberAlbum();
	public List<AlbumVo> selectMemberAlbumDetail(Integer memberAlbumNom);
	public AlbumVo selectAlbumUpdate(Integer memberAlbumNo);
  	public int updateMemberAlbumDetail(AlbumVo memberAlbumVo);
	public Integer deleteMemberAlubm(Integer memberAlbumNo);
	
}