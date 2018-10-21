package com.tuyou.demo.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.catalina.realm.JDBCRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @className: JDBCRealmTest
 * @description: JDBCRealmTest类
 * @author: Administrator
 * @create: 2018-10-21 21:15
 **/
public class JDBCRealmTest {
    DruidDataSource dataSource = new DruidDataSource();
    {
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mytest?characterEncoding=utf8" +
                "&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");}
    @Test
    public void testAuthentication(){
        JdbcRealm jdbcRealm=new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);
        /*可通过这里查询自定义表的SQL语句
        String sql = "select password from users where username = ?";
        jdbcRealm.setAuthenticationQuery(sql);
        String roleSql="select role_name from user_roles where username = ?";
        jdbcRealm.setUserRolesQuery(roleSql);
        */
        //创建securityManager对象
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        //主体提交认证环境
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken taken = new UsernamePasswordToken("Mark", "123456");
        subject.login(taken);
        subject.checkRole("admin");
        subject.checkRoles("admin","user");
        subject.checkPermission("user:select");
    }
}
