package com.gupb.redis.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class AbRedisConfiguration {

    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AbRedisConfiguration.class);

    public static final int EXPIRE_24_HOURS = 24 * 60 * 60;

    protected StringRedisTemplate stringRedisTemplate;

    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            return set(key, value, Long.valueOf(EXPIRE_24_HOURS), TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean set(final String key, String value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            ValueOperations<String, String> opsForValue = getStringRedisTemplate().opsForValue();
            opsForValue.set(key, value, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public String get(final String key) {
        String result = null;
        try {
            ValueOperations<String, String> opsForValue = getStringRedisTemplate().opsForValue();
            result = opsForValue.get(key);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public <T> List<T> getListObject(final String key, Class<T> classOfT) {
        List<T> list = null;
        try {
            ValueOperations<String, String> operations = getStringRedisTemplate().opsForValue();
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

    public void remove(final String... keys) {
        try {
            for (String key : keys) {
                remove(key);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void removeKeys(Collection<String> keys) {
        try {
            getStringRedisTemplate().delete(keys);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void removeKeys(final String... keys) {
        try {
            getStringRedisTemplate().delete(Arrays.asList(keys));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public Set<String> getKeysByPattern(final String pattern) {
        Set<String> result = null;
        try {
            result = getStringRedisTemplate().keys(pattern);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public void removeKey(final String key) {
        try {
            if (existsKey(key)) {
                getStringRedisTemplate().delete(key);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public boolean existsKey(final String key) {
        boolean bool = false;
        try {
            bool = getStringRedisTemplate().hasKey(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return bool;
    }

    public boolean expire(final String key, Long expireTime) {
        return expire(key, expireTime, TimeUnit.SECONDS);
    }

    public boolean expire(final String key, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            getStringRedisTemplate().expire(key, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public String incr(final String key, Long l) {
        String result = null;
        try {
            ValueOperations<String, String> opsForValue = getStringRedisTemplate().opsForValue();
            opsForValue.increment(key, l);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public Long incr(final String key) {
        Long result = null;
        try {
            ValueOperations<String, String> opsForValue = getStringRedisTemplate().opsForValue();
            result = opsForValue.increment(key, 1L);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public Long decr(final String key) {
        Long result = null;
        try {
            ValueOperations<String, String> opsForValue = getStringRedisTemplate().opsForValue();
            result = opsForValue.increment(key, -1L);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public Long decr(final String key, Long l) {
        Long result = null;
        try {
            ValueOperations<String, String> opsForValue = getStringRedisTemplate().opsForValue();
            l = 0 - l;
            result = opsForValue.increment(key, l);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean expireAt(String key, long expirationTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            result = getStringRedisTemplate().expire(key, expirationTime, timeUnit);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public Boolean del(String key) {
        Boolean result = null;
        try {
            result = getStringRedisTemplate().delete(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }
}