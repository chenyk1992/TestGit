package com.tuyou.demo.controller;

import com.tuyou.demo.dao.RedisDao;
import com.tuyou.demo.pojo.User;
import com.tuyou.demo.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: UserController
 * @description: T0D0
 * @author: Administrator
 * @create: 2018-10-13 23:46
 **/
@Controller
public class UserController {
    @Resource(name = "userImplServices")
    private UserServices userImplServices;
    @Resource(name = "redisDao")
    private RedisDao redisDao;
    @GetMapping("/login")
    public String queryUsers(Model model){
        List<User> list=userImplServices.queryUsers();
        model.addAttribute("list", list);
        model.addAttribute("myname", "张三");
        return "login";
    }
    @GetMapping("/index")
    public String toIndex(Model model){
        redisDao.setKey("name","forezp");
        redisDao.setKey("age","11");
        model.addAttribute("age", redisDao.getValue("age"));
        model.addAttribute("name", redisDao.getValue("name"));
        return "index";
    }
}
