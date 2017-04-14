package com.service;

/**
 * 
 * @author Hangxiao
 * 公共浴室Echarts图数据接口
 */
public interface EchartsBathroomService {

    /**
     * 
     * @param id 第几浴室
     * @return 前台展示的Echarts图形字符串
     */
	String BathroomBar(String id);
}
