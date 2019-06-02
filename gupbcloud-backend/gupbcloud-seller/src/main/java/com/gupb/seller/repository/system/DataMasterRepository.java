package com.gupb.seller.repository.system;


import com.gupb.seller.model.system.DataMaster;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataMasterRepository {

    List<DataMaster> getCodes(@Param("queryMap") Map<String, String> queryMap);
}
