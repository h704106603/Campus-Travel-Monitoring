package com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.entity.Student;
import com.entity.User;
import com.service.FindStudentService;
import com.util.ResourceUtils;

public class FindStudentServiceImpl implements FindStudentService {

	//本地Dao
	@javax.annotation.Resource(name="LocalOracleDao")
	private com.dao.LocalOracleDao LocalOracleDao;
	
	@Value("classpath:config/FindStudent/findStudent.sql")
	private Resource findStudentSql;
	
	public List<Student> findStudent(String studentId){
		
		List<Student> resultStudent = new ArrayList<Student>();
		try {
			String sql = ResourceUtils.getStringFromResource(findStudentSql);
			System.out.println(sql);
			sql = sql.replaceAll("\\{id\\}", studentId);
			List<Object[]> list = LocalOracleDao.getResultForSql(sql);
			if(list!=null && list.size()>0){
				
				for(Object[] obj:list){	
					String id = obj[0] == null? "0" : obj[0].toString();
					String name = obj[1] == null? "0" : obj[1].toString();	
					String grade = obj[2] == null? "0" : obj[2].toString();	
					
					resultStudent.add(new Student(id, name, grade,null));
				}
			}
			else{
				return null;
			}
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		return resultStudent;
	}
}
