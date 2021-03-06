package com.gupb.admin.service;

import com.gupb.admin.model.system.DataMaster;
import com.gupb.admin.repository.system.DataMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataMasterService {

    @Autowired
    private DataMasterRepository dataMasterRepository;

    public List<DataMaster> getCodes(Map<String, String> queryMap) {
        return dataMasterRepository.getCodes(queryMap);
    }
}
