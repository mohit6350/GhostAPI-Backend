package com.ghostAPI.app.controller;

import com.ghostAPI.app.config.WiremockPostStubGenerator;
import com.ghostAPI.app.serviceImpl.WireMockGetStubServiceImpl;
import com.ghostAPI.app.serviceImpl.WireMockPostStubServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generic-mapping")
public class GetStubGenericController {

    @Autowired
    private WiremockPostStubGenerator wireMockStubGenerator;

    @Autowired
    private WireMockPostStubServiceImpl wireMockStubService;

    @Autowired
    private WireMockGetStubServiceImpl wireMockGetStubService;

    @PostMapping("/generate-get-stub")
    public ResponseEntity<String> generateStub(@RequestBody String requestBody) {
        try {
            // Generate WireMock stub based on the provided JSON
            String wireMockStub = wireMockStubGenerator.generatePostStubJson(requestBody);

            // You might want to save the generated WireMock stub to a file or repository here
            String result = wireMockStubService.saveStubToDatabase(wireMockStub);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            // Handle any exceptions that might occur during stub generation
            return new ResponseEntity<>("Error generating WireMock stub", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
