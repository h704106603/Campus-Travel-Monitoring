package com.entity;

import java.util.Map;

public class StudentLocation{

    private String name;
    
    private String grade;//这里指班级
   
    private String locationMap ;

    public StudentLocation(String name, String grade, String locationMap){
        super();
        this.name = name;
        this.grade = grade;
        this.locationMap = locationMap;
    }

    
    public String getName(){
        return name;
    }

    
    public void setName(String name){
        this.name = name;
    }

    
    public String getGrade(){
        return grade;
    }

    
    public void setGrade(String grade){
        this.grade = grade;
    }

    
    public String getLocationMap(){
        return locationMap;
    }

    
    public void setLocationMap(String locationMap){
        this.locationMap = locationMap;
    }
    
    
}
