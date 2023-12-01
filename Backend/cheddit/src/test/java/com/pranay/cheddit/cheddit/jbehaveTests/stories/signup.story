Narrative:
As a new user
I want to sign up for an account
So that I can use the application

Scenario: Successful registration
Given a new user with valid details
When the user submits the registration form
Then the registration is successful

Scenario: Registration with an existing username
Given a new user with a username that already exists
When the user submits the registration form
Then the registration fails with a username already exists message

Scenario: Registration with mismatched passwords
Given a new user with mismatched passwords
When the user submits the registration form
Then the registration fails with a password mismatch message
