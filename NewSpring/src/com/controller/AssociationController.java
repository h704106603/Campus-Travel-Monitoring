package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.AssociationDetailsService;

@Controller
public class AssociationController {

	//剧场近一小时人数柱状图明细
    @Autowired
    private AssociationDetailsService associationDetailsService;
    
    @RequestMapping(value = "/AssociationThumbs")
    public ModelAndView AssociationThumbs(String id){
    	System.out.println("ModelAndView AssociationThumbs:"+id);
    	associationDetailsService.AssociationThumbs(id);
        return new ModelAndView("redirect:/AssociationInIndex");
    }
}
