package com.dhu.hualihushao.entity;

public class User {
    private Integer user_id;
    private String user_name;
    private String user_password;
    private Integer user_repository;
    private Integer user_chmod;
    private double user_money;

    public User(){

    }
    public User(Integer id){
        this.user_id=id;
    }

    public User(String user_name){
        this.user_name=user_name;
    }
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_repository() {
        return user_repository;
    }

    public void setUser_repository(Integer user_repository) {
        this.user_repository = user_repository;
    }

    public Integer getUser_chmod() {
        return user_chmod;
    }

    public void setUser_chmod(Integer user_chmod) {
        this.user_chmod = user_chmod;
    }

    public double getUser_money() {
        return user_money;
    }

    public void setUser_money(double user_money) {
        this.user_money = user_money;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_repository=" + user_repository +
                ", user_chmod=" + user_chmod +
                ", user_money=" + user_money +
                '}';
    }
}
