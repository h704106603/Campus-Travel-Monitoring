package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Student;
import com.service.LoginService;
import com.service.StudentService;

public class LoginServiceImpl implements LoginService {

	@javax.annotation.Resource(name="LocalOracleDao")
	private com.dao.LocalOracleDao LocalOracleDao;
	
	@Autowired
  	private StudentService studentService;
	
	public boolean isAdmin(String id,String password){
		String findPassword = studentService.findPasswordById(id);
		if(findPassword.equals(password)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean Register(String id, String name, String grade,
			String password) {
		
		return (studentService.saveStudent(new Student(id, name, grade, password)));
	}
}
