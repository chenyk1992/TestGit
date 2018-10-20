package com.tuyou.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: DBConfig
 * @description: datasource配置
 * @author: Administrator
 * @create: 2018-10-13 22:32
 **/
@Configuration
public class DBConfig {
    @Bean
    public DruidDataSource  druidDataSource(){
        //druid数据源配置
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mytest?characterEncoding=utf8" +
                "&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //初始连接数(默认值0)
        dataSource.setInitialSize(8);
        //最小连接数(默认值0)
        dataSource.setMinIdle(8);
        //最大连接数(默认值8,注意"maxIdle"这个属性已经弃用)
        dataSource.setMaxActive(30);
        return dataSource;
    }
}
