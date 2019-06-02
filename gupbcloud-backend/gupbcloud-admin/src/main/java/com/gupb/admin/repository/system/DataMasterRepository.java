package com.gupb.admin.repository.system;


import com.gupb.admin.model.system.DataMaster;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataMasterRepository {

    public List<DataMaster> getCodes(@Param("queryMap") Map<String, String> queryMap);
}
