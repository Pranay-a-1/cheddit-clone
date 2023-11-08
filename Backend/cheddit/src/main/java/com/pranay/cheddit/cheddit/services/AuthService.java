package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.dto.AuthenticationResponse;
import com.pranay.cheddit.cheddit.dto.LoginRequest;
import com.pranay.cheddit.cheddit.dto.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

public interface AuthService {
    CompletableFuture<AuthenticationResponse> registerUser(RegisterRequest registerRequest) ;

    AuthenticationResponse loginUser(LoginRequest loginRequest);
}
