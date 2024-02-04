package com.ghostAPI.app.service;

import com.ghostAPI.app.repository.LoginRepository;
import com.ghostAPI.app.requestModel.Login;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    boolean isValidUser(String username, String password);

    Login saveUser(Login login);

}
