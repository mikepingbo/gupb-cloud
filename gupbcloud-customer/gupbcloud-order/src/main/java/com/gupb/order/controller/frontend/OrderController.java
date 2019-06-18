package com.gupb.order.controller.frontend;

import com.gupb.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Api("Order服务订单接口类")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/pay")
    @ApiOperation(value = "订单支付接口（注意这里模拟的是创建订单并进行支付扣减库存等操作）")
    public String orderPay(@RequestParam(value = "count") Integer count,
                           @RequestParam(value = "amount") BigDecimal amount) {
        return orderService.orderPay(count, amount);
    }

    @GetMapping(value = "/test1")
    @ApiOperation(value = "测试Redis接口set")
    public String test1() {
        orderService.test1();

        return "sucess";
    }

    @GetMapping(value = "/test2")
    @ApiOperation(value = "测试Redis接口get")
    public String test2(@RequestParam(value = "key") String key) {
        orderService.test2(key);

        return "sucess";
    }
}
