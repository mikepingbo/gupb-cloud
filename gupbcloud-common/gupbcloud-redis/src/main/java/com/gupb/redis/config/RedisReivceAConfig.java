package com.gupb.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisReivceAConfig {

    /**
     * redisDevTemplate 数据源
     */
    @Bean(name = "redisATemplate")
    public StringRedisTemplate redisTemplate(@Value("${spring.redis.a.host}") String hostName,
                                             @Value("${spring.redis.a.port}") int port,
                                             @Value("${spring.redis.a.testOnBorrow}") boolean testOnBorrow,
                                             @Value("${spring.redis.a.database}") int index,
                                             @Value("${spring.redis.max-idle}") int maxIdle,
                                             @Value("${spring.redis.max-active}") int maxTotal,
                                             @Value("${spring.redis.max-wait}") long maxWaitMillis) {
        StringRedisTemplate temple = new StringRedisTemplate();
        RedisReivceCommon redisReivceCommon = new RedisReivceCommon();
        temple.setConnectionFactory(
                redisReivceCommon.connectionFactory(hostName, port, maxIdle, maxTotal, index, maxWaitMillis, testOnBorrow));

        return temple;
    }
}