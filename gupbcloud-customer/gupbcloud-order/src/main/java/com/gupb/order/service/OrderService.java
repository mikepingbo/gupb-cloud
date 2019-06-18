package com.gupb.order.service;

import com.gupb.order.entity.Order;
import com.gupb.redis.service.RedisAUtils;
import com.gupb.redis.service.RedisBUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RedisAUtils redisAUtils;

    @Autowired
    private RedisBUtils redisBUtils;

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

        return "success";
    }

    public void test1() {
        redisAUtils.set("gupba", "gupba");
        redisBUtils.set("gupba", "gupbb");
    }

    public void test2(String key) {
        System.out.println(redisAUtils.get(key));
        System.out.println(redisBUtils.get(key));
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
