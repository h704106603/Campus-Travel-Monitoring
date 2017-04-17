package com.test;

import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  
/** 
 * Junit测试基类 
 * 继承AbstractTransactionalJUnit4SpringContextTests 
 * 可实现事务回滚 
 * @author javaw 
 * 
 */  
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:config/spring-orm.xml","classpath:config/spring-app-logic.xml"})  
public abstract class BaseTransactionTestCase extends AbstractJUnit4SpringContextTests{
	
  
}  