package sehyunict.main.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.main.entity.MainRankVo;
import sehyunict.main.entity.MainPlayListVo;
import sehyunict.main.service.MainService;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainMapper mapper;
	
	@Transactional
	@Override
	public List<MainRankVo> selectRankList(int memberNo) {
		return mapper.selectRankList(memberNo);
	}

	@Transactional
	@Override
	public List<MainPlayListVo> selectPlayList(int memberNo) {
		return mapper.selectPlayList(memberNo);
	}
	
	@Transactional
	@Override
	public List<MainPlayListVo> insertPlayList(int memberNo, List<Integer> musicList) {
		for (int i=0; i<musicList.size(); i++) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			map.put("memberNo", memberNo);
			map.put("musicNo", musicList.get(i));
			
			mapper.insertPlayList(map);	
		}
		
		Map<String, Integer> selectMap = new HashMap<String, Integer>();
		
		selectMap.put("memberNo", memberNo);
		selectMap.put("insertSize", musicList.size());

		return mapper.selectInsertPlayList(selectMap);
	}
	
	@Transactional
	@Override
	public void deletePlayList(int musicNo) {
		mapper.deletePlayList(musicNo);
	}
	
	@Transactional
	@Override
	public int deleteCheckPlayList(List<Integer> musicList) {
		int result = 0;
		
		for (int i=0; i<musicList.size(); i++) {
			result += mapper.deletePlayList(musicList.get(i));
		}
		
		return result;
	}
	
	@Transactional
	@Override
	public void insertLike(int memberNo, int musicNo) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("memberNo", memberNo);
		map.put("musicNo", musicNo);
		
		mapper.insertLike(map);
		mapper.updateInertLike(map.get("musicNo"));
	}
	
	@Transactional
	@Override
	public void deleteLike(int memberNo, int musicNo) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("memberNo", memberNo);
		map.put("musicNo", musicNo);
		
		mapper.deleteLike(map);
		mapper.updateDeleteLike(map.get("musicNo"));
	}
	
	@Transactional
	@Override
	public int updatePlayCount(List<Integer> musicList) {
		int result = 0;
		
		for (int i=0; i<musicList.size(); i++) {
			result += mapper.updatePlayCount(musicList.get(i));
		}
		
		return result;
	}
}