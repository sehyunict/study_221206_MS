package sehyunict.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.main.entity.MusicVo;
import sehyunict.main.service.MainService;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainMapper dao;
	
	@Transactional
	@Override
	public List<MusicVo> selectMusic() {
		return dao.selectMusic();
	}
	
}