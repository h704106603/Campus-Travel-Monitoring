package com.service.impl;

import java.util.List;


import com.dao.ExecuteQuery;
import com.entity.Student;
import com.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@javax.annotation.Resource(name="LocalOracleDao")
	private com.dao.LocalOracleDao LocalOracleDao;
	
	@Override
	public String findPasswordById(String id) {
		String sql = "select '1',password from student where id = '{id}'";
		sql = sql.replaceAll("\\{id\\}", id);
		String password = new String();
		
		try {
			List<Object[]> list  = LocalOracleDao.getResultForSql(sql);
			if(list!=null && list.size()>0){
				for (Object[] objData : list) {
					
					password= objData[1]==null ? "" : String.valueOf(objData[1]);
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

	@Override
	public boolean saveStudent(Student student) {
		String sql = "insert into Student (ID,NAME,GRADE,PASSWORD)values('"+student.getId()+"','"+student.getName()+"','"+student.getGrade()+"','"+student.getPassword()+"')";
		System.out.println(sql);
		boolean ifInsertSuccess = ExecuteQuery.executeQuery(sql);
		return ifInsertSuccess;
	}

}
