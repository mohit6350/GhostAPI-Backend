package com.ghostAPI.app.serviceImpl;

import com.ghostAPI.app.config.WireMockStubEntity;
import com.ghostAPI.app.repository.WiremockStubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WireMockStubServiceImpl {

    @Autowired
    private WiremockStubRepository wireMockStubRepository;


    public String saveStub(String stub) {
        // Save the WireMock stub to the database
        WireMockStubEntity entity = new WireMockStubEntity();
        entity.setJsonBody(stub);
        wireMockStubRepository.save(entity);

        return "WireMock stub saved successfully!";
    }

    // You can add more methods for additional functionality as needed
}
