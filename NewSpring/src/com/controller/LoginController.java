package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
  	public ModelAndView doLogin(String username,String password,HttpSession session){
  		
  		session.setAttribute("username", username);
  		if(loginService.isAdmin(username, password)){
  			return new ModelAndView("success");
  		}
  		else{
  			String str = new String("登录失败");
  			return new ModelAndView("login","wrongmessage",str);
  		}
		
	}
  	
  	
  	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
  	public ModelAndView doRegister(String username,String password,String name,String grade,HttpSession session){
  		
  		session.setAttribute("username", username);
  		if(loginService.Register(username, name, grade, password)){
  			return new ModelAndView("success");
  		}
  		else{
  			return new ModelAndView("login","wrongmessage","注册失败");
  		}
		
	}
  	
  	
}
