package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.entity.Student;
import com.entity.TheatreShowDetails;
import com.service.TheatreShowDetailsService;
import com.util.ResourceUtils;

public class TheatreShowDetailsServiceImpl implements TheatreShowDetailsService {

	@javax.annotation.Resource(name="LocalOracleDao")
    private com.dao.LocalOracleDao LocalOracleDao;
    
    @Value("classpath:config/TheatreShow/showTheatreShowDetails.sql")
    private Resource ShowTheatreShowDetailsSql;
    
	@Override
	public List<TheatreShowDetails> ShowTheatreShowDetails() {
		
		List<TheatreShowDetails> theatreShowDetailsList = new ArrayList<TheatreShowDetails>();
		
		try {
			String sql = ResourceUtils.getStringFromResource(ShowTheatreShowDetailsSql);
			List<Object[]> list = LocalOracleDao.getResultForSql(sql);
			if(list!=null && list.size()>0){
				
				for(Object[] obj:list){	
					String id = obj[0] == null? "0" : obj[0].toString();
					String name = obj[1] == null? "0" : obj[1].toString();	
					String imgSrc = obj[2] == null? "0" : obj[2].toString();	
					String time = obj[3] == null? "0" : obj[3].toString();
					String count = obj[4] == null? "0" : obj[4].toString();
					
					theatreShowDetailsList.add(new TheatreShowDetails(id, name, imgSrc, time, count));
				}
			}
			else{
				return null;
			}
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		return theatreShowDetailsList;
	}

	@Override
	public void TheatreThumbs(String id) {
		
		System.out.println("--------------剧场信息id为:"+id);
		
	}

}
