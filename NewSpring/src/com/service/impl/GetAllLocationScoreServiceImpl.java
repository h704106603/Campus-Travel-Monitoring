package com.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.service.GetAllLocationScoreService;


public class GetAllLocationScoreServiceImpl implements GetAllLocationScoreService{

    @javax.annotation.Resource(name="LocalOracleDao")
    private com.dao.LocalOracleDao LocalOracleDao;
    
    @Value("classpath:config/Bathroom/allLibrary.sql")
    private Resource allLibrarySql;
    
    public Map<String, Object> ShowScore(){
        
        GetAllLocationScore(allLibrarySql);
    }
    
    @Override
    public Map<String, Object> GetAllLocationScore(Resource Rsql){
        
        Map<String, Object> result=new HashMap<String, Object>();
//        try {
//            String sql = ResourceUtils.getStringFromResource(Rsql);
//            //sql = sql.replaceAll("\\{id\\}", id);
//            List<Object[]> list = LocalOracleDao.getResultForSql(sql);
//            if(list!=null && list.size()>0){
//                for (Object[] objData : list) {
//                    String name = objData[0]==null ? "" : String.valueOf(objData[0]);
//                    String value = objData[1]==null ? "0" : String.valueOf(objData[1]); //今日
//                    result.put(name, value);
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        result.put("LibraryScore","68");
        result.put("BathroomScore","780");
        result.put("CanteenScore","80");
        result.put("TheatreScore","90");
        result.put("ClassroomScore","80");
        return result;
    }

}
