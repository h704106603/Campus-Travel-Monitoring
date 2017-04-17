package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.entity.TheatreShowDetails;
import com.service.LoginService;
import com.service.StudentService;
import com.service.TheatreShowDetailsService;

@Controller
public class IndexController {

	/**
	 * 转到
	 * @return浴室情况首页
	 */
	@RequestMapping("/BathroomIndex")
  	public ModelAndView BathroomIndex(){
		return new ModelAndView("bathroomIndex");
	}
	
	@RequestMapping("/Index")
  	public ModelAndView Index(){
		return new ModelAndView("success");
	}
	
	/**
	 * 转到
	 * @return图书馆情况首页
	 */
	@RequestMapping("/LibraryIndex")
  	public ModelAndView LibraryIndex(){
		return new ModelAndView("libraryIndex");
	}
	
	/**
	 * 转到
	 * @return食堂情况首页
	 */
	@RequestMapping("/CanteenIndex")
  	public ModelAndView CanteenIndex(){
		return new ModelAndView("canteenIndex");
	}
	
	
	/**
	 * 转到
	 * @return食堂情况首页
	 */
	@RequestMapping("/TheatreIndex")
  	public ModelAndView TheatreIndex(){
		return new ModelAndView("theatreIndex");
	}
	
	
	/**
	 * 转到
	 * @return教室情况首页
	 */
	@RequestMapping("/ClassroomIndex")
  	public ModelAndView ClassroomIndex(){
		return new ModelAndView("classroomIndex");
	}
	
	@Autowired
	private TheatreShowDetailsService theatreShowDetailsService;
	
	
	/**
     * 转到首页中的剧场活动展示模块
     * @return
     */
    @RequestMapping("/TheatreShowInIndex")
    public ModelAndView TheatreShowInIndex(Model model){
    	
    	List<TheatreShowDetails> theatreShowDetailsList = theatreShowDetailsService.ShowTheatreShowDetails();
        model.addAttribute(theatreShowDetailsList);
    	return new ModelAndView("theatreShowInIndex");
    }
  	
    
    
	
  	
  	
}
