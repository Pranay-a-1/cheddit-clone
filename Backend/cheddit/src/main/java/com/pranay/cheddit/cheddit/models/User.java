package com.pranay.cheddit.cheddit.models;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotBlank(message = "Please add a valid Username")
    private String username;

    @Email(message = "Please add a valid Email address")
    private String email;

    @NotBlank(message = "Please add a valid Password")
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;


    public User(String username, String email, String hashedPassword, LocalDateTime now, LocalDateTime now1) {
        this.username = username;
        this.email = email;
        this.password = hashedPassword;
        this.createdAt = now;
        this.updatedAt = now1;
    }
}
