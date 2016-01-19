package com.myapp.app.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.app.dao.IRedisDAO;
import com.myapp.app.entity.User;
@Repository
public class RedisDAO implements IRedisDAO{
//	@Resource(name="redisTemplate")
//	private RedisTemplate<Serializable, Serializable> redisTemplate;
//	
//	public void saveUser(final User user) {
//        redisTemplate.execute(new RedisCallback<Object>() {
//            public Object doInRedis(RedisConnection connection) throws DataAccessException {
//                connection.set(redisTemplate.getStringSerializer().serialize("user.id"+user.getId()), 
//              redisTemplate.getStringSerializer().serialize(user.getAccount()));
//                return null;
//            }
//        });
//    }
}
