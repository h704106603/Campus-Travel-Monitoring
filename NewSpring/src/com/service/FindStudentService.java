package com.service;

import java.util.List;

import com.entity.Student;

public interface FindStudentService {

	public List<Student> findStudent(String studentId);
}
