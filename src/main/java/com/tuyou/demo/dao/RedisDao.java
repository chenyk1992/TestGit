package com.tuyou.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @className: RedisDao
 * @description: Redis
 * @author: Administrator
 * @create: 2018-10-14 01:56
 **/
@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;
    /**
     * 赋值string
     * @param key
     * @param value
     */
    public  void setKey(String key,String value){
        ValueOperations<String, String> ops = template.opsForValue();
        //ops.set(key,value,1, TimeUnit.MINUTES);//1分钟过期
        ops.set(key, value);
    }
    /**
     * 获值string
     * @param key
     * @return string
     */
    public String getValue(String key){
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }
    /**
     * 赋值list
     * @param key
     * @param value
     */
    public  void setListKey(String key,String value){
        ListOperations<String, String> ops = template.opsForList();
        ops.leftPush(key, value);
    }
    /**
     * 获值list
     * @param key
     * @return List<String>
     */
    public List<String> getListValue(String key){
        ListOperations<String, String> ops = this.template.opsForList();
        return ((ListOperations) ops).range(key, 0, -1);
    }
    /**
     * 获得list长度
     * @param key
     * @return lang
     */
    public Long getListSize(String key){
        ListOperations<String,String> ops=template.opsForList();
        return ops.size(key);
    }
}
