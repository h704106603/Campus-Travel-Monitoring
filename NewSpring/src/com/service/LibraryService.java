package com.service;

import java.util.Map;

/**
 * 
 * @author Hang
 * 图书馆数据监控接口
 *
 */
public interface LibraryService{

    /**
     * 返回图书馆的所有人数明细情况
     * @return
     */
    public Map<String,Object> Bar();
    
    /**
     * 返回图书馆的所有人数分布情况
     * @return
     */
    public Map<String, Object> Pie();
}
