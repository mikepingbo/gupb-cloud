package com.gupb.search.service;

import com.gupb.search.entity.EsProduct;
import com.gupb.search.repository.product.EsProductRepository;
import com.gupb.search.repository.product.SearchProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchProductRepository searchProductRepository;

    @Autowired
    private EsProductRepository esProductRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 从数据库中导入所有商品到ES
     *
     * @return
     */
    public int importAll() {
        List<EsProduct> esProductList = searchProductRepository.getAllEsProductList(null);
        Iterable<EsProduct> esProductIterable = esProductRepository.saveAll(esProductList);
//        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int result = 0;
//        while (iterator.hasNext()) {
//            result++;
//            iterator.next();
//        }
        return result;
    }

    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return esProductRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, pageable);
    }
}
