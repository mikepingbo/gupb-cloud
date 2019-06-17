package com.gupb.search.repository.product;

import com.gupb.search.entity.EsProduct;
import org.mapstruct.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface SearchProductRepository {

    /**
     * 商品查询
     *
     * @param id
     * @return
     */
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
