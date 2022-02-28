package com.dhu.hualihushao.service;

import com.dhu.hualihushao.dao.UserDao;
import com.dhu.hualihushao.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginSer {
    @Resource
    private UserDao userDao;

    public User login(User user){
         User u=userDao.getOne(user);
         try {
            if(user.getUser_password().equals(u.getUser_password())){
                return u;
             }
             return  null;
         }catch (Exception e){
            return null;
         }
    }
}
