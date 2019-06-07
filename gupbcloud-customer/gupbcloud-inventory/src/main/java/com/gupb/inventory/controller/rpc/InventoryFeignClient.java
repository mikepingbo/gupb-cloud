package com.gupb.inventory.controller.rpc;

import com.gupb.inventory.api.dto.InventoryDTO;
import com.gupb.inventory.api.entity.InventoryDO;
import com.gupb.inventory.feign.InventorytFeignApi;
import com.gupb.inventory.service.InventoryService;
import com.gupb.util.base.BaseController;
import com.gupb.util.page.WrapMapperResult;
import com.gupb.util.page.WrapMapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@Api(value = "Inventory服务Feign接口API")
public class InventoryFeignClient extends BaseController implements InventorytFeignApi {

    @Autowired
    private InventoryService accountService;

    @Override
    @ApiOperation(value = "扣库存API", notes = "扣库存API")
    public WrapMapperResult<Boolean> decrease(InventoryDTO inventoryDTO) {
        Boolean result =  accountService.decrease(inventoryDTO);

        return WrapMapperUtil.success(result);
    }

    @Override
    @ApiOperation(value = "查询库存信息API", notes = "查询库存信息API")
    public WrapMapperResult<InventoryDO> findByProductId(String productId) {
        InventoryDO result =  accountService.findByProductId(productId);

        return WrapMapperUtil.success(result);
    }
}
