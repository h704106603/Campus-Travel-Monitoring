package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.dao.ExecuteQuery;
import com.entity.Student;
import com.service.StudentService;
import com.util.ResourceUtils;


public class StudentServiceImpl implements StudentService {

	@javax.annotation.Resource(name="LocalOracleDao")
	private com.dao.LocalOracleDao LocalOracleDao;
	
	@Value("classpath:config/Student/findPasswordById.sql")
	private Resource findPasswordByIdSql;
	
	@Value("classpath:config/Student/saveStudent.sql")
	private Resource saveStudentSql;
	
	@Value("classpath:config/Student/getStudentById.sql")
	private Resource getStudentByIdSql;
	
	@Override
	public String findPasswordById(String id) {
		String sql;
		try {
			sql = ResourceUtils.getStringFromResource(findPasswordByIdSql);
			sql = sql.replaceAll("\\{id\\}", id);
			String password = new String();
			List<Object[]> list  = LocalOracleDao.getResultForSql(sql);
			if(list!=null && list.size()>0){
				for (Object[] objData : list) {
					
					password= objData[1]==null ? "" : String.valueOf(objData[1]);
					return password;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public boolean saveStudent(Student student) {
		
		String sql;
		try {
			sql = ResourceUtils.getStringFromResource(saveStudentSql);
			System.out.println(sql);
			boolean ifInsertSuccess = ExecuteQuery.executeQuery(sql);
			return ifInsertSuccess;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

    @Override
    public Student getStudentById(String id){
    	
    	Student student = new Student();
    	String sql;
		try {
			sql = ResourceUtils.getStringFromResource(getStudentByIdSql);
			sql = sql.replaceAll("\\{id\\}", id);
			List<Object[]> list  = LocalOracleDao.getResultForSql(sql);
			if(list!=null && list.size()>0){
				for (Object[] objData : list) {
					String StudentId = String.valueOf(objData[0]==null?"":objData[0]);
					String name = String.valueOf(objData[1]==null?"":objData[1]);
					String grade = String.valueOf(objData[2]==null?"":objData[2]);
					return(new Student(StudentId, name, grade));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return student;
    }

}
