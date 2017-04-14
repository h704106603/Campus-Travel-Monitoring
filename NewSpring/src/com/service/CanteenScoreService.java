package com.service;

import java.util.Map;

/**
 * 
 * @author Hang
 * 食堂数据监控接口
 *
 */
public interface CanteenScoreService{

    /**
     * 返回食堂的所有人数明细情况
     * @return
     */
    public Map<String,Object> Bar();
    
    /**
     * 返回食堂的所有人数分布情况
     * @return
     */
    public Map<String, Object> Pie();
    
}
