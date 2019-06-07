package com.gupb.seller.controller.frontend;

import com.gupb.util.base.BaseController;
import com.gupb.util.page.WrapMapperResult;
import com.gupb.util.page.WrapMapperUtil;
import com.gupb.seller.model.system.DataMaster;
import com.gupb.seller.service.DataMasterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("Seller服务数据字典接口类")
@RestController
public class DataMasterController extends BaseController {

    @Autowired
    private DataMasterService dataMasterService;

    @RequestMapping(value = "/datamaster/codes", method = RequestMethod.GET)
    @ApiOperation(value = "获取数据字典CodeListAPI", notes = "获取数据字典CodeListAPI")
    public WrapMapperResult<Object> datamastercodes(String masterCode) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("masterCode", "PROMOTION_NAME");
        List<DataMaster> result =  dataMasterService.getCodes(queryMap);

        return WrapMapperUtil.success(result);
    }
}
