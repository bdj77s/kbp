package com.bangdj.myapp.sample.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bangdj.myapp.sample.dao.HomeDAO;


@Repository
public class HomeDAOImpl implements HomeDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(HomeDAOImpl.class);
	
	@Override
	public List<HashMap<String, String>> getHomeList() {
		logger.info("dao getHomeList()");
		List<HashMap<String, String>> resultList = sqlSession.selectList("sampleMapper.sample01");
		
		return resultList;
		
	}
}