package com.service;

/**
 * 
 * @author Hangxiao
 * 图书馆Echarts图数据接口
 */
public interface EchartsLibraryService{

    /**
     * 
     * @param id 图书馆的第几层
     * @return 前台展示的Echarts图形字符串
     */
    String LibraryBar(String id);
}
