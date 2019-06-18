package com.gupb.order.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class LettuceRedisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.redis.lettuce.pool")
    @Scope(value = "prototype")
    public GenericObjectPoolConfig redisPool(){
        return new GenericObjectPoolConfig();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis.redis-a")
    public RedisStandaloneConfiguration redisConfigA(){
        return new RedisStandaloneConfiguration();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis.redis-b")
    public RedisStandaloneConfiguration redisConfigB(){
        return new RedisStandaloneConfiguration();
    }

    @Bean
    @Primary
    public LettuceConnectionFactory factoryA(){
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder()
                .poolConfig(config).commandTimeout(Duration.ofMillis(config.getMaxWaitMillis())).build();
        return new LettuceConnectionFactory(redisConfigA(), clientConfiguration);
    }

    @Bean
    public LettuceConnectionFactory factoryB(){
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder()
                .poolConfig(config).commandTimeout(Duration.ofMillis(config.getMaxWaitMillis())).build();
        return new LettuceConnectionFactory(redisConfigB(), clientConfiguration);
    }

    @Bean
    public StringRedisTemplate redisTemplateA(){
        StringRedisTemplate template = getRedisTemplate();
        template.setConnectionFactory(factoryA());
        return template;
    }

    @Bean
    public StringRedisTemplate redisTemplateB(){
        StringRedisTemplate template = getRedisTemplate();
        template.setConnectionFactory(factoryB());
        return template;
    }


    private StringRedisTemplate getRedisTemplate(){
        StringRedisTemplate template = new StringRedisTemplate();
        template.setValueSerializer(new GenericFastJsonRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        return template;
    }
}