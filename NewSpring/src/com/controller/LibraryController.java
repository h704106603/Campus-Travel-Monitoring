package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.BathroomService;
import com.service.EchartsBathroomService;
import com.service.EchartsLibraryService;
import com.service.LibraryService;

import net.sf.json.JSONObject;


@Controller
public class LibraryController{

    /**
     * 1. 使用RequestMapping注解来映射请求的URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
     * 通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发操作
     * "/chart/success.jsp"
     * @return
     */
    //图书馆人数近两小时柱状图明细
    @Autowired
    private LibraryService libraryService;
    
    @Autowired
    private EchartsLibraryService echartsLibraryService;
    
    //全部人数情况饼图
    @RequestMapping(value = "/LibraryBar")
    public ModelAndView LibraryBar(){
        Map<String, Object> message =libraryService.Bar();
        JSONObject json = JSONObject.fromObject(message);
        return new ModelAndView("libraryBar", "message", json.toString());
    }
    
    //浴室总饼图
    @RequestMapping(value = "/AllLibraryPie")
    public ModelAndView AllLibraryPie(){
        Map<String, Object> message =libraryService.Pie();
        JSONObject json = JSONObject.fromObject(message);
        return new ModelAndView("libraryPie", "message", json.toString());
    }
    
    //各个阅览室饼图
    @RequestMapping(value = "/EachLibraryPie")
    public ModelAndView EachLibraryPie(){
        Map<String, Object> message =libraryService.Pie();
        JSONObject json = JSONObject.fromObject(message);
        return new ModelAndView("eachLibrary", "message", json.toString());
    }
    
    @RequestMapping(value = "/EchartsLibraryBar1",method= RequestMethod.GET) 
    @ResponseBody  
    public Map<String, Object> EchartsLibraryBar1(){  
        Map<String, Object> result=new HashMap<String, Object>();
        String message = echartsLibraryService.LibraryBar("1"); 
        result.put("data",message);  
        return result;  
    } 
    
    
    @RequestMapping(value = "/EchartsLibraryBar2",method= RequestMethod.GET) 
    @ResponseBody  
    public Map<String, Object> EchartsLibraryBar2(){  
        Map<String, Object> result=new HashMap<String, Object>();
        String message = echartsLibraryService.LibraryBar("2"); 
        result.put("data",message);  
        return result;  
    } 
     
     
}
