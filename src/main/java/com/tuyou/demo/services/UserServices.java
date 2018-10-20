package com.tuyou.demo.services;

import com.tuyou.demo.pojo.User;

import java.util.List;

public interface UserServices {
    /**
     * 遍历用户
     * @return List<User>
     */
    List<User> queryUsers();
    /**
     * 添加用户
     * @return boolean
     */
    boolean addUser();
}
