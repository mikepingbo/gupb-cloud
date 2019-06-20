package com.gupb.order.service;

import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.gupb.account.api.dto.AccountDTO;
import com.gupb.account.api.entity.AccountDO;
import com.gupb.account.feign.AccountFeignApi;
import com.gupb.annotation.Gupb;
import com.gupb.annotation.ModelTypeEnum;
import com.gupb.core.recketmq.GupbMqSendService;
import com.gupb.inventory.api.dto.InventoryDTO;
import com.gupb.inventory.api.entity.InventoryDO;
import com.gupb.inventory.feign.InventorytFeignApi;
import com.gupb.order.entity.Order;
import com.gupb.order.enums.OrderStatusEnum;
import com.gupb.util.entity.GupbTransaction;
import com.gupb.util.exception.GupbRuntimeException;
import com.gupb.util.page.WrapMapperResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * The type Payment service.
 *
 * @author gupb
 */
@Service
public class PaymentService {

    @Autowired
    private AccountFeignApi accountFeignApi;

    @Autowired
    private InventorytFeignApi inventorytFeignApi;

    @Gupb(model = ModelTypeEnum.SERVICE)
    public void makePayment(Order order) {
        //检查数据 这里只是demo 只是demo 只是demo
//        order.setUserId("aaa");
//        final WrapMapperResult<AccountDO> accountDOResult = accountFeignApi.findByUserId(order.getUserId());
//
//        if (accountDOResult == null || !accountDOResult.getSuccess()) {
//            throw new GupbRuntimeException("服务异常");
//        }
//        AccountDO accountDO = accountDOResult.getData();
//        if (accountDO != null && accountDO.getBalance().compareTo(order.getTotalAmount()) <= 0) {
//            throw new GupbRuntimeException("余额不足！");
//        }
//
//        final WrapMapperResult<InventoryDO> inventoryDOResult = inventorytFeignApi.findByProductId(order.getProductId());
//
//        if (inventoryDOResult == null || !inventoryDOResult.getSuccess()) {
//            throw new GupbRuntimeException("服务异常");
//        }
//        InventoryDO inventoryDO = inventoryDOResult.getData();
//        if (inventoryDO != null && inventoryDO.getTotalInventory() < order.getCount()) {
//            throw new GupbRuntimeException("库存不足！");
//        }
//
//        order.setStatus(OrderStatusEnum.PAY_SUCCESS.getCode());
//        orderMapper.update(order);
        // 扣除用户余额
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAmount(order.getTotalAmount() == null ? BigDecimal.valueOf(1) : order.getTotalAmount());
        accountDTO.setUserId(StringUtils.isEmpty(order.getUserId()) ? "system" : order.getUserId());
        accountFeignApi.payment(accountDTO);

        // 进入扣减库存操作
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setCount(order.getCount() == null ? 100 : order.getCount());
        inventoryDTO.setProductId(StringUtils.isEmpty(order.getProductId()) ? "system" : order.getProductId());
        inventorytFeignApi.decrease(inventoryDTO);
    }
}
