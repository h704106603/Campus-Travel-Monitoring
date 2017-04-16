package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.ClassroomService;

import net.sf.json.JSONObject;

@Controller
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;
	
	 @RequestMapping(value = "/ClassroomBar")
	    public ModelAndView CanteenBar(String classroom){
	        Map<String, Object> message =classroomService.ClassroomBar(classroom);
	        JSONObject json = JSONObject.fromObject(message);
	        return new ModelAndView("classroomBar", "message", json.toString());
	    }
}
