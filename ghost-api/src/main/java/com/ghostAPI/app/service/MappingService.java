package com.ghostAPI.app.service;

import com.ghostAPI.app.config.StubMapping;
import com.ghostAPI.app.config.StubMappingEntity;
import org.springframework.stereotype.Service;

@Service
public interface MappingService {
    StubMappingEntity saveMapping(StubMappingEntity mapping);
}
