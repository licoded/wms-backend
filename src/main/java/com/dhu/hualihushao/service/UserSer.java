package com.dhu.hualihushao.service;

import com.dhu.hualihushao.dao.UserDao;
import com.dhu.hualihushao.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserSer {

    @Resource
    private UserDao userDao;

    public  boolean changePwd(User user){
        try{
            userDao.updatePwd(user);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    public boolean updateMoney(User user){
        try{
            System.out.println(user);
            userDao.updateMoney(user);
            System.out.println("have del");
            return  true;
        }catch (Exception e){
            return  false;
        }
    }
    public boolean add(User user){
        try {
            if(userDao.getOne(user)!=null){
                return  false;
            }
            System.out.println(user);
            userDao.add(user);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    public boolean delete(User user){
        try{
            userDao.delete(user);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    public List<User> getAll(User user){
        try{
            return userDao.getAll(user);
        }catch (Exception e){
            return  null;
        }
    }

    public User getOne(User user){
        try {
            return  userDao.getOne(user);
        }catch (Exception e){
            return  null;
        }
    }

    public boolean update(User user){
        try{
            System.out.println(user);
            userDao.update(user);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    public List<User> getAllByRepositoryId(Integer repository_id){
        try{
            return userDao.getAllByRepositoryId(repository_id);
        }catch (Exception e){
            return null;
        }
    }
}
