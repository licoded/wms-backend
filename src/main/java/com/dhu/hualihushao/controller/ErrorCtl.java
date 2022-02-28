package com.dhu.hualihushao.controller;


import com.dhu.hualihushao.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("error")
public class ErrorCtl {
    @Resource
    private RepositorySer repositorySer;

    @Resource
    private CacheSer cacheSer;

    @RequestMapping("isFull")
    public Integer isFull(Integer repository_id){
        if(repository_id==null){
            System.out.println("。。。。。。");
            return 1;
        }
        Integer num_repository = repositorySer.getCapacityById(repository_id);
        Integer num_cache = cacheSer.getSumById(repository_id);

        System.out.println("repository_num is "+num_repository);
        System.out.println("cache_num is "+num_cache);

        //出错
        if(num_cache==-1||num_repository==-1){
            return -1;
        }

        //黄色预警
        if(num_cache*10<=num_repository*2){
            return 2;
        }

        //红色预警
        if(num_cache*10>=num_repository*8){
            return 3;
        }
        return 1;
    }

    @RequestMapping("capacity")
    public Integer capacity(Integer repository_id){
        if(repository_id==null){
            System.out.println("。。。。。。");
            return null;
        }
        Integer num_repository = repositorySer.getCapacityById(repository_id);
        System.out.println("repository_num is "+num_repository);
        return num_repository;
    }
}
