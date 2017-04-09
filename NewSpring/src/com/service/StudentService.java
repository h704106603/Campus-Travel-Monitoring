package com.service;

import com.entity.Student;

public interface StudentService {

	String findPasswordById(String id);
    
	boolean saveStudent(Student student);
}
