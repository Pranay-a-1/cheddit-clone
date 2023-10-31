package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.dto.AuthenticationResponse;
import com.pranay.cheddit.cheddit.dto.RegisterRequest;
import org.springframework.stereotype.Service;

public interface AuthService {
    AuthenticationResponse registerUser(RegisterRequest registerRequest) ;
}
