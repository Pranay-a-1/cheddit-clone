package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.models.User;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;
import com.pranay.cheddit.cheddit.exceptions.JWTParsingException;


@Service
@Slf4j
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


    @Override
    public String getUserFromToken(String token) {
        try {
            return Jwts.parser().setSigningKey("secretKey123456").parseClaimsJws(token).getBody().getSubject();
        } catch (Exception e) {
            // Log the exception (replace 'logger' with your logger instance)
            log.error("Unable to get user from token", e);
            // Return null or throw a custom exception
            throw new JWTParsingException("Unable to parse user from token");
        }
    }


}
