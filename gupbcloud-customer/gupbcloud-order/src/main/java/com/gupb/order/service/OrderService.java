package com.gupb.order.service;

import com.gupb.order.entity.Order;
import com.gupb.order.enums.OrderStatusEnum;
import com.gupb.redis.service.RedisUtils;
import com.gupb.util.IdWorkerUtils;
import com.gupb.util.mq.MessageEntity;
import io.lettuce.core.output.ScanOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    public String orderPay(Integer count, BigDecimal amount) {
        final Order order = buildOrder(count, amount);
//        final int rows = orderMapper.save(order);

//        if (rows > 0) {
            paymentService.makePayment(order);
//        }

        redisUtils.setStringA("gupba", "gupba");
        redisUtils.setStringB("gupbb", "gupbb");

        System.out.println(redisUtils.getStringA("gupba"));
        System.out.println(redisUtils.getStringA("gupbb"));
        return "success";
    }

    public void test() {
        redisUtils.setStringA("gupba", "gupba");
        redisUtils.setStringB("gupbb", "gupbb");

        System.out.println(redisUtils.getStringA("gupba"));
        System.out.println(redisUtils.getStringA("gupbb"));
    }

    private Order buildOrder(Integer count, BigDecimal amount) {
        LOGGER.debug("构建订单对象");
        Order order = new Order();
//        order.setCreateTime(new Date());
//        order.setNumber(IdWorkerUtils.getInstance().createUUID());
//        demo中的表里只有商品id为 1的数据
//        order.setProductId("1");
//        order.setStatus(OrderStatusEnum.NOT_PAY.getCode());
//        order.setTotalAmount(amount);
//        order.setCount(count);
//        demo中 表里面存的用户id为10000
//        order.setUserId("10000");
        return order;
    }
}
