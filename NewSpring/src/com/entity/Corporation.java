package com.entity;

/**
 * 社团活动实体类
 * @author Hangxiao
 *
 */
public class Corporation{

    /**
     * 活动名称
     */
    private String name;
    
    /**
     * 举办时间
     */
    private String time;
    
    /**
     * 活动介绍
     */
    private String introduction;
    
    /**
     * 点赞数
     */
    private int thumbsup;
    
    /**
     * 图片地址
     */
    private String pictureUrl;

    public Corporation(String name, String time, String introduction, int thumbsup, String pictureUrl){
        super();
        this.name = name;
        this.time = time;
        this.introduction = introduction;
        this.thumbsup = thumbsup;
        this.pictureUrl = pictureUrl;
    }

    
    public String getName(){
        return name;
    }

    
    public void setName(String name){
        this.name = name;
    }

    
    public String getTime(){
        return time;
    }

    
    public void setTime(String time){
        this.time = time;
    }

    
    public String getIntroduction(){
        return introduction;
    }

    
    public void setIntroduction(String introduction){
        this.introduction = introduction;
    }

    
    public int getThumbsup(){
        return thumbsup;
    }

    
    public void setThumbsup(int thumbsup){
        this.thumbsup = thumbsup;
    }

    
    public String getPictureUrl(){
        return pictureUrl;
    }

    
    public void setPictureUrl(String pictureUrl){
        this.pictureUrl = pictureUrl;
    }
    
    
}
