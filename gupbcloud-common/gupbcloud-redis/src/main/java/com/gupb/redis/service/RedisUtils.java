package com.gupb.redis.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.annotation.Resource;

@Component
public class RedisUtils {

    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RedisUtils.class);

    /** 过期时间：24小时 */
    public static final int EXPIRE_24_HOURS = 24 * 60 * 60;

    @Resource(name = "redisTemplateA")
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "redisTemplateB")
    private StringRedisTemplate stringRedisTemplateB;

	
	public boolean setString(final String key, String value, Long expireTime) {
        return this.setStringA(key, value, expireTime, TimeUnit.SECONDS);
    }
    /**
     * 写入缓存，字符串类型，没有保存时间，请谨慎使用
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
            opsForValue.set(key, value);
            result = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 保存字符串类型，默认24小时
     * @param key
     * @param value
     * @return
     */
    public boolean setStringA(final String key, String value) {
        boolean result = false;
        try {
            return setStringA(key, value, Long.valueOf(EXPIRE_24_HOURS), TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean setStringB(final String key, String value) {
        boolean result = false;
        try {
            return setStringB(key, value, Long.valueOf(EXPIRE_24_HOURS), TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 保存字符串类型，有保存时间
     * @param key
     * @param value
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public boolean setStringA(final String key, String value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
            opsForValue.set(key, value, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean setStringB(final String key, String value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            ValueOperations<String, String> opsForValue = stringRedisTemplateB.opsForValue();
            opsForValue.set(key, value, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 获取string类型缓存数据
     * @param key
     * @return
     */
    public String getStringA(final String key) {
        String result = null;
        try {
            ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
            result = opsForValue.get(key);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public String getStringB(final String key) {
        String result = null;
        try {
            ValueOperations<String, String> opsForValue = stringRedisTemplateB.opsForValue();
            result = opsForValue.get(key);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }
    
    /**
     * 读取缓存, 返回List
     *
     * @param <T>
     * @param key
     * @return
     */
    public <T> List<T> getListObject(final String key, Class<T> classOfT) {
        List<T> list = null;
        try {
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            String value = operations.get(key);
            // logger.info("key值" + key + "从redis获取到的value值:" + value);
            if (StringUtils.isBlank(value)) {
                return null;
            }
            JSONArray jsonArray = JSONArray.parseArray(value);
            list = JSONObject.parseArray(value, classOfT);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return list;
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        try {
            for (String key : keys) {
                remove(key);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 通过key删除
     * @param keys
     */
    public void removeStringKeys(Collection<String> keys) {
        try {
            stringRedisTemplate.delete(keys);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 多个key删除
     * @param keys
     */
    public void removeStringKeys(final String... keys) {
        try {
            stringRedisTemplate.delete(Arrays.asList(keys));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public Set<String> getStringKeysByPattern(final String pattern) {
        Set<String> result = null;
        try {
            result = stringRedisTemplate.keys(pattern);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public void removeStringKey(final String key) {
        try {
            if (existsStringKey(key)) {
                stringRedisTemplate.delete(key);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public boolean existsStringKey(final String key) {
        boolean bool = false;
        try {
            bool = stringRedisTemplate.hasKey(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return bool;
    }

    /**
     * 读取redis缓存
     * 
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        try {
            ValueOperations operations = stringRedisTemplate.opsForValue();
            result = operations.get(key);
        } catch (Exception e) {
            logger.error("读取redis缓存失败！错误信息为：" + e.getMessage());
        }
        return result;
    }

    /**
     * 重新设置缓存时效时间-默认秒
     * 
     * @param key
     * @param expireTime
     * @return
     */
    public boolean expire(final String key, Long expireTime) {
        return expire(key, expireTime, TimeUnit.SECONDS);
    }

    /***
     * 重新设置缓存时效时间
     * 
     * @param key
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public boolean expire(final String key, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            stringRedisTemplate.expire(key, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * get value
     * 
     * @param key
     * @return
     */
    public Object stringGet(String key) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String result = operations.get(key);
        // logger.info("从redis获取到的值:" + result);

        return result;
    }

    /**
     * 删除对应的value
     * 
     * @param key
     */
    public void stringRemove(final String key) {
        if (stringExistsStr(key)) {
            stringRedisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     * 
     * @param key
     * @return
     */
    public boolean stringExistsStr(final String key) {
        return stringRedisTemplate.hasKey(key);
    }

    public String incr(final String key, Long l) {
        String result = null;
        try {
            ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
            opsForValue.increment(key, l);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public Long incr(final String key) {
        Long result = null;
        try {
            ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
            result = opsForValue.increment(key, 1L);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public Long decr(final String key) {
        Long result = null;
        try {
            ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
            result = opsForValue.increment(key, -1L);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public Long decr(final String key, Long l) {
        Long result = null;
        try {
            ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
            l = 0 - l;
            result = opsForValue.increment(key, l);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 设置某个时间点过期
     * 
     * @param key
     * @param expirationTime
     * @param timeUnit
     * @return
     */
    public boolean expireAt(String key, long expirationTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            result = stringRedisTemplate.expire(key, expirationTime, timeUnit);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 删除key
     * 
     * @param key
     * @return
     */
    public Boolean del(String key) {
        Boolean result = null;
        try {
            result = stringRedisTemplate.delete(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}