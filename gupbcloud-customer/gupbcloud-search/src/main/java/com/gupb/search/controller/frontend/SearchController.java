package com.gupb.search.controller.frontend;

import com.gupb.search.entity.EsProduct;
import com.gupb.search.service.SearchService;
import com.gupb.util.page.WrapMapperResult;
import com.gupb.util.page.WrapMapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Api("Search服务商品檢索接口类")
@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @ApiOperation(value = "导入所有数据库中商品到ES")
    @RequestMapping(value = "/importall", method = RequestMethod.POST)
    @ResponseBody
    public WrapMapperResult<Integer> importAllList() {
        int count = searchService.importAll();
        return WrapMapperUtil.success(count);
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public WrapMapperResult<Page<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> esProductPage = searchService.search(keyword, pageNum, pageSize);

        return WrapMapperUtil.success(esProductPage);
    }
}
