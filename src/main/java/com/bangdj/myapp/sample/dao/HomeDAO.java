package com.bangdj.myapp.sample.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
/*
 * Data Access Object 클래스
 */
public interface HomeDAO {
	public List<HashMap<String, String>> getHomeList();
}