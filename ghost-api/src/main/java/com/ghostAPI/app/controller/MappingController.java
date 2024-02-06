package com.ghostAPI.app.controller;

import com.ghostAPI.app.config.StubMapping;
import com.ghostAPI.app.config.StubMappingEntity;
import com.ghostAPI.app.serviceImpl.MappingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mappings")
public class MappingController {

    @Autowired
    private MappingServiceImpl mappingService;

    @PostMapping("/mock-get")
    public StubMappingEntity mockGetRequest(@RequestBody StubMappingEntity mapping){
        System.err.println(mapping);
        return mappingService.saveMapping(mapping);
    }

}
