package com.ghostAPI.app.serviceImpl;

import com.ghostAPI.app.repository.LoginRepository;
import com.ghostAPI.app.requestModel.Login;
import com.ghostAPI.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public boolean isValidUser(String username, String password) {
        return false;
    }

    @Override
    public Login saveUser(Login login) {
         return loginRepository.save(login);
    }
}
