package com.dhu.hualihushao.service;

import com.dhu.hualihushao.dao.BuyDao;
import com.dhu.hualihushao.entity.Buy;
import com.dhu.hualihushao.entity.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class BuySer {
    @Resource
    @Autowired
    private BuyDao buyDao;

    public List<Buy> getAll(Buy buy){
        try{
            System.out.println("Service: BuySer -> getAll()");
            return buyDao.getAll(buy);
        }catch (Exception e){
            return null;
        }
    }

    public Buy getOne(Buy buy){
        try{
            System.out.println("Service: BuySer -> getOne()");
            return buyDao.getOne(buy);
        }catch (Exception e){
            return null;
        }
    }

    public boolean add(Buy buy){
        try{
            Date date = new Date();
            System.out.println(date);
            Timestamp timestamp = new Timestamp(date.getTime());
            System.out.println(timestamp);
            buy.setBuy_time(date);
            System.out.println(buy);
            buyDao.add(buy);
            System.out.println("buy is inserted");
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
