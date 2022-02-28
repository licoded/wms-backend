package com.dhu.hualihushao.entity;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Shop {

    //数据库相关内容
    private Integer shop_id;
    private Integer repository_id;
    private Integer material_id;
    private Date shop_time;
    private Integer shop_numbers;
    private Double shop_price;

    //外键依赖
    private Material material;
    private Repository repository;
    private String shop_timeStr;
//    private String start;
//    private String end;
//
//    public String getStart() {
//        return start;
//    }
//
//    public void setStart(String start) {
//        this.start = start;
//    }
//
//    public String getEnd() {
//        return end;
//    }

//    public void setEnd(String end) {
//        this.end = end;
//    }

    public Shop(){

    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
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

    public Date getShop_time() {
        return shop_time;
    }

    public void setShop_timeStr(String shop_timeStr) {
        this.shop_timeStr = shop_timeStr;
    }

    public String getShop_timeStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        return sdf.format(this.getShop_time());
    }

    public void setShop_time(Date shop_time) {
        this.shop_time = shop_time;
    }

    public Integer getShop_numbers() {
        return shop_numbers;
    }

    public void setShop_numbers(Integer shop_numbers) {
        this.shop_numbers = shop_numbers;
    }

    public Double getShop_price() {
        return shop_price;
    }

    public void setShop_price(Double shop_price) {
        this.shop_price = shop_price;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shop_id=" + shop_id +
                ", repository_id=" + repository_id +
                ", material_id=" + material_id +
                ", shop_time=" + shop_time +
                ", shop_numbers=" + shop_numbers +
                ", shop_price=" + shop_price +
                ", material=" + material +
                ", repository=" + repository +
                '}';
    }
}
