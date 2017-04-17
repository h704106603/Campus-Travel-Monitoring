package com.service;

import java.util.List;

import com.entity.AssociationDetails;

public interface AssociationDetailsService {

	/**
	 * 显示所有剧场信息
	 * @return
	 */
     List<AssociationDetails> ShowAssociationDetails();
     
     void AssociationThumbs(String id);
}
