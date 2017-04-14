package com.controller;

import org.springframework.stereotype.Controller;

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