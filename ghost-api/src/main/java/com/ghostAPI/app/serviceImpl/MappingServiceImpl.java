package com.ghostAPI.app.serviceImpl;

import com.ghostAPI.app.config.StubMappingEntity;
import com.ghostAPI.app.repository.MappingRespository;
import com.ghostAPI.app.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MappingServiceImpl implements MappingService {

    @Autowired
    private MappingRespository mappingRespository;

    @Override
    public StubMappingEntity saveMapping(StubMappingEntity mapping) {
        return mappingRespository.save(mapping);
    }

    @Override
    public List<StubMappingEntity> fetchAllGetStubs(){
        return mappingRespository.findAll();
    }

}
