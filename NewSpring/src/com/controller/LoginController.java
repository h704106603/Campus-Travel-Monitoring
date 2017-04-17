package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Student;
import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
  	private LoginService loginService;
	
	/**
	 * 转到
	 * @return登录页面
	 */
	@RequestMapping("/Login")
  	public ModelAndView Login(){
		return new ModelAndView("login");
	}
	
  	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
  	public ModelAndView doLogin(String studentId,String password,HttpSession session){
  		
  		
  		//为了调试其他功能，可以跳过数据库验证
  		if(loginService.isAdmin(studentId, password)){
  			Student student = loginService.getStudentById(studentId);
  		    session.setAttribute("name", student.getName());
  		    session.setAttribute("studentId", studentId);
  			return new ModelAndView("success");
  		}
//  	    if(true){
//  	      session.setAttribute("name", "杭晓言");
//  	      session.setAttribute("studentId", studentId);
//  	      return new ModelAndView("success");
//  	    }
  		else{
  			String str = new String("登录失败");
  			return new ModelAndView("login","wrongmessage",str);
  		}
		
	}
  	
  	
  	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
  	public ModelAndView doRegister(String studentId,String password,String name,String grade,HttpSession session){
  		
  		
  		if(loginService.Register(studentId, name, grade, password)){
  		    session.setAttribute("studentId", studentId);
  		    session.setAttribute("name", name);
  		    return new ModelAndView("success");
  		}
  		else{
  			return new ModelAndView("login","wrongmessage","注册失败");
  		}
		
	}
  	
  	
}
