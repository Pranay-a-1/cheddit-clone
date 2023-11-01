package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.models.User;

public interface PasswordAuthService {

    String hashPassword(String password);

    String generateJwtToken(User newUser);
}