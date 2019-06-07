package com.gupb.inventory.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gupb
 */
@Data
public class InventoryDO implements Serializable {

    private static final long serialVersionUID = 6957734749389133832L;

    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 总库存
     */
    private Integer totalInventory;


}
