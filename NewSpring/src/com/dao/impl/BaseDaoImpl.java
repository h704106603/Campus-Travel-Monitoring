// $Id: BaseDaoImpl.java,v 1.1 2016/06/06 09:02:54 wangjin Exp $
package com.dao.impl;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;

import com.dao.BaseDao;

/**
 * @author william xu
 */
public class BaseDaoImpl<T> implements BaseDao<T>{
	private JpaTemplate jpaTemplate;
	
	protected JdbcTemplate jdbcTemplate;
	
	private int queryTimeout;
	
	private int fetchSize;
	
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType){
			//这样子类可以通过generic把entity传入
			//比如：public class NoticeBoardDaoImpl extends BaseDaoImpl<NoticeBoard>
			entityClass = (Class<T>)((ParameterizedType)type).getActualTypeArguments()[0];
		}
	}

	public BaseDaoImpl(Class<T> type){
		//通过构造器参数传入 ，比如：
		//<constructor-arg>
		//	<value>com.asiainfo.common.entity.NoticeBoard</value>
		//	//<bean class="com.asiainfo.common.entity.NoticeBoard"/>
		//</constructor-arg>
		entityClass = type;
	}
	
	public JpaTemplate getJpaTemplate(){
		return jpaTemplate;
	}
	
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.jpaTemplate = new JpaTemplate(emf);
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getQueryTimeout() {
		return queryTimeout;
	}

	public void setQueryTimeout(int queryTimeout) {
		this.queryTimeout = queryTimeout;
	}
	
	public int getFetchSize() {
		return fetchSize;
	}

	public void setFetchSize(int fetchSize) {
		this.fetchSize = fetchSize;
	}

	public T find(long id){
		return jpaTemplate.find(entityClass, id);
	}
	
	public T find(Object id){
		return jpaTemplate.find(entityClass, id);
	}

	public Object find(Class entityClass, Object id){
		return jpaTemplate.find(entityClass, id);
	}
	
	public List find(final String queryString, final Object... params){
		return jpaTemplate.executeFind(new JpaCallback() {
			public Object doInJpa(EntityManager em) throws PersistenceException {
				Query queryObject = getQueryObject(em, queryString, QueryType.Query, null, params);
				return queryObject.getResultList();
			}
        });   
		
	}
	
	/**
	 * 使用原生查询
	 */
	public List findByNativeQuery(final String queryString, final Class objectClass, final Object... params){
		return jpaTemplate.executeFind(new JpaCallback() {
			public Object doInJpa(EntityManager em) throws PersistenceException {
				Query queryObject = getQueryObject(em, queryString, QueryType.NativeQuery, objectClass, params);
				return queryObject.getResultList();
			}            
        });
	}

	/**
	 * 
	//如果实体类中包含如下的命名查询，则使用此方法：
	//@NamedQuery(name = "findAllUser", query = "SELECT u FROM UserInfo u where u.id=?1")
	//@NamedQuery(name = "findAllUser", query = "SELECT u FROM UserInfo u where u.id=:id")
	 * 
	 */
	public List findByNamedQuery(final String queryName, final Object... params){
		return jpaTemplate.executeFind(new JpaCallback() {
			public Object doInJpa(EntityManager em) throws PersistenceException {
				Query queryObject = getQueryObject(em, queryName, QueryType.NamedQuery, null, params);
				return queryObject.getResultList();
			}
        });   
	}

	public void merge(T t){
		jpaTemplate.merge(t);
	}

	public void persist(T t){
		jpaTemplate.persist(t);
	}

	public void remove(T t){
		jpaTemplate.remove(t);
	}
	
	public int executeUpdate(final String updateString, final Class objectClass, final Object... params){
		return ((Integer)jpaTemplate.execute(new JpaCallback() {
			public Object doInJpa(EntityManager em) throws PersistenceException {
				Query queryObject = null;
				if(objectClass == null)
					queryObject = getQueryObject(em, updateString, QueryType.NativeQuery, null, params);
				else{
					queryObject = getQueryObject(em, updateString, QueryType.Query, objectClass, params);
				}
				return new Integer(queryObject.executeUpdate());
			}
        })).intValue();   
	}
	
	public void refresh(T t){
		jpaTemplate.refresh(t);
	}

	public void flush(){
		jpaTemplate.flush();
	}
	
	public String setMaxResults(String sql, int maxNum){
		return " SELECT * FROM ( " +  sql + " ) T WHERE ROWNUM <= " + String.valueOf(maxNum) + " ";
	}
	
	
	private enum QueryType{
		Query(0),
		NativeQuery(1),
		NamedQuery(2);
		private int value;
		private QueryType(int value){
			this.value = value;
		}
	}
	
	
	private Query getQueryObject(EntityManager em, String queryString, QueryType queryType, Class objectClass, Object...params){
		Query queryObject = null;
		switch (queryType){
			case Query:
				queryObject = em.createQuery(queryString);
				break;
			case NativeQuery:
				if (objectClass == null){
					queryObject = em.createNativeQuery(queryString);
				}else{
					queryObject = em.createNativeQuery(queryString, objectClass);
				}
				break;
			case NamedQuery:
				queryObject = em.createNamedQuery(queryString);
				break;
		}
		if (fetchSize > 0){
			queryObject.setHint("org.hibernate.fetchSize", fetchSize);
		}
		if (queryTimeout > 0){
			queryObject.setHint("org.hibernate.timeout", new Integer(queryTimeout));
		}
		boolean flag = true;
		if (params != null){
			if (params.length>0){
				Object queryParams = params[0];
				if (queryParams != null){
					if (queryParams instanceof Object[]){
						for (int i = 0; i < ((Object[])queryParams).length; i++){
							queryObject.setParameter(i + 1, ((Object[])queryParams)[i]);
						}	
					}else if (queryParams instanceof Map){
						java.util.Map.Entry entry;
						for (Iterator i$ = ((Map)queryParams).entrySet().iterator(); i$.hasNext(); queryObject.setParameter((String) entry.getKey(), entry.getValue())){
							entry = (java.util.Map.Entry) i$.next();
						}
					}else{
						for (int i = 0; i < ((Object[])params).length; i++){
							queryObject.setParameter(i + 1, ((Object[])params)[i]);
							flag = false;
						}	
					}
				}
			}
			if (flag && params.length>1){
				if (params[1] instanceof Integer){
					int maxResult = ((Integer)params[1]).intValue();
					queryObject.setMaxResults(maxResult);
				}
			}
			if (flag && params.length>2){
				if (params[2] instanceof Integer){
					int firstResult = ((Integer)params[2]).intValue();
					queryObject.setFirstResult(firstResult);
				}
			}
		}
		return queryObject;
		
	}
	
	public static String getPageSQL(String sql, int page, int pageSize) {

		int startNum = (page - 1) * pageSize;
		int endNum = startNum + pageSize;

		StringBuffer pagingSelect = new StringBuffer(128);
		pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		pagingSelect.append(sql);
		pagingSelect.append(" ) row_ where rownum <= ");
		pagingSelect.append(endNum);
		pagingSelect.append(") where rownum_ > ");
		pagingSelect.append(startNum);
		
		return pagingSelect.toString();
	}

	public static String getCountSQL(String sql) {
		String regex = "select((.)+)from";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		String[] s = p.split(sql);
		String countSql = "select count(1) as total from " + s[1];
		return countSql;
	}
	
}
