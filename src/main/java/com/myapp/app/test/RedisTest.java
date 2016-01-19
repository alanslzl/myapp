package com.myapp.app.test;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations={"/spring-config/spring-core.xml"})
@Repository
@Transactional
public class RedisTest {

}
