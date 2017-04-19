package com.service;

import java.util.List;

/**
 * Echarts柱状图根据教室查数据
 * @author Hangxiao
 *
 */
public interface EchartsClassroomService{

    /**
     * 
     * @param classroom 教室号
     * @return 前台展示的Echarts图形字符串
     */
    String ClassroomBar(String classroom);
    
    
    List<String> findClassroomId();
}
