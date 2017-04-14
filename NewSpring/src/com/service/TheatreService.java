package com.service;

import java.util.List;
import java.util.Map;

import com.entity.TheatreShow;

/**
 * 
 * @author Hang
 * 剧场数据监控接口
 *
 */
public interface TheatreService{

    /**
     * 返回剧场的所有人数明细情况
     * @return
     */
    Map<String,Object> Bar();
    
    /**
     * 返回剧场的所有人数分布情况
     * @return
     */
    Map<String, Object> Pie();
    
    /**
     * 查找所有剧场秀信息
     * @return
     */
    List<TheatreShow> findTheatreShowDetails();
}
