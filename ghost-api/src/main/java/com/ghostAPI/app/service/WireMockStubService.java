package com.ghostAPI.app.service;

import org.springframework.stereotype.Service;

@Service
public interface WireMockStubService {

    public String saveStubToDatabase(String stub);

}
