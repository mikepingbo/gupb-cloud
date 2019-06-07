package com.gupb.inventory.feign.hystrix;

import com.gupb.inventory.api.dto.InventoryDTO;
import com.gupb.inventory.api.entity.InventoryDO;
import com.gupb.inventory.feign.InventorytFeignApi;
import com.gupb.util.page.WrapMapperResult;
import com.gupb.util.page.WrapMapperUtil;
import org.springframework.stereotype.Component;

@Component
public class InventoryFeignHystrix implements InventorytFeignApi {

    @Override
    public WrapMapperResult<Boolean> decrease(InventoryDTO inventoryDTO) {
        return WrapMapperUtil.failBiz("Feign请求Account服务失败");
    }

    @Override
    public WrapMapperResult<InventoryDO> findByProductId(String productId) {
        return WrapMapperUtil.failBiz("Feign请求Account服务失败");
    }
}
