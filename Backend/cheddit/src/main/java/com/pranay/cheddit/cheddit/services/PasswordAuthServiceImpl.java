package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.models.User;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;


@Service
public class PasswordAuthServiceImpl implements PasswordAuthService {


    @Override
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }

    @Override
    public String generateJwtToken(User user) {
        // Generate JWT token using JJWT
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date now = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 5); // Adds 5 days to myDate
        Date expiryDate = calendar.getTime();

        return Jwts.builder()
                .setSubject(user.getId())
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, "secretKey123456") // Use a proper secret key
                .setExpiration(expiryDate)  // 5 days
                .compact();
    }

    @Override
    public boolean validatePassword(String password, String password1) {
        return BCrypt.checkpw(password, password1);
    }
}
