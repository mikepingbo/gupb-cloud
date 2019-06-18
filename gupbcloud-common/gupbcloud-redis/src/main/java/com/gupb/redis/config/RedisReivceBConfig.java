package com.gupb.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisReivceBConfig {

    /**
     * redisTestTemplate 数据源
     */
    @Bean(name = "redisBTemplate")
    public StringRedisTemplate redisTemplate(@Value("${spring.redis.b.host}") String hostName,
                                             @Value("${spring.redis.b.port}") int port,
                                             @Value("${spring.redis.b.testOnBorrow}") boolean testOnBorrow,
                                             @Value("${spring.redis.b.database}") int index,
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