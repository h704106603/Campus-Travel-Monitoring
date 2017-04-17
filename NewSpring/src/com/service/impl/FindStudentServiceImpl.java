package com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.entity.Student;
import com.entity.StudentLocation;
import com.entity.LocationDetails;
import com.entity.StudentLocationFromDbCommand;
import com.service.FindStudentService;
import com.util.ResourceUtils;

public class FindStudentServiceImpl implements FindStudentService {

	//本地Dao
	@javax.annotation.Resource(name="LocalOracleDao")
	private com.dao.LocalOracleDao LocalOracleDao;
	
	@Value("classpath:config/FindStudent/findStudent.sql")
	private Resource findStudentSql;
	
	@Value("classpath:config/FindStudent/friendDetails.sql")
	private Resource friendDetailsSql;
	
	@Value("classpath:config/FindStudent/findStudentLocation.sql")
	private Resource findStudentLocationSql;
	
	
	
	
	public List<LocationDetails> findStudentDetails(String studentId){

		
		List<LocationDetails> resultStudentLocation = new ArrayList<LocationDetails>();
		
		List<Student> resultStudent = new ArrayList<Student>();
		
		String[] LocationString = {"classroom","theatre","canteen","bathroom","library"};
		
		//先找到好友
		try {
			String sql = ResourceUtils.getStringFromResource(friendDetailsSql);
			sql = sql.replaceAll("\\{id\\}", studentId);
			List<Object[]> list = LocalOracleDao.getResultForSql(sql);
			if(list!=null && list.size()>0){
				
				for(Object[] obj:list){	
					String id = obj[0] == null? "0" : obj[0].toString();
					String name = obj[1] == null? "0" : obj[1].toString();	
					String grade = obj[2] == null? "0" : obj[2].toString();	
					
					resultStudent.add(new Student(id, name, grade,null));
				}
			}
			else{
				return null;
			}
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		//每一个好友的遍历，只有一个人，这里借用方法而已
		for (Student student : resultStudent) {
			
			String friendId = student.getId();
			String name = student.getName();
			String grade = student.getGrade();
			//每一个出行地的遍历
			for(int i=0;i<LocationString.length;i++){
				List<StudentLocationFromDbCommand> studentLocationFromDbCommandList = findFriendLocationByFriendId(friendId,LocationString[i]);
				//一个出行地中查询的是最近的情况，一般有一进一出
				
				for (StudentLocationFromDbCommand studentLocationFromDbCommand : studentLocationFromDbCommandList) {
					String location = "";
					String type = studentLocationFromDbCommand.getType().equals("in")?"进入":"离开";
					location = type+studentLocationFromDbCommand.getPlace();
					resultStudentLocation.add(new LocationDetails(name,grade, studentLocationFromDbCommand.getTime(), location));
				}
				
			}
			
			
		}
		return resultStudentLocation;
	
		
		
	}
	public List<StudentLocation> findStudent(String studentId){
		
		List<StudentLocation> resultStudentLocation = new ArrayList<StudentLocation>();
		
		List<Student> resultStudent = new ArrayList<Student>();
		
		String[] LocationString = {"classroom","theatre","canteen","bathroom","library"};
		
		//先找到好友
		try {
			String sql = ResourceUtils.getStringFromResource(findStudentSql);
			sql = sql.replaceAll("\\{id\\}", studentId);
			List<Object[]> list = LocalOracleDao.getResultForSql(sql);
			if(list!=null && list.size()>0){
				
				for(Object[] obj:list){	
					String id = obj[0] == null? "0" : obj[0].toString();
					String name = obj[1] == null? "0" : obj[1].toString();	
					String grade = obj[2] == null? "0" : obj[2].toString();	
					
					resultStudent.add(new Student(id, name, grade,null));
				}
			}
			else{
				return null;
			}
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		//每一个好友的遍历
		for (Student student : resultStudent) {
			
			String friendId = student.getId();
			String name = student.getName();
			String grade = student.getGrade();
			//每一个出行地的遍历
			String locationMap = "";
			for(int i=0;i<LocationString.length;i++){
				List<StudentLocationFromDbCommand> studentLocationFromDbCommandList = findFriendLocationByFriendId(friendId,LocationString[i]);
				//一个出行地中查询的是最近的情况，一般有一进一出
				String location = "";
				for (StudentLocationFromDbCommand studentLocationFromDbCommand : studentLocationFromDbCommandList) {
					
					String type = studentLocationFromDbCommand.getType().equals("in")?"进入":"离开";
					location = location + type + studentLocationFromDbCommand.getPlace()+"<br>";
					
				}
				locationMap = locationMap+location;
				
			}
			resultStudentLocation.add(new StudentLocation(name, grade, locationMap,friendId));
			
		}
		return resultStudentLocation;
	}
	
	
	public List<StudentLocationFromDbCommand> findFriendLocationByFriendId(String friendId,String location){
		
		List<StudentLocationFromDbCommand> studentLocationFromDbCommandList= new ArrayList<StudentLocationFromDbCommand>();
		try {
			String sql = ResourceUtils.getStringFromResource(findStudentLocationSql);
			sql = sql.replaceAll("\\{friendId\\}", friendId);
			sql = sql.replaceAll("\\{location\\}", location);
			List<Object[]> list = LocalOracleDao.getResultForSql(sql);
			if(list!=null && list.size()>0){
				
				for(Object[] obj:list){	
					String studentId = obj[0] == null? "0" : obj[0].toString();
					String time = obj[1] == null? "0" : obj[1].toString();	
					String place = obj[2] == null? "0" : obj[2].toString();	
					String type = obj[3] == null? "0" : obj[3].toString();	
					
					String locationAndPlace = LocationAndPlace(location, place);
					
					StudentLocationFromDbCommand studentLocationFromDbCommand = new StudentLocationFromDbCommand(studentId, time, locationAndPlace, type);
					studentLocationFromDbCommandList.add(studentLocationFromDbCommand);
				}
			}
			else{
				return null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentLocationFromDbCommandList;
		
	}
	
	
	
	public String LocationAndPlace(String location,String place){
		
		
		String LocationAndPlace = "";
		if(location.equals("classroom")){
			LocationAndPlace = place+"教室";
		}
		else if(location.equals("theatre")){
			int placeInt = Integer.parseInt(place);
			switch (placeInt) {
			case 1:
				LocationAndPlace = "130剧场";
				break;
			case 2:
				LocationAndPlace = "146剧场";
				break;
			case 3:
				LocationAndPlace = "346小剧场";
				break;
			default:
				break;
			}
			
		}
		else if(location.equals("canteen")){
			int placeInt = Integer.parseInt(place);
			switch (placeInt) {
			case 1:
				LocationAndPlace = "第一食堂";
				break;
			case 2:
				LocationAndPlace = "第二食堂";
				break;
			case 3:
				LocationAndPlace = "第三食堂";
				break;
			default:
				break;
			}
		}
		else if(location.equals("bathroom")){
			int placeInt = Integer.parseInt(place);
			switch (placeInt) {
			case 1:
				LocationAndPlace = "第一浴室";
				break;
			case 2:
				LocationAndPlace = "第二浴室";
				break;
			case 3:
				LocationAndPlace = "第三浴室";
				break;
			default:
				break;
			}
		}
		else if(location.equals("library")){
			int placeInt = Integer.parseInt(place);
			switch (placeInt) {
			case 1:
				LocationAndPlace = "一层阅览室";
				break;
			case 2:
				LocationAndPlace = "电子阅览室";
				break;
			case 3:
				LocationAndPlace = "自习室";
				break;
			default:
				break;
			}	
		}
		return LocationAndPlace;
		
	}
}
