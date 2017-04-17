package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.TheatreShow;
import com.service.TheatreService;
import com.service.TheatreShowDetailsService;

import net.sf.json.JSONObject;

@Controller
public class TheatreController{

    //剧场近一小时人数柱状图明细
    @Autowired
    private TheatreService theatreService;
    
    @RequestMapping(value = "/TheatreBar")
    public ModelAndView TheatreBar(){
        Map<String, Object> message =theatreService.Bar();
        JSONObject json = JSONObject.fromObject(message);
        return new ModelAndView("theatreBar", "message", json.toString());
    }
    
    //剧场总分布情况
    @RequestMapping(value = "/AllTheatrePie")
    public ModelAndView AllTheatrePie(){
        Map<String, Object> message =theatreService.Pie();
        JSONObject json = JSONObject.fromObject(message);
        return new ModelAndView("theatrePie", "message", json.toString());
    }
    
    //各个剧场的分布情况
    @RequestMapping(value = "/EachTheatrePie")
    public ModelAndView EachTheatrePie(){
        Map<String, Object> message =theatreService.Pie();
        JSONObject json = JSONObject.fromObject(message);
        return new ModelAndView("eachTheatre", "message", json.toString());
    }
    
    
    //得到近期剧场秀的活动
    @RequestMapping(value = "/TheatreShowDetails",method= RequestMethod.GET) 
    @ResponseBody 
    public Map<String, Object> TheatreShowDetails(){
        Map<String, Object> result=new HashMap<String, Object>();
        List<TheatreShow> theatreShowList =theatreService.findTheatreShowDetails();
        result.put("theatreShowList",theatreShowList);  
        return result;  
    }
    
    //点赞
    @Autowired
	private TheatreShowDetailsService theatreShowDetailsService;
    @RequestMapping(value = "/TheatreThumbs")
    public ModelAndView TheatreThumbs(String id){
    	System.out.println("ModelAndView TheatreThumbs:"+id);
    	theatreShowDetailsService.TheatreThumbs(id);
        return new ModelAndView("redirect:/TheatreShowInIndex");
    }
    
    
}
