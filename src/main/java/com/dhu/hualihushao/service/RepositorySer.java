package com.dhu.hualihushao.service;

import com.dhu.hualihushao.dao.RepositoryDao;
import com.dhu.hualihushao.dao.UserDao;
import com.dhu.hualihushao.entity.Repository;
import com.dhu.hualihushao.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepositorySer {

    @Resource
    private RepositoryDao repositoryDao;

    public Integer getCapacityById(Integer repository_id){
        try{
            return repositoryDao.getOneById(repository_id).getRepository_capacity();
        }catch (Exception e){
            return -1;
        }
    }

    public Repository getOneById(Integer repository_id){
        try{
            System.out.println("The repository_id is " + repository_id);
            return repositoryDao.getOneById(repository_id);
        }catch (Exception e){
            return null;
        }
    }

    public boolean add(Repository repository){
        try{
            System.out.println(repository);
            repositoryDao.add(repository);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean update(Repository repository){
        try {
            System.out.println(repository);
            repositoryDao.update(repository);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    public List<Repository> getAll(){
        try{
            System.out.println("I am getting all repository");
            return repositoryDao.getAll();
        }catch (Exception e){
            return null;
        }
    }

    @Resource
    private UserDao userDao;
    public Integer deleteById(Integer repository_id){
        try{
            System.out.println("The repository_id is " + repository_id);

            List<User> user_list = userDao.getAllByRepositoryId(repository_id);
            Repository repository = this.getOneById(repository_id);

            //修改所有user的外键user_repository
            for(int i=0;i<user_list.size();i++){
                User user = user_list.get(i);
                user.setUser_repository(-1);
                userDao.update(user);
            }

            //删除仓库
            repositoryDao.deleteOneById(repository_id);

            return 1;
        }catch (Exception e){
            return 0;
        }
    }



}
