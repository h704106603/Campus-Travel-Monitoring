package com.service;

import com.entity.Student;

/**
 * 注册登录过程中对学生信息操作的接口
 * @author Hangxiao
 *
 */
public interface StudentService {

    /**
     * 根据id查找密码
     * @param id 
     * @return 密码字符串
     */
	String findPasswordById(String id);
    
	/**
	 * 注册保存学生信息入库
	 * @param student
	 * @return 成功为true，失败为false
	 */
	boolean saveStudent(Student student);
	
	/**
	 * 根据id查询学生对象
	 * @param id 学生id
	 * @return
	 */
	Student getStudentById(String id);
}
