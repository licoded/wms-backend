package com.dhu.hualihushao.controller;

import com.dhu.hualihushao.entity.Dispatch;
import com.dhu.hualihushao.entity.PageQueryBean;
import com.dhu.hualihushao.entity.Search;
import com.dhu.hualihushao.service.CacheSer;
import com.dhu.hualihushao.service.DispatchSer;
import com.dhu.hualihushao.service.RepositorySer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dispatch")
public class DispatchCtl {
    @Resource
    private DispatchSer dispatchSer;
    @Resource
    private RepositorySer repositorySer;
    @Resource
    private CacheSer cacheSer;

    @RequestMapping("add")
    public Map add(Dispatch dispatch){
        Map map = new HashMap<String,Object>();
        /*判断to仓库是否会爆仓*/
        Integer to_repository_id = dispatch.getRepository_id_1();
        Integer dispatch_num = dispatch.getDispatch_num();
        Integer repository_capacity = repositorySer.getCapacityById(to_repository_id);
        Integer cache_num = cacheSer.getSumById(to_repository_id);
        if(cache_num+dispatch_num>repository_capacity){
            System.out.println("The repository "+repository_capacity+" is full!");
            map.put("state",2);
            return map;
        }
        /*爆仓检查结束*/

        System.out.println(dispatch);
        if(dispatchSer.add(dispatch)){
            map.put("state",1);
        }else{
            map.put("state",0);
        }
        return map;
    }

    @RequestMapping("getList")
    public PageQueryBean getList(Dispatch dispatch){
        PageQueryBean pageQueryBean = new PageQueryBean();
        System.out.println(dispatch);
        List<Dispatch> list = dispatchSer.getAll(dispatch);
        if(list!=null && list.size()>0){
            pageQueryBean.setTotalRows(list.size());
            pageQueryBean.setItems(list);
        }else {
            pageQueryBean.setItems(null);
            pageQueryBean.setTotalRows(0);
        }
        return  pageQueryBean;
    }
    @RequestMapping("getListIn")
    public PageQueryBean getListIn(Search dispatch){
        PageQueryBean pageQueryBean = new PageQueryBean();
        System.out.println(dispatch);
        List<Dispatch> list = dispatchSer.getIn(dispatch);
        if(list!=null && list.size()>0){
            pageQueryBean.setTotalRows(list.size());
            pageQueryBean.setItems(list);
        }else {
            pageQueryBean.setItems(null);
            pageQueryBean.setTotalRows(0);
        }
        return  pageQueryBean;
    }

    @RequestMapping("getListOut")
    public PageQueryBean getListOut(Search dispatch){
        PageQueryBean pageQueryBean = new PageQueryBean();
        System.out.println(dispatch);
        List<Dispatch> list = dispatchSer.getOut(dispatch);
        if(list!=null && list.size()>0){
            pageQueryBean.setTotalRows(list.size());
            pageQueryBean.setItems(list);
        }else {
            pageQueryBean.setItems(null);
            pageQueryBean.setTotalRows(0);
        }
        return  pageQueryBean;
    }
}
