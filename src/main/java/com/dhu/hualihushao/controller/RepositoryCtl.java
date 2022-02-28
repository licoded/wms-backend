package com.dhu.hualihushao.controller;

import com.dhu.hualihushao.dao.RepositoryDao;
import com.dhu.hualihushao.entity.*;
import com.dhu.hualihushao.service.CacheSer;
import com.dhu.hualihushao.service.RepositorySer;
import com.dhu.hualihushao.service.UserSer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("repository")
public class RepositoryCtl {
    @Resource
    private RepositorySer repositorySer;

    @RequestMapping("add")
    public Map add(Repository repository){
        System.out.println(repository);
        Map map = new HashMap<String,Object>();
        if(repositorySer.add(repository)){
            map.put("state",1);
        }else{
            map.put("state",0);
        }
        return map;
    }

    @RequestMapping("delete")
    public Map delete(Integer repository_id){
        Map map = new HashMap<String,Object>();
        map.put("state",repositorySer.deleteById(repository_id));
        //1为成功，0为失败
        return map;
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
        Repository repository =repositorySer.getOneById(modifyId);
        if(repository!=null){
            System.out.println(repository);
            map.put("repository",repository);
            map.put("state",1);
        }else {
            map.put("state",0);
        }
        return  map;
    }
    @RequestMapping("getList")
    public PageQueryBean getList(){
        PageQueryBean pageQueryBean = new PageQueryBean();
        System.out.println("I am in CTRL to get all repository");
        List<Repository> list = repositorySer.getAll();
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

    @RequestMapping("update")
    public  Map update(Repository repository){
        Map map = new HashMap<String,Object>();
        if(repositorySer.update(repository)){
            map.put("state",1);
        }else{
            map.put("state",0);
        }
        return  map;
    }
}
