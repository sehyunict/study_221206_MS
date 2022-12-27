package sehyunict.rank.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.main.entity.MainRankVo;
import sehyunict.rank.entity.RankAlbumVo;
import sehyunict.rank.service.RankService;

@Service
public class RankServiceImpl implements RankService {

	@Autowired
	private RankMapper rankmapper;
	
	@Transactional
	@Override
	public List<MainRankVo> selectRankDayList(int memberNo) {
		return rankmapper.selectRankDayList(memberNo);
	}
	
	@Transactional
	@Override
	public List<RankAlbumVo> selectAlbumList(int memberNo) {
		return rankmapper.selectAlbumList(memberNo);
	}
	
	@Transactional
	@Override
	public int insertAlbum(List<Integer> musicList) {
		int result = 0;
		
		for (int i=1; i<musicList.size(); i++) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			map.put("albumNo", musicList.get(0));
			map.put("musicNo", musicList.get(i));

			result += rankmapper.insertAlbum(map);
		}
		
		return result;
	}
}