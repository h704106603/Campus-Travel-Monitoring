//package com.jackie.springmvc.handlers;
//
//import java.util.Map;
//
//import net.sf.json.JSONObject;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.service.impl.EchartsTestServiceImpl;
//import com.service.impl.FushionChartsTestServiceImpl;
//
//
//@Controller
//public class WebController {
//
//    /**
//     * 1. 使用RequestMapping注解来映射请求的URL
//     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
//     * 通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发操作
//     * "/chart/success.jsp"
//     * @return
//     */
//    @RequestMapping("/helloworld")
//    public String hello(){
//        System.out.println("hello world");
//        return "success";
//    }
//    
//    
//
//  	@RequestMapping("/EchartsTest")
//	public ModelAndView EchartsTest() {
//  		EchartsTestServiceImpl impl = new EchartsTestServiceImpl();
//		String message = impl.showBar1();
//		return new ModelAndView("echartsTest", "message", message);
//	}
//  	
//  	@RequestMapping(value = "/FushionCharts")
//	public ModelAndView FushionCharts(){
//  		FushionChartsTestServiceImpl impl = new FushionChartsTestServiceImpl();
//		Map<String, Object> message =impl.getData(false);
//		JSONObject json = JSONObject.fromObject(message);
//		return new ModelAndView("fushionCharts", "message", json.toString());
//	}
//}