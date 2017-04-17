package com.service;

import java.util.List;

import com.entity.TheatreShowDetails;

public interface TheatreShowDetailsService {

	/**
	 * 显示所有剧场信息
	 * @return
	 */
     List<TheatreShowDetails> ShowTheatreShowDetails();
     
     void TheatreThumbs(String id);
}
