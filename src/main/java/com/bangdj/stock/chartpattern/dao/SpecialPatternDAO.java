package com.bangdj.stock.chartpattern.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface SpecialPatternDAO {
	public List<HashMap<String, String>> getUpTailSideBySideList();
}