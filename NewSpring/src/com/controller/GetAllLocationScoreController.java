package com.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.service.GetAllLocationScoreService;


@Controller
public class GetAllLocationScoreController{

    
    @Autowired
    private GetAllLocationScoreService getAllLocationScoreService;
    
    
    @RequestMapping(value = "/GetAllLocationScore",method= RequestMethod.GET) 
    @ResponseBody  
    public Map<String, Object> ShowScore(){  
        System.out.println("ShowScore");
        Map<String, Object> result=new HashMap<String, Object>();
        result = getAllLocationScoreService.ShowScore();
        return result;  
    }  
}
