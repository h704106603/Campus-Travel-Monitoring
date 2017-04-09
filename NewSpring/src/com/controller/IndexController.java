package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.service.LoginService;
import com.service.StudentService;

@Controller
public class IndexController {

	/**
	 * 转到
	 * @return浴室首页
	 */
	@RequestMapping("/BathroomIndex")
  	public ModelAndView BathroomIndex(){
		return new ModelAndView("bathroomIndex");
	}
	
	@RequestMapping("/Index")
  	public ModelAndView Index(){
		return new ModelAndView("success");
	}
	
	
  	
	
  	
  	
}
