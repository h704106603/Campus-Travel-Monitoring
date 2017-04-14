package com.service;

import java.util.Map;

import org.springframework.core.io.Resource;

/**
 * 得到各个出行地的出行指数
 * @author Hangxiao
 *
 */
public interface GetAllLocationScoreService{

    /**
     * 
     * @return 得到各个出行地的出行指数的对应map
     */
    Map<String, Object> ShowScore();

}
