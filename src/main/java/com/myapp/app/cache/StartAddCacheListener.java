package com.myapp.app.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.myapp.app.util.RedisCacheUtil;

/*
 * 监听器，用于项目启动的时候初始化信息
 */
@Service
public class StartAddCacheListener implements ApplicationListener<ContextRefreshedEvent>
{
    //日志
//    @Autowired
//    private RedisCacheUtil<Object> redisCache;

	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		
	}
    
    
}