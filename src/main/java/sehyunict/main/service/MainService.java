package sehyunict.main.service;

import java.util.List;

import sehyunict.main.entity.MainRankVo;
import sehyunict.main.entity.MainPlayListVo;

public interface MainService {
	
	public List<MainPlayListVo> selectPlayList(int memberNo);
	
	public List<MainRankVo> selectRankList(int memberNo);

	public List<MainPlayListVo> insertPlayList(int memberNo, List<Integer> musicList);

	public void deletePlayList(int musicNo);
	
	public int deleteCheckPlayList(List<Integer> musicList);
	
	public void insertLike(int memberNo, int musicNo);
	
	public void deleteLike(int memberNo, int musicNo);
	
	public int updatePlayCount(List<Integer> musicList);
}