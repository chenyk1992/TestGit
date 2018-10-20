package com.tuyou.demo;

import com.tuyou.demo.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: testRedis
 * @description: Redis测试
 * @author: Administrator
 * @create: 2018-10-14 01:10
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    public static Logger logger= LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);
    @Test
    public void contextLoads() {
    }
    @Autowired
    RedisDao redisDao;
    @Test
    public void testRedis(){
        redisDao.setKey("name","forezp");
        redisDao.setKey("age","11");
        redisDao.setListKey("shoplist","a");
        redisDao.setListKey("shoplist","b");
        redisDao.setListKey("shoplist","c");
        logger.debug(redisDao.getValue("name"));
        logger.debug(redisDao.getValue("age"));
        logger.debug(redisDao.getListValue("shoplist").toString());
        logger.debug(redisDao.getListSize("shoplist").toString());
    }
}
