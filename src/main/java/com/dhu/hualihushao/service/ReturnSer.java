package com.dhu.hualihushao.service;

import com.dhu.hualihushao.dao.ReturnDao;
import com.dhu.hualihushao.entity.Buy;
import com.dhu.hualihushao.entity.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ReturnSer {

    @Resource
    @Autowired
    private ReturnDao returnDao;

    public List<Return> getAll(Return ret){
        try{
            System.out.println("Service: ReturnSer -> getAll()");
            return returnDao.getAll(ret);
        }catch (Exception e){
            return null;
        }
    }

    public Return getOne(Return ret){
        try{
            System.out.println("Service: ReturnSer -> getOne()");
            return returnDao.getOne(ret);
        }catch (Exception e){
            return null;
        }
    }

    public boolean add(Return ret){
        try{
            Date date = new Date();
            System.out.println(date);
            Timestamp timestamp = new Timestamp(date.getTime());
            System.out.println(timestamp);
            ret.setReturn_time(date);
            System.out.println(ret);
            returnDao.add(ret);
            System.out.println("return is inserted");
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
