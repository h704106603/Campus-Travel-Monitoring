// $Id: BaseDao.java,v 1.1 2016/06/06 09:02:15 wangjin Exp $
package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTemplate;


/**
 * @author william xu
 */
public interface BaseDao<T> {
	public JpaTemplate getJpaTemplate();
	
	public JdbcTemplate getJdbcTemplate();
	
	public T find(long id);
	public T find(Object id);
	public Object find(Class entityClass, Object id);

	/**
	 * 
	 * @param queryString
	 * @param params
	 * params的第一个参数是查询参数：
	 * 使用如下的位置参数时，查询参数类型Object[]：
	 * SELECT u FROM UserInfo u where u.id=?1
	 * 使用如下的名字参数时，查询参数类型Map：
	 * SELECT u FROM UserInfo u where u.id=:id
	 * params的第二个参数是maxResult，查询的最大记录数，类型是int
	 * params的第三个参数是firstResult，查询记录的偏移，类型是int
	 * 
	 * @return
	 */
	public List find(final String queryString, final Object... params);
	
	public List findByNativeQuery(final String queryString, final Class objectClass, final Object... params);
	
	public List findByNamedQuery(final String queryName, final Object... params);
	
	public void merge(T t);
	public void persist(T t);
	public void remove(T t);
	
	public int executeUpdate(final String updateString, final Class objectClass, final Object... params);
	
	public void refresh(T t);
	public void flush();
	
}
