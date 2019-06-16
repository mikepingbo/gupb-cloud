package com.gupb.inventory.api.service;

import com.gupb.inventory.api.dto.InventoryDTO;
import com.gupb.inventory.api.entity.InventoryDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryService.class);

//    private AccountMapper accountMapper;

    /**
     * 扣减库存操作
     * 这一个tcc接口
     *
     * @param inventoryDTO 库存DTO对象
     * @return true
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean decrease(InventoryDTO inventoryDTO) {
        LOGGER.info("==========springcloud调用扣减库存decrease===========");
        LOGGER.info(inventoryDTO.getProductId());
//        final InventoryDO entity = inventoryMapper.findByProductId(inventoryDTO.getProductId());
//
//        if (entity.getTotalInventory() < inventoryDTO.getCount()) {
//            throw new GupbRuntimeException(" spring cloud inventory-service 库存不足!");
//        }
//
//        entity.setTotalInventory(entity.getTotalInventory() - inventoryDTO.getCount());
//
//        final int decrease = inventoryMapper.decrease(entity);
//        if (decrease != 1) {
//            throw new GupbRuntimeException("spring cloud inventory-service 库存不足!");
//        }

        return true;
    }

    /**
     * 获取商品库存信息
     *
     * @param productId 商品id
     * @return InventoryDO
     */
    public InventoryDO findByProductId(String productId) {
//        return inventoryMapper.findByProductId(productId);

        return null;
    }

}
