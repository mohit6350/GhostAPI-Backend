package com.ghostAPI.app.serviceImpl;

import com.ghostAPI.app.config.WireMockStubEntity;
import com.ghostAPI.app.config.WiremockPostStubGenerator;
import com.ghostAPI.app.repository.WiremockStubRepository;
import com.ghostAPI.app.service.WireMockStubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WireMockGetStubServiceImpl implements WireMockStubService {

    @Autowired
    private WiremockStubRepository wireMockStubRepository;

    private WiremockPostStubGenerator wiremockPostStubGenerator;


    public String saveStubToDatabase(String stub) {
        // Save the WireMock stub to the database
        WireMockStubEntity entity = new WireMockStubEntity();
        entity.setJsonBody(stub);
        wireMockStubRepository.save(entity);

        return "WireMock stub saved successfully!";
    }

    public String saveToWireMock(String stub){
        return null;
    }

}
