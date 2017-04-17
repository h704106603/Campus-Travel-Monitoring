package com.service;

import java.util.List;

import com.entity.StudentLocation;
import com.entity.LocationDetails;

/**
 * 
 * @author Hangxiao
 * 找到用户的同学好友的出行情况
 */
public interface FindStudentService {

    /**
     * 
     * @param studentId 学生的id
     * @return 学生出行地点
     */
	List<StudentLocation> findStudent(String studentId);
	
	
	/**
     * 
     * @param studentId 学生的id
     * @return 学生出行地点
     */
	List<LocationDetails> findStudentDetails(String studentId);

}
