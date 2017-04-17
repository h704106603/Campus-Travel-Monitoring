package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.dao.BaseDao;
import com.entity.AssociationDetails;
import com.entity.Student;
import com.entity.AssociationDetails;
import com.service.AssociationDetailsService;
import com.service.AssociationDetailsService;
import com.util.ResourceUtils;

public class AssociationDetailsServiceImpl implements AssociationDetailsService {

	@javax.annotation.Resource(name="LocalOracleDao")
    private com.dao.LocalOracleDao LocalOracleDao;
    
	@javax.annotation.Resource(name = "baseDao")
	private BaseDao baseDao;
	
    @Value("classpath:config/Association/showAssociationDetails.sql")
    private Resource ShowAssociationDetailsSql;
    
    @Value("classpath:config/Association/associationThumbs.sql")
    private Resource AssociationThumbsSql;
    
	@Override
	public List<AssociationDetails> ShowAssociationDetails() {
		
		List<AssociationDetails> associationDetailsList = new ArrayList<AssociationDetails>();
		
		try {
			String sql = ResourceUtils.getStringFromResource(ShowAssociationDetailsSql);
			List<Object[]> list = LocalOracleDao.getResultForSql(sql);
			if(list!=null && list.size()>0){
				
				for(Object[] obj:list){	
					String id = obj[0] == null? "0" : obj[0].toString();
					String name = obj[1] == null? "0" : obj[1].toString();	
					String imgSrc = obj[2] == null? "0" : obj[2].toString();	
					String time = obj[3] == null? "0" : obj[3].toString();
					String count = obj[4] == null? "0" : obj[4].toString();
					
					associationDetailsList.add(new AssociationDetails(id, name, imgSrc, time, count));
				}
			}
			else{
				return null;
			}
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		return associationDetailsList;
	}

	@Override
	public void AssociationThumbs(String id) {
		
		
		try {
			String sql = ResourceUtils.getStringFromResource(AssociationThumbsSql);
			sql = sql.replaceAll("\\{id\\}", id);
			System.out.println(sql);
			this.baseDao.executeUpdate(sql,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------社团活动信息id为:"+id);
		
	}

}
