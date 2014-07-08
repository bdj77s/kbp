package com.bangdj.myapp.sample.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangdj.myapp.sample.dao.HomeDAO;
import com.bangdj.myapp.sample.service.HomeService;

@Service
/*
 * Service Layer 클래스
 */
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeDAO homeDAO;	

	@Override
	public List<HashMap<String, String>> getHomeList() {
		return homeDAO.getHomeList();
	}
	
}