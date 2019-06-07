package com.gupb.inventory.feign;

import com.gupb.inventory.api.dto.InventoryDTO;
import com.gupb.inventory.api.entity.InventoryDO;
import com.gupb.inventory.feign.hystrix.InventoryFeignHystrix;
import com.gupb.util.feign.FeignConfig;
import com.gupb.util.page.WrapMapperResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gupbcloud-inventory", configuration = FeignConfig.class, fallback = InventoryFeignHystrix.class)
public interface InventorytFeignApi {

    @RequestMapping(value = "/inventory/decrease", method = RequestMethod.POST)
    WrapMapperResult<Boolean> decrease(@RequestBody InventoryDTO inventoryDTO);


    @RequestMapping(value = "/inventory/findByProductId", method = RequestMethod.GET)
    WrapMapperResult<InventoryDO> findByProductId(@RequestParam("productId") String productId);
}
