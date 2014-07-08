package com.bangdj.stock.chartpattern.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangdj.stock.chartpattern.dao.SpecialPatternDAO;
import com.bangdj.stock.chartpattern.service.SpecialPatternService;

@Service
/*
 * Service Layer 클래스
 */
public class SpecialPatternServiceImpl implements SpecialPatternService {
	
	@Autowired
	private SpecialPatternDAO specialPatternDAO;	

	@Override
	public List<HashMap<String, String>> getUpTailSideBySideList() {
		return specialPatternDAO.getUpTailSideBySideList();
	}
	
}