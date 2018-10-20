package com.tuyou.demo.services.impl;

import com.tuyou.demo.dao.UserDao;
import com.tuyou.demo.pojo.User;
import com.tuyou.demo.services.UserServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: UserImplServices
 * @description: UserServices实现类
 * @author: Administrator
 * @create: 2018-10-13 23:41
 **/
@Service
public class UserImplServices implements UserServices {
    @Resource
    private UserDao userDao;
    /**
     * 遍历用户
     *
     * @return List<User>
     */
    @Override
    public List<User> queryUsers() {
        return userDao.queryUsers();
    }

    /**
     * 添加用户
     *
     * @return boolean
     */
    @Override
    public boolean addUser() {
        boolean f=false;
        if(userDao.addUser()>0){
            f=true;
        }
        return f;
    }
}
