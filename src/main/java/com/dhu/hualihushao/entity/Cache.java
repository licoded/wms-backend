package com.dhu.hualihushao.entity;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cache {
    private Integer cache_id;
    private Integer repository_id;
    private Integer material_id;
    private  Date cache_time;
//    private java.sql.Date cache_time;
//    private Timestamp cache_time;
    private String cache_timeStr;
    private Integer cache_numbers;

    //关联 material
    private Material material;
    private Repository repository;

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    //起始时间 支持搜索的物品名
    private String start;
    private String end;
    private String m_name;
    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }



    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Cache(){

    }

    public Cache(Integer id){
        this.cache_id = id;
    }

    public Integer getCache_id() {
        return cache_id;
    }

    public void setCache_id(Integer cache_id) {
        this.cache_id = cache_id;
    }

    public Integer getRepository_id() {
        return repository_id;
    }

    public void setRepository_id(Integer repository_id) {
        this.repository_id = repository_id;
    }

    public Integer getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Integer material_id) {
        this.material_id = material_id;
    }

    public String getCache_timeStr(){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
            return sdf.format(this.getCache_time());
    }
    public void setCache_timeStr(String cache_timeStr) {
        this.cache_timeStr = cache_timeStr;
    }

    public Date getCache_time() {
        return cache_time;
    }

    public void setCache_time(Date cache_time) {
        this.cache_time = cache_time;
    }

    public Integer getCache_numbers() {
        return cache_numbers;
    }

    public void setCache_numbers(Integer cache_numbers) {
        this.cache_numbers = cache_numbers;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

//    @Override
//    public String toString() {
//        return "Cache{" +
//                "cache_id=" + cache_id +
//                ", repository_id=" + repository_id +
//                ", material_id=" + material_id +
//                ", cache_time=" + cache_time +
//                ", cache_numbers=" + cache_numbers +
//                '}';
//    }


    @Override
    public String toString() {
        return "Cache{" +
                "cache_id=" + cache_id +
                ", repository_id=" + repository_id +
                ", material_id=" + material_id +
                ", cache_time=" + cache_time +
                ", cache_timeStr='" + cache_timeStr + '\'' +
                ", cache_numbers=" + cache_numbers +
                ", material=" + material +
                ", repository=" + repository +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", m_name='" + m_name + '\'' +
                '}';
    }
}
