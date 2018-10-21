package com.tuyou.demo.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;


/**
 * @className: AuthenticationTest
 * @description: 认证
 * @author: Administrator
 * @create: 2018-10-20 19:07
 **/
public class AuthenticationTest {
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("Mark","123456","admin","user");
    }
    @Test
    public void testAuthentication(){
        //1.构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);
        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken taken = new UsernamePasswordToken("Mark", "123456");
        subject.login(taken);
        System.out.println("是否认证："+subject.isAuthenticated());
        subject.checkRole("admin");//判断单个权限
        subject.checkRoles("admin","user");//判断多个权限
        subject.logout();
        System.out.println("是否认证："+subject.isAuthenticated());
    }
}
