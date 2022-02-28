package com.dhu.hualihushao.controller;

import com.dhu.hualihushao.entity.PageQueryBean;
import com.dhu.hualihushao.entity.User;
import com.dhu.hualihushao.service.UserSer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@Api(tags = "UserCtl")
public class UserCtl {
    @Resource
    private UserSer userSer;

    @RequestMapping("getSysUser")
    @ApiOperation(value = "获取用户")
    public Map getSysuser(HttpSession session){
        Map map=new HashMap<String,Object>();
        User user=(User)session.getAttribute("sysUser");
//        if(user!=null){
//            map.put("state",1);
//            map.put("sysUser",user);
//        }
        if(user!=null){
            User u = userSer.getOne(new User(user.getUser_id()));
            map.put("state",1);
            map.put("sysUser",u);
            System.out.println(u);
        }
        else {
            map.put("state",0);
        }
        return  map;
    }

    @RequestMapping("changePwd")
    public Map changePwd(User user){
        Map map =new HashMap<String,Object>();
        if(userSer.changePwd(user)){
            map.put("state",1);
        }else {
            map.put("state",0);
        }
        return  map;
    }

//    @RequestMapping("changeMoney")
//    public Map changeMoney(User user){
//        Map map = new HashMap<String,Object>();
//        if(userSer.changeMoney(user)){
//            map.put("state",1);
//        }else{
//            map.put("state",0);
//        }
//        return  map;
//    }

    //传参中user的user_money为改变量
    @RequestMapping("delMoney")
    public  Map delMoney(User user){
        Map map = new HashMap<String,Object>();

        //原有的钱
        double have = userSer.getOne(user).getUser_money();
        double change= user.getUser_money();
        if(change<0||change>have){
            map.put("state",0);
        }else{
            user.setUser_money(have-change);
            userSer.updateMoney(user);
            map.put("state",1);
        }
        return  map;
    }

    @RequestMapping("addMoney")
    public  Map addMoney(User user){
        Map map = new HashMap<String,Object>();
        //原有的钱
        double have = userSer.getOne(user).getUser_money();
        double change= user.getUser_money();
        if(change<0){
            map.put("state",0);
        }else{
            user.setUser_money(have+change);
            userSer.updateMoney(user);
            map.put("state",1);
        }
        return  map;
    }
    @RequestMapping("add")
    public Map add(User user){
        Map map=new HashMap<String,Object>();
        System.out.println(user);
        if(userSer.add(user)){
            map.put("state",1);
        }else{
            map.put("state",0);
        }
        return  map;
    }

    @RequestMapping("getList")
    public PageQueryBean getList(User user){
        PageQueryBean pageQueryBean=new PageQueryBean();
        List<User> list=userSer.getAll(user);
        if(list!=null&&list.size()>0){
            pageQueryBean.setTotalRows(list.size());
            pageQueryBean.setItems(list);
        }else {
            pageQueryBean.setItems(null);
            pageQueryBean.setTotalRows(0);
        }
        return pageQueryBean;
    }

    @RequestMapping("delete")
    public Map delete(User user){
        Map map= new HashMap<String,Object>();
      //System.out.println(user.getUser_name()+user.getUser_id());
        userSer.delete(user);
        return  map;
    }

    @RequestMapping("writeModifyId")
    public Map writeModifyId(Integer id,HttpSession session){
        Map map = new HashMap<String,Object>();
        session.setAttribute("modifyId",id);
        System.out.println(id);
        return  map;
    }

    @RequestMapping("review")
    public Map review(HttpSession session){
        Map map = new HashMap<String,Object>();
        Integer modifyId = (int)session.getAttribute("modifyId");

        User u = userSer.getOne(new User(modifyId));
        if(u!=null){
            System.out.println(u.getUser_name());
            map.put("user",u);
            map.put("state",1);
            System.out.println(map.get("user"));
        }else {
            map.put("state",0);
        }
        return map;
    }

    @RequestMapping("modify")
    public Map modify(User user){
        Map map = new HashMap<String,Object>();
        if(userSer.update(user))
            map.put("state",1);
        else
            map.put("state",0);
        return map;
    }


}
