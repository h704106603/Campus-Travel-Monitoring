package com.service;

import java.util.Map;

/**
 * 
 * @author Hang
 * 公共浴室数据监控接口
 *
 */
public interface BathroomService {

    /**
     * 返回公共浴室的所有人数明细情况
     * @return
     */
	public Map<String,Object> Bar();
	
	/**
     * 返回公共浴室的所有人数分布情况
     * @return
     */
	public Map<String, Object> Pie();
}
