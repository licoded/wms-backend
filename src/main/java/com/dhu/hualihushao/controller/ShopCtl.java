package com.dhu.hualihushao.controller;

import com.dhu.hualihushao.entity.PageQueryBean;
import com.dhu.hualihushao.entity.Search;
import com.dhu.hualihushao.entity.Shop;
import com.dhu.hualihushao.service.ShopSer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("shop")
public class ShopCtl {
    @Resource
    private ShopSer shopSer;

    @RequestMapping("getList")
    public PageQueryBean getList(Search search){
        PageQueryBean pageQueryBean = new PageQueryBean();
        System.out.println(search);
        List<Shop> list = shopSer.getAll(search);
        System.out.println(list);
        if(list!=null&&list.size()>0){

            pageQueryBean.setTotalRows(list.size());
            pageQueryBean.setItems(list);
        }else{
            pageQueryBean.setItems(null);
            pageQueryBean.setTotalRows(0);
        }
        System.out.println(pageQueryBean);
        return pageQueryBean;
    }

    @RequestMapping("getTotal")
    public Double getTotal(Search search){
        List<Shop> list = shopSer.getAll(search);
        System.out.println("ShopCtl -> getTotal -> list: "+list);

        double tmp = 0;
        if(list!=null&&list.size()>0){
            for (int i=0; i<list.size(); i++){
                Shop shop1 = (Shop)list.get(i);
                tmp += shop1.getShop_numbers() * shop1.getShop_price();
            }
        }else{ }
        System.out.println(tmp);
        return tmp;
    }

    @RequestMapping("getProfit")
    public Double getProfit(Search search){
        List<Shop> list = shopSer.getAll(search);
        System.out.println("ShopCtl -> getProfit -> list: "+list);

        double tmp = 0;
        if(list!=null&&list.size()>0){
            for (int i=0; i<list.size(); i++){
                Shop shop1 = (Shop)list.get(i);
                tmp += shop1.getShop_numbers() * (shop1.getShop_price()-shop1.getMaterial().getMaterial_price());
            }
        }else{ }
        System.out.println(tmp);
        return tmp;
    }

    @RequestMapping("add")
    public Map add(Shop shop){
        Map map = new HashMap<String,Object>();
        System.out.println(shop);       //调试 ：查看新添加的cache信息
        if(shopSer.add(shop)){
            map.put("state",1);
        }else {
            map.put("state",0);
        }
        return  map;
    }

}
