package sehyunict.member.album.servic.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.member.album.entity.AlbumVo;
import sehyunict.member.album.service.MemberAlbumService;
import sehyunict.member.entity.MemberVo;

@Service
public class MemberAblumServiceImpl implements MemberAlbumService{
	
	
	@Autowired
	private MemberAlbumMapper memberAlbumMapper;
	
	@Transactional
	@Override
	public List<AlbumVo> selectMemberAlbum() {
		return memberAlbumMapper.selectMemberAlbum();
	}

	@Transactional
	@Override
	public List<AlbumVo> selectMemberAlbumDetail(Integer memberAlbumNo) {
		return memberAlbumMapper.selectMemberAlbumDetail(memberAlbumNo);
	}

	@Transactional
	@Override
	public int updateMemberAlbumDetail(AlbumVo memberAlbumVo) {
		
		return memberAlbumMapper.updateMemberAlbumDetail(memberAlbumVo);
		
	}

	@Transactional
	@Override
	public Integer deleteMemberAlubm(Integer memberAlbumNo) {
		return memberAlbumMapper.deleteMemberAlbum(memberAlbumNo);
	}
	
	@Transactional
	@Override
	public AlbumVo selectAlbumUpdate(Integer memberAlbumNo) {
		return memberAlbumMapper.selectUpdate(memberAlbumNo);
	}

}
