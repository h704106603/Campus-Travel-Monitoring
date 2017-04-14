package com.service;

import com.entity.Student;

/**
 * 登录校验判断接口
 * @author Hangxiao
 *
 */
public interface LoginService {

    /**
     * 判断是否登录成功
     * @param id 用户的id 
     * @param password 用户的密码
     * @return 如果用户id，密码正确，登录成功返回true，否则返回false
     */
	boolean isAdmin(String id,String password);
	
	/**
	 * 用户注册
	 * @param id id
	 * @param name 姓名
	 * @param grade 班级
	 * @param password 密码
	 * @return 注册成功为true，注册不成功为false
	 */
	boolean Register(String id, String name, String grade,
	                String password);
	
	/**
	 * 根据学生id查学生对象返回前台
	 * @param id
	 * @return
	 */
	Student getStudentById(String id);
	
}
