package com.ghostAPI.app.service;

import com.ghostAPI.app.config.StubMappingEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MappingService {
    StubMappingEntity saveMapping(StubMappingEntity mapping);

    List<StubMappingEntity> fetchAllGetStubs();
}
