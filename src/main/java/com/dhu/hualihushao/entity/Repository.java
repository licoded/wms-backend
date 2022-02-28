package com.dhu.hualihushao.entity;


public class Repository {
    private Integer repository_id;
    private String  repository_name;
    private Integer repository_capacity;

    public Repository(){

    }
    public  Repository(Integer id){
        this.repository_id=id;
    }

    public Integer getRepository_id() {
        return repository_id;
    }

    public void setRepository_id(Integer repository_id) {
        this.repository_id = repository_id;
    }

    public String getRepository_name() {
        return repository_name;
    }

    public void setRepository_name(String repository_name) {
        this.repository_name = repository_name;
    }

    public Integer getRepository_capacity() {
        return repository_capacity;
    }

    public void setRepository_capacity(Integer repository_capacity) {
        this.repository_capacity = repository_capacity;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "repository_id=" + repository_id +
                ", repository_name='" + repository_name + '\'' +
                ", repository_capacity=" + repository_capacity +
                '}';
    }
}
