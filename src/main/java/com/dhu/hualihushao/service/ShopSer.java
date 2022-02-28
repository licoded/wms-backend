package com.dhu.hualihushao.service;

import com.dhu.hualihushao.dao.ShopDao;
import com.dhu.hualihushao.entity.Search;
import com.dhu.hualihushao.entity.Shop;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ShopSer {
    @Resource
    private ShopDao shopDao;

    public List<Shop> getAll(Search search){
        try{
            System.out.println("shops have got a shop"+search);
            return shopDao.getAll(search);
        }catch (Exception e){
            return  null;
        }
    }

    public boolean add(Shop shop){
        try{
            Date data = new Date();
            System.out.println(data);

            //毫无意义的输出一个我看的懂的时间，明明上面已经有时间了
            Timestamp timestamp = new Timestamp(data.getTime());
            System.out.println(timestamp);

            shop.setShop_time(data);
            System.out.println(shop);
            System.out.println("shop is inserted");
            shopDao.add(shop);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
