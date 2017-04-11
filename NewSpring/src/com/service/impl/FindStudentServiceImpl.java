package com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.entity.StudentLocation;
import com.entity.User;
import com.service.FindStudentService;
import com.util.ResourceUtils;

public class FindStudentServiceImpl implements FindStudentService {

	//本地Dao
	@javax.annotation.Resource(name="LocalOracleDao")
	private com.dao.LocalOracleDao LocalOracleDao;
	
	@Value("classpath:config/FindStudent/findStudent.sql")
	private Resource findStudentSql;
	
	public List<StudentLocation> findStudent(String studentId){
		
		List<StudentLocation> resultStudentLocation = new ArrayList<StudentLocation>();
//		try {
//			String sql = ResourceUtils.getStringFromResource(findStudentSql);
//			System.out.println(sql);
//			sql = sql.replaceAll("\\{id\\}", studentId);
//			List<Object[]> list = LocalOracleDao.getResultForSql(sql);
//			if(list!=null && list.size()>0){
//				
//				for(Object[] obj:list){	
//					String id = obj[0] == null? "0" : obj[0].toString();
//					String name = obj[1] == null? "0" : obj[1].toString();	
//					String grade = obj[2] == null? "0" : obj[2].toString();	
//					
//					resultStudent.add(new Student(id, name, grade,null));
//				}
//			}
//			else{
//				return null;
//			}
//		}
//		catch (Exception e1) {
//			e1.printStackTrace();
//		}
		for(int i=0;i<20;i++){
	        String name = "杭晓言";
	        String grade = "计科131";
	        
	        //因为前台拿数据遍历不方便，所以设置String将map中数据拼接进去
	        String locationMapString = "";
	        for(int k=0;k<6;k++){
	            String location = "公共浴室1    ";
	            String date = "4月11日<br>";
	            locationMapString = locationMapString + location + date;
	        }
	        
	        resultStudentLocation.add(new StudentLocation(name, grade, locationMapString)); 
		}
		 
		return resultStudentLocation;
	}
	
}
