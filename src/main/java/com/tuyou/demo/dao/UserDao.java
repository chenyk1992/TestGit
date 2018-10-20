package com.tuyou.demo.dao;

import com.tuyou.demo.pojo.User;


import java.util.List;

public interface UserDao {
    /**
     * 遍历用户
     * @return List<User>
     */
    List<User> queryUsers();
    /**
     * 添加用户
     * @return int
     */
    int addUser();
}
