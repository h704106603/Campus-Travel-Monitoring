package com.service;

import java.util.Map;

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
    public Map<String,Object> Bar();
    
    /**
     * 返回剧场的所有人数分布情况
     * @return
     */
    public Map<String, Object> Pie();
}
