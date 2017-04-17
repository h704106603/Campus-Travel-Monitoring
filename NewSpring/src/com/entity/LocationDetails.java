package com.entity;

import java.util.Map;

public class LocationDetails{

	//好友姓名
    private String name;
    
    //好友班级
    private String grade;//这里指班级
   
    //出没时间
    private String time ;
    
    //出没地详情，如进入XX区域
    private String details;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocationDetails(String name, String grade, String time, String details) {
		super();
		this.name = name;
		this.grade = grade;
		this.time = time;
		this.details = details;
	}

	public LocationDetails() {
		super();
	}

	@Override
	public String toString() {
		return "StudentLocationDetails [name=" + name + ", grade=" + grade + ", time=" + time + ", details=" + details
				+ "]";
	}
    
    
    

    
    
    
}
