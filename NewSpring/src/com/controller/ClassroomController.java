package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.ClassroomService;
import com.service.EchartsClassroomService;

import net.sf.json.JSONObject;

@Controller
public class ClassroomController {

	@Autowired
	private EchartsClassroomService echartsClassroomService;
	
	@Autowired
	private ClassroomService classroomService;
	
	/**
	 * 直接访问教室echarts图页面
	 * @return
	 */
	@RequestMapping("/EchartsClassroomBar")
  	public ModelAndView BathroomIndex(){
		return new ModelAndView("echartsClassroomBar");
	}
	/**
	 * 得到某个教室的Echarts图
	 * @param classroom
	 * @return
	 */
	@RequestMapping(value = "/EchartsClassroomById",method= RequestMethod.GET) 
    @ResponseBody  
    public Map<String, Object> EchartsClassroomById(String classroom){
		System.out.println("classroom"+classroom);
        Map<String, Object> result=new HashMap<String, Object>();
        String message = echartsClassroomService.ClassroomBar(classroom); 
        result.put("data",message);  
        return result;  
    }
	
	
	//教学楼教室情况
    @RequestMapping(value = "/AcademicBuildingBar")
    public ModelAndView AcademicBuildingBar(){
        Map<String, Object> message =classroomService.AcademicBuildingBar();
        JSONObject json = JSONObject.fromObject(message);
        return new ModelAndView("academicBuildingBar", "message", json.toString());
    }
    
    
    
	
	
	
	
	
}
