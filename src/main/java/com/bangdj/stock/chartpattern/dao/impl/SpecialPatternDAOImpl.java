package com.bangdj.stock.chartpattern.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bangdj.stock.chartpattern.dao.SpecialPatternDAO;


@Repository
public class SpecialPatternDAOImpl implements SpecialPatternDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(SpecialPatternDAOImpl.class);
	
	@Override
	public List<HashMap<String, String>> getUpTailSideBySideList() {
		logger.info("dao getUpTailSideBySideList()");
		List<HashMap<String, String>> resultList = sqlSession.selectList("chartpattern.selectUpTailSideBySideList");
		
		return resultList;
		
	}
}