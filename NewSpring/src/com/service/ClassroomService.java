package com.service;

import java.util.Map;

/**
 * 
 * @author Hang
 * 教室数据监控接口
 *
 */
public interface ClassroomService {

	/**
     * 根据教室来查这间教室的近一小时明细情况
     * @param classroom
     * @return
     */
    public Map<String, Object> ClassroomBar(String classroom);
    
    
    /**
     * 根据教学楼查询当前教学楼内所有教室的当前使用人数柱状图
     * @param AcademicBuilding
     * @return
     */
    public Map<String, Object> AcademicBuildingBar();
    
    
    
}
