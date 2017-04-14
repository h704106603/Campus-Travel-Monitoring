package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.CanteenService;

import net.sf.json.JSONObject;

@Controller
public class CanteenController{

    /**
     * 1. 使用RequestMapping注解来映射请求的URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
     * 通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发操作
     * "/chart/success.jsp"
     * @return
     */
    //食堂人数近一小时柱状图明细
    @Autowired
    private CanteenService canteenService;
    
    @RequestMapping(value = "/CanteenBar")
    public ModelAndView CanteenBar(){
        Map<String, Object> message =canteenService.Bar();
        JSONObject json = JSONObject.fromObject(message);
        return new ModelAndView("canteenBar", "message", json.toString());
    }
    
    //食堂总饼图
    @RequestMapping(value = "/AllCanteenPie")
    public ModelAndView AllCanteenPie(){
        Map<String, Object> message =canteenService.Pie();
        JSONObject json = JSONObject.fromObject(message);
        return new ModelAndView("canteenPie", "message", json.toString());
    }
    
    //各个食堂
    @RequestMapping(value = "/EachCanteenPie")
    public ModelAndView EachCanteenPie(){
        Map<String, Object> message =canteenService.Pie();
        JSONObject json = JSONObject.fromObject(message);
        return new ModelAndView("eachCanteen", "message", json.toString());
    }
    
     
}
