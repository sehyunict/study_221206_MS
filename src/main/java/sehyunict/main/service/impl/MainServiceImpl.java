package sehyunict.main.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.main.entity.MainInsertPlayListVo;
import sehyunict.main.entity.MainPlayCountVo;
import sehyunict.main.entity.MainPlayListVo;
import sehyunict.main.entity.MainRankVo;
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
		Map<String, Object> insertMap = new HashMap<String, Object>();
		List<MainInsertPlayListVo> insertList = new ArrayList<MainInsertPlayListVo>();
		
		for (int i=0; i<musicList.size(); i++) {
			MainInsertPlayListVo mVo = new MainInsertPlayListVo();
			
			mVo.setMemberNo(memberNo);
			mVo.setMusicNo(musicList.get(i));
			
			insertList.add(mVo);
		}
		
		insertMap.put("list", insertList);
		mapper.insertPlayList(insertMap);
		
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
	}
	
	@Transactional
	@Override
	public void deleteLike(int memberNo, int musicNo) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("memberNo", memberNo);
		map.put("musicNo", musicNo);
		
		mapper.deleteLike(map);
	}
	
	@Transactional
	@Override
	public int updatePlayCount(List<Integer> musicList) {
		int result = 0;
		List<Integer> insertCheckList = new ArrayList<Integer>();

		for (int i=0; i<musicList.size(); i++) {
			insertCheckList.add(musicList.get(i));
		}
		
		Map<String, Object> selectMap = new HashMap<String, Object>(); //select
		List<MainPlayCountVo> selectList = new ArrayList<MainPlayCountVo>();
		
		for (int i=0; i<musicList.size(); i++) {
			MainPlayCountVo mVo = new MainPlayCountVo();
			
			mVo.setMusic_no(musicList.get(i));
			
			selectList.add(mVo);
		}
		
		selectMap.put("list", selectList);

		List<MainPlayCountVo> dateCheck = mapper.selectPlayListDate(selectMap);
		
		if (dateCheck.size() != 0) { //update
			Map<String, Object> updateMap = new HashMap<String, Object>(); 
			List<MainPlayCountVo> updateList = new ArrayList<MainPlayCountVo>();

			for (int i=0; i<musicList.size(); i++) {
				for (int j=0; j<dateCheck.size(); j++) {
					if (musicList.get(i) == dateCheck.get(j).getMusic_no()) {
						MainPlayCountVo mVo = new MainPlayCountVo();
						
						mVo.setMusic_no(musicList.get(i));
						
						updateList.add(mVo);
						insertCheckList.remove(Integer.valueOf(musicList.get(i)));
						
						result++;
						
						break;
					}
				}
			}
			
			updateMap.put("list", updateList);
			
			mapper.updatePlayCount(updateMap);
		}
		
		if (insertCheckList.size() != 0) { //insert
			Map<String, Object> insertMap = new HashMap<String, Object>();
			List<MainPlayCountVo> insertList = new ArrayList<MainPlayCountVo>();
			
			for (int i=0; i<insertCheckList.size(); i++) {
				MainPlayCountVo mVo = new MainPlayCountVo();
				
				mVo.setMusic_no(insertCheckList.get(i));

				insertList.add(mVo);
				
				result++;
			}

			insertMap.put("list", insertList);
			
			mapper.insertPlayCount(insertMap);
		}
		
		return result;
	}
}