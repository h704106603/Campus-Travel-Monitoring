package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GetAllLocationScoreController{

    @RequestMapping(value = "/GetAllLocationScore",method= RequestMethod.GET) 
    @ResponseBody  
    public Map<String, Object> ShowScore(){  
        Map<String, Object> result=new HashMap<String, Object>();
        result.put("LibraryScore","68");
        result.put("BathroomScore","780");
        result.put("CanteenScore","80");
        result.put("TheatreScore","90");
        result.put("ClassroomScore","80");
        
        return result;  
    }  
}
