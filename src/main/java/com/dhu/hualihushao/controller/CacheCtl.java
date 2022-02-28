package com.dhu.hualihushao.controller;

import com.dhu.hualihushao.entity.Cache;
import com.dhu.hualihushao.entity.PageQueryBean;
import com.dhu.hualihushao.entity.Repository;
import com.dhu.hualihushao.service.CacheSer;
import com.dhu.hualihushao.service.RepositorySer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cache")
public class CacheCtl {

    @Resource
    private CacheSer cacheSer;
    @Resource
    private RepositorySer repositorySer;





    @RequestMapping("getTotal")
    public Integer getTotal(Cache cache){
        System.out.println(cache);
        List<Cache> list = cacheSer.getAll(cache);
        System.out.println("Now is total!!!");
        //System.out.println(list);
        Integer ans=0;
        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Cache c = (Cache)list.get(i);
                ans+= c.getCache_numbers();
            }
        }
        System.out.println(ans);
        return  ans;
    }

    @RequestMapping("add")
    public Map add(Cache cache){
        Map map = new HashMap<String,Object>();
        System.out.println(cache);       //调试 ：查看新添加的cache信息
        /*判断to仓库是否会爆仓*/
        Integer repository_id = cache.getRepository_id();
        Integer cache_numbers = cache.getCache_numbers();
        Integer repository_capacity = repositorySer.getCapacityById(repository_id);
        Integer cache_num = cacheSer.getSumById(repository_id);
        if(cache_num+cache_numbers>repository_capacity||cache_numbers<=0){
            System.out.println("The repository "+repository_capacity+" is full!");
            map.put("state",2);
            return map;
        }
        /*爆仓检查结束*/
        if(cacheSer.add(cache)){
            map.put("state",1);
        }else {
            map.put("state",0);
        }
        return  map;
    }

    @RequestMapping("updateNumbers")
    public Map updateNumbers(Cache cache){
        Map map = new HashMap<String,Object>();
        System.out.println("即将修改的信息为"+cache);
        if(cache.getCache_numbers()>= 0 && cacheSer.updateNumbers(cache)){
            map.put("state",1);
        }else{
            map.put("state",0);
        }
        return map;
    }

    @RequestMapping("getList")
    public PageQueryBean getList(Cache cache){
        PageQueryBean pageQueryBean = new PageQueryBean();
        System.out.println(cache);
        List<Cache> list = cacheSer.getAll(cache);
        System.out.println(list);
        if(list!=null&&list.size()>0){
            pageQueryBean.setTotalRows(list.size());
            pageQueryBean.setItems(list);
        }else{
            pageQueryBean.setItems(null);
            pageQueryBean.setTotalRows(0);
        }
        //System.out.println(pageQueryBean);
        return pageQueryBean;
    }

    @RequestMapping("writeModifyId")
    public Map writeModifyId(Integer id, HttpSession session){
        Map map = new HashMap<String,Object>();
        session.setAttribute("modifyId",id);
        System.out.println(id);
        return  map;
    }

    @RequestMapping("review")
    public Map review(Integer id,HttpSession session){
        Map map = new HashMap<String,Object>();
        Integer modifyId = (int)session.getAttribute("modifyId");
        Cache cache = cacheSer.getOne(new Cache(modifyId));
        if(cache!=null){
            System.out.println(cache);
            map.put("cache",cache);
            map.put("state",1);
        }else {
            map.put("state",0);
        }
        return  map;
    }
}
