package com.dhu.hualihushao.service;

import com.dhu.hualihushao.dao.CacheDao;
import com.dhu.hualihushao.entity.Cache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CacheSer {
    @Resource
    private CacheDao cacheDao;

    public boolean updateNumbers(Cache cache){
        try {
            cacheDao.updateNumbers(cache);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    public List<Cache> getAll(Cache cache){
        try{
            System.out.println("cacheser have got a cache"+cache);
            return cacheDao.getAll(cache);
        }catch (Exception e){
           return  null;
        }
    }

    public Cache getOne(Cache cache){
        try{
            return cacheDao.getOne(cache);
        }catch (Exception e){
            return  null;
        }
    }

    public boolean add(Cache cache){
        try{
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String string = sdf.format(new Date());
//            Date date = sdf.parse(string);
//            System.out.println(date);
//            cache.setCache_time(date);
//            System.out.println(cache);
            Date data = new Date();
            System.out.println(data);
            Timestamp timestamp = new Timestamp(data.getTime());
            System.out.println(timestamp);
//            String string = cache.getCache_timeStr();
            cache.setCache_time(data);
//            cache.setCache_time(cache.getCache_timeStr().par);
            System.out.println(cache);
            cacheDao.add(cache);
            System.out.println("cacahe is inserted");
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    public Integer getSumById(Integer repository_id){
        try{
            Cache cache = new Cache();
            cache.setRepository_id(repository_id);
            List<Cache> list = this.getAll(cache);
            Integer sum = 0;
            for(int i=0;i<list.size();i++){
                sum+=list.get(i).getCache_numbers();
            }
            return sum;
        }catch (Exception e){
            return -1;
        }
    }
}
