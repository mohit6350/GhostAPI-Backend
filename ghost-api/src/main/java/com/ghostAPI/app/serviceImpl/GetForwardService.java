package com.ghostAPI.app.serviceImpl;

import com.ghostAPI.app.service.ForwardingService;
import org.springframework.stereotype.Service;

@Service
public class GetForwardService implements ForwardingService {

    @Override
    public boolean doForward() {
        return false;
    }
}
