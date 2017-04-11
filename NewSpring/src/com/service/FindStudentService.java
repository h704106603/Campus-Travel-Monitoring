package com.service;

import java.util.List;

import com.entity.StudentLocation;

public interface FindStudentService {

	public List<StudentLocation> findStudent(String studentId);

}
