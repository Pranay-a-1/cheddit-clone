package com.pranay.cheddit.cheddit.jbehaveTests.steps;

import com.pranay.cheddit.cheddit.dto.RegisterRequest;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignupSteps extends Steps {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:7001"; // Adjust the base URL as needed
    private ResponseEntity<String> response;

    @Given("a new user with valid details")
    public void givenANewUserWithValidDetails() {
        try {
            RegisterRequest request = new RegisterRequest("validUsername", "valid@email.com", "validPassword", "validPassword");
            response = restTemplate.postForEntity(baseUrl + "/register", request, String.class);
        } catch (Exception e) {
            System.out.println("Error when registering user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @When("the user submits the registration form")
    public void whenTheUserSubmitsTheRegistrationForm() {
        // This step is already covered in the 'Given' steps where we send the request
    }

    @Then("the registration is successful")
    public void thenTheRegistrationIsSuccessful() {
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(Objects.requireNonNull(response.getBody()).contains("User Registration Successful"));
    }

    @Given("a new user with a username that already exists")
    public void givenANewUserWithAUsernameThatAlreadyExists() {
        // Pre-populate the database or mock the service to simulate an existing user
        RegisterRequest request = new RegisterRequest("existingUser", "new@email.com", "password", "password");
        response = restTemplate.postForEntity(baseUrl + "/register", request, String.class);
    }

    @Then("the registration fails with a username already exists message")
    public void thenTheRegistrationFailsWithAUsernameAlreadyExistsMessage() {
        assertEquals(400, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("Username or Email already exists"));
    }

    @Given("a new user with mismatched passwords")
    public void givenANewUserWithMismatchedPasswords() {
        RegisterRequest request = new RegisterRequest("newUser", "new@email.com", "password", "differentPassword");
        response = restTemplate.postForEntity(baseUrl + "/register", request, String.class);
    }

    @Then("the registration fails with a password mismatch message")
    public void thenTheRegistrationFailsWithAPasswordMismatchMessage() {
        assertEquals(400, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("Passwords do not match"));
    }
}
