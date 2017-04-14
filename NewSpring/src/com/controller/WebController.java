package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Student;
import com.entity.User;
import com.service.BathroomService;
import com.service.FindStudentService;

import com.github.abel533.echarts.Option;


@Controller
public class WebController {

    /**
     * 1. 使用RequestMapping注解来映射请求的URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
     * 通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发操作
     * "/chart/success.jsp"
     * @return
     */
    
//    @Resource(name="echartsTestService")
//	private EchartsTestServiceImpl echartsTestService;

//  	@RequestMapping("/EchartsTest")
//	public ModelAndView EchartsTest() {
//		String message = echartsTestService.showBar1();
//		//System.out.println(message);
//		return new ModelAndView("echartsTest", "message", message);
//	}
//  	
//  	
//  	@RequestMapping(value="/newEchartsTest",method=RequestMethod.POST)  
//    public @ResponseBody String newEchartsTest(){  
//        String message = echartsTestService.showBar1(); 
//        System.out.println(message);
//        return message;  
//    }  
//  	
//  	@RequestMapping(value = "/newEchartsTest3",method= RequestMethod.GET) 
//  	@ResponseBody  
//    public Map<String, Object> newEchartsTest3(){  
//    	System.out.println("执行了newEchartsTest3方法");
//        Map<String, Object> result=new HashMap<String, Object>();
//        String message = echartsTestService.showBar1(); 
//        result.put("data",message);  
//        return result;  
//    }  
  	
  	
  	
  	
  	 
  	 
  	
  	 
  	
  	 
  	 
}