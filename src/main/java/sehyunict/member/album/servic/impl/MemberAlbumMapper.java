package sehyunict.member.album.servic.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.member.album.entity.AlbumVo;
import sehyunict.member.entity.MemberVo;

@Repository
public class MemberAlbumMapper {
	
	private static Map<Integer, AlbumVo> store = new HashMap<Integer, AlbumVo>();

	@Autowired
	private SqlSession sqlSession;

	public List<AlbumVo> selectMemberAlbum() {	
		return sqlSession.selectList("mybatis.memberAlbum.selectMemberAlbum");
	}

	public List<AlbumVo> selectMemberAlbumDetail(Integer memberAlbumNo) {		
		return sqlSession.selectList("mybatis.memberAlbum.selectMemberAlbumDetail", memberAlbumNo);
	}

	public AlbumVo selectUpdate(Integer memberAlbumNo) {
		return (AlbumVo)sqlSession.selectOne("selectMemberAlbumUpdate", memberAlbumNo);
	}

	public int updateMemberAlbumDetail(AlbumVo memberAlbumVo) {	
		return sqlSession.update("updateMemberAlbumDetail", memberAlbumVo);

	}

	public Integer deleteMemberAlbum(Integer memberAlbumNo) {
		return sqlSession.delete("mybatis.memberAlbum.deleteMemberAlbum", memberAlbumNo);
	}
}