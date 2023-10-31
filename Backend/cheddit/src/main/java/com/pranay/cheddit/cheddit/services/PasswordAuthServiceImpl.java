package com.pranay.cheddit.cheddit.services;

import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;


@Service
public class PasswordAuthServiceImpl implements PasswordAuthService {


    @Override
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }
}
