package sehyunict.rank.service;

import java.util.List;

import sehyunict.main.entity.MainRankVo;
import sehyunict.rank.entity.RankAlbumVo;

public interface RankService {

	public List<MainRankVo> selectRankDayList(int memberNo);

	public List<RankAlbumVo> selectAlbumList(int memberNo);

	public int insertAlbum(List<Integer> musicList);
}