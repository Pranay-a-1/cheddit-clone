package com.pranay.cheddit.cheddit.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPostRequest {

    @NotBlank(message = "Post text cannot be empty")
    private String postText;

    @NotBlank(message = "User must be logged in")
    private String accessToken;
}
