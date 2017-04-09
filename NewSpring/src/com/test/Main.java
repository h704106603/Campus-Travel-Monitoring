package com.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.impl.FushionChartsTestServiceImpl;


public class Main {

	/**
	 * @param args
	 */
	private String who = null;
	
	public static void main(String[] args) {
		

	    /*HelloApi bean6 = factory.getBean("bean6", HelloApi.class);  
	    bean6.sayHello(); */ 
			
		ClassPathXmlApplicationContext  act = new ClassPathXmlApplicationContext("classpath:config/spring-app-logic.xml");
		
		FushionChartsTestServiceImpl boss =  (FushionChartsTestServiceImpl) act.getBean("fushionChartsTestService");
		
		System.out.println(boss.toString());
		
		act.destroy();
				
		
	}

}
