package com.controller;

import java.util.HashMap;
import java.util.Map;


import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.BathroomService;
import com.service.EchartsBathroomService;



@Controller
public class BathroomController {

    /**
     * 1. 使用RequestMapping注解来映射请求的URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
     * 通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发操作
     * "/chart/success.jsp"
     * @return
     */
  	//浴室人数近一小时柱状图明细
  	@Autowired
  	private BathroomService bathroomService;
  	
  	@Autowired
	private EchartsBathroomService echartsBathroomService;
  	
  	
  	@RequestMapping(value = "/BathroomBar")
	public ModelAndView BathroomBar(){
		Map<String, Object> message =bathroomService.Bar();
		JSONObject json = JSONObject.fromObject(message);
		return new ModelAndView("bathroomBar", "message", json.toString());
	}
  	
  	//浴室总饼图
  	@RequestMapping(value = "/AllBathroomPie")
	public ModelAndView AllBathroomPie(){
		Map<String, Object> message =bathroomService.Pie();
		JSONObject json = JSONObject.fromObject(message);
		return new ModelAndView("bathroomPie", "message", json.toString());
	}
  	
  	//各个浴室
  	@RequestMapping(value = "/EachBathroomPie")
	public ModelAndView EachBathroomPie(){
		Map<String, Object> message =bathroomService.Pie();
		JSONObject json = JSONObject.fromObject(message);
		return new ModelAndView("eachBathroom", "message", json.toString());
	}
  	
  	@RequestMapping(value = "/EchartsBathroomBar1",method= RequestMethod.GET) 
  	@ResponseBody  
    public Map<String, Object> EchartsBathroomBar1(){  
    	System.out.println("执行了EchartsBathroomBar方法");
        Map<String, Object> result=new HashMap<String, Object>();
        String message = echartsBathroomService.BathroomBar("1"); 
        result.put("data",message);  
        return result;  
    } 
  	
  	
  	@RequestMapping(value = "/EchartsBathroomBar2",method= RequestMethod.GET) 
  	@ResponseBody  
    public Map<String, Object> EchartsBathroomBar2(){  
    	System.out.println("执行了EchartsBathroomBar方法");
        Map<String, Object> result=new HashMap<String, Object>();
        String message = echartsBathroomService.BathroomBar("2"); 
        result.put("data",message);  
        return result;  
    } 
  	 
  	 
}