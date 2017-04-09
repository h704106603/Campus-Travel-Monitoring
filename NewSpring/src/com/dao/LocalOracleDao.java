package com.dao;

import java.util.List;


import com.entity.RadiusBean;

public interface LocalOracleDao {

	List<Object> findResultBySql(String sql, Object... params) throws Exception;

	<T> List<T> findResultBySql(String sql, Class<T> clazz, Object... params)
			throws Exception;
	
	public List<Object[]> getResultForSql(String sql) throws Exception;
	
	public List<Object[]> getObject(String sql);
	
	public List<RadiusBean> getData(String sql);
	
	public int updateBySql(String sql, Object ... params) throws Exception;
}
