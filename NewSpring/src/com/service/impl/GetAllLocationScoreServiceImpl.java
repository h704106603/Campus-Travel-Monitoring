package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.service.GetAllLocationScoreService;
import com.util.ResourceUtils;


public class GetAllLocationScoreServiceImpl implements GetAllLocationScoreService{

    @javax.annotation.Resource(name="LocalOracleDao")
    private com.dao.LocalOracleDao LocalOracleDao;
    
    @Value("classpath:config/PlaceScore/libraryScore.sql")
    private Resource LibraryScoreSql;
    @Value("classpath:config/PlaceScore/bathroomScore.sql")
    private Resource BathroomScoreSql;
    @Value("classpath:config/PlaceScore/canteenScore.sql")
    private Resource CanteenScoreSql;
    @Value("classpath:config/PlaceScore/theatreScore.sql")
    private Resource TheatreScoreSql;
    @Value("classpath:config/PlaceScore/classroomScore.sql")
    private Resource ClassroomScoreSql;
    
    
    public Map<String, Object> ShowScore(){
        
    	Map<String, Object> result=new HashMap<String, Object>();
    	String libraryScore = GetAllLocationScore(LibraryScoreSql);
    	String bathroomScore = GetAllLocationScore(BathroomScoreSql);
    	String canteenScore = GetAllLocationScore(CanteenScoreSql);
    	String theatreScore = GetAllLocationScore(TheatreScoreSql);
    	String classroomScore = GetAllLocationScore(ClassroomScoreSql);
    	result.put("libraryScore", libraryScore);
    	result.put("bathroomScore", bathroomScore);
    	result.put("canteenScore", canteenScore);
    	result.put("theatreScore", theatreScore);
    	result.put("classroomScore", classroomScore);
        return result;
    }
    
    public String GetAllLocationScore(Resource Rsql){
        
    	String value = new String();
        try {
            String sql = ResourceUtils.getStringFromResource(Rsql);
            List<Object[]> list = LocalOracleDao.getResultForSql(sql);
            if(list!=null && list.size()>0){
                for (Object[] objData : list) {
                    String name = objData[0]==null ? "" : String.valueOf(objData[0]);
                    value = objData[1]==null ? "0" : String.valueOf(objData[1]); //浠婃棩
                   
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
       //做截取，防止小数点
       if(value.contains(".")){
    	   value = value.substring(0, value.indexOf("."));
       }
       return value;
    }

}
