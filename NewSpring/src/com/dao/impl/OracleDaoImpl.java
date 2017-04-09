package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LocalOracleDao;
import com.entity.RadiusBean;

public class OracleDaoImpl extends BaseDaoImpl implements LocalOracleDao {
	protected static final Logger logger = LoggerFactory
	.getLogger(OracleDaoImpl.class);
	public List<Object> findResultBySql(String sql, Object... params)
			throws Exception {
		return this.findByNativeQuery(sql, null, params);
	}

	public <T> List<T> findResultBySql(String sql, Class<T> clazz, Object... params)
			throws Exception {
		return this.findByNativeQuery(sql, clazz, params);
	}
	
	public List<Object[]> getResultForSql(String sql) throws Exception {
		
		return this.findByNativeQuery(sql, null);
	}
	
	public List<Object[]> getObject(String sql) {
		try {
			return this.findByNativeQuery(sql, null, null);
		} catch (Exception e) {
			logger.info("\n**************>shkf dao 获取数据异常<**************\n");
			e.printStackTrace();
		}
		return null;
	}
	
	public List<RadiusBean> getData(String sql) {
		List<Object[]> result = new ArrayList<Object[]>();
		List<RadiusBean> resList = new ArrayList<RadiusBean>();
		try{
			result = this.findByNativeQuery(sql, null, null);
		}catch(Exception e){
			logger.info("获取数据异常");
			e.printStackTrace();
		}
		if(result != null && result.size() > 0){
			for (int i = 0; i < result.size(); i++) {
				String now_time = String.valueOf(result.get(i)[0]);  
				long cost_time = java.lang.Long.valueOf(result.get(i)[1].toString());
				String type = String.valueOf(result.get(i)[2]);
				
				RadiusBean bean = new RadiusBean();
				bean.setNOW_TIME(now_time);
				bean.setCOST_TIME(cost_time);
				bean.setTYPE(type);
				resList.add(bean);
			}
		}
		return resList;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int updateBySql(String sql, Object ... params) throws Exception {
		return this.executeUpdate(sql, null, params);
	}

}
