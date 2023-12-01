<div align="center">
<h1 align="center">
<!-- <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" width="100" /> -->
<br>CHEDDIT-CLONE</h1>
<h3>◦ Cheddit-Clone: Coding Community, Duplicated Delight!</h3>
<h3>◦ Developed with the software and tools below.</h3>

<p align="center">
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat-square&logo=openjdk&logoColor=white" alt="java" />
<img src="https://img.shields.io/badge/MongoDB-4EA94B.svg?style=flat-square&logo=mongodb&logoColor=white" alt="MongoDB" />
<img src="https://img.shields.io/badge/Spring_Boot-6DB33F.svg?style=flat-square&logo=spring-boot&logoColor=white" alt="Spring Boot" />
<img src="https://img.shields.io/badge/React-61DAFB.svg?style=flat-square&logo=React&logoColor=black" alt="React" />
<img src="https://img.shields.io/badge/JavaScript-F7DF1E.svg?style=flat-square&logo=JavaScript&logoColor=black" alt="JavaScript" />
<img src="https://img.shields.io/badge/HTML5-E34F26.svg?style=flat-square&logo=HTML5&logoColor=white" alt="HTML5" />
<img src="https://img.shields.io/badge/Bootstrap-7952B3.svg?style=flat-square&logo=Bootstrap&logoColor=white" alt="Bootstrap" />
<img src="https://img.shields.io/badge/Axios-5A29E4.svg?style=flat-square&logo=Axios&logoColor=white" alt="Axios" />
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat-square&logo=openjdk&logoColor=white" alt="java" />
<img src="https://img.shields.io/badge/JSON-000000.svg?style=flat-square&logo=JSON&logoColor=white" alt="JSON" />
</p>
<img src="https://img.shields.io/github/license/Pranay-a-1/cheddit-clone?style=flat-square&color=5D6D7E" alt="GitHub license" />
<img src="https://img.shields.io/github/last-commit/Pranay-a-1/cheddit-clone?style=flat-square&color=5D6D7E" alt="git-last-commit" />
<img src="https://img.shields.io/github/commit-activity/m/Pranay-a-1/cheddit-clone?style=flat-square&color=5D6D7E" alt="GitHub commit activity" />
<img src="https://img.shields.io/github/languages/top/Pranay-a-1/cheddit-clone?style=flat-square&color=5D6D7E" alt="GitHub top language" />
</div>

---

## 📖 Table of Contents
- [📖 Table of Contents](#-table-of-contents)
- [📍 Overview](#-overview)
- [📦 Features](#-features)
- [📂 repository Structure](#-repository-structure)
<!-- - [⚙️ Modules](#modules) -->
- [🚀 Getting Started](#-getting-started)
    - [🔧 Installation](#-installation)
    - [🤖 Running cheddit-clone](#-running-cheddit-clone)
    - [🧪 Tests](#-tests)
- [🛣 Roadmap](#-roadmap)

---


## 📍 Overview

The "Cheddit-Clone" repository provides a cloned functionality of Reddit. Written in Java (for backend) and JavaScript/React (for frontend), it allows user authentication, user registration, creation of new posts, and retrieval of existing posts. For testing purposes, it includes user stories and scenarios that validate these functionalities. It also offers API request handling, error reporting functionality, plus hashing of passwords for secure user data storage. The frontend utilizes React-Bootstrap for an enhanced user interface. This platform is a significant tool for developers aiming to understand and create a social discussion platform like Reddit or similar.

---

## 📦 Features

# User Authentication System

- **Robust Registration and Login:** Implements a secure user registration and login process, ensuring data integrity and security.
- **Exception Handling:** Integrates specialized exception handling for scenarios like existing user conflicts and incorrect password entries.
- **Asynchronous Processing:** Utilizes CompletableFuture for handling asynchronous operations in the authentication process, enhancing system responsiveness and scalability.

# Data Validation and Integrity

- **Automated User Input Validation:** Leverages Jakarta validation constraints to automatically validate user inputs during registration, ensuring compliance with defined standards such as email format and password length.
- **Secure Password Handling:** Incorporates password hashing and validation techniques, fortifying the system against common security threats.

# Global Exception Handling

- **Centralized Error Management:** Features a global exception handler to uniformly manage and respond to various exceptions, streamlining error handling and improving code maintainability.
- **Custom Exception Classes:** Implements custom exception classes for specific scenarios like UserAlreadyExistsException, PasswordsDoNotMatchException, and UserNotFoundException, providing clear and meaningful feedback to the user.

# Efficient User Model Design

- **Comprehensive User Representation:** The User model is designed to effectively represent users, encompassing essential fields with data validation annotations.
- **Timestamp Management:** Automatically handles creation and update timestamps for user data, facilitating data tracking and integrity.


# Clean and Maintainable Code Structure

- **Modular Design:** Adopts a modular approach to software design, enhancing code readability and maintainability.
- **Comprehensive Documentation:** All classes and methods are well-documented, aiding in understanding and future development efforts.


---

## 🛣 Project Roadmap

> - [X] `ℹ️  Task 1: Use JWT`
> - [X] `ℹ️  Task 2: Use Asyn `
> - [] `ℹ️  Task 3: Add create community feature  `
> - [ ] `ℹ️ Task 5: Add Delete post feature `
> - [ ] `ℹ️ Task 6: Implement factory configuration class`
> - [ ] `ℹ️ Task 7 : Deploy Backend to Heroku`
> - [ ] `ℹ️ Task 8: Deploy Front end to Netlify`
> - [ ] `ℹ️ Task 9: Add email feature`
> - [ ] `ℹ️ Task 10: Add Refresh Token`


---

---


## 📂 Repository Structure

```sh
└── cheddit-clone/
    ├── Backend/cheddit/src/main/java/com/pranay/cheddit/
│        ├── ChedditApplication.java
│        ├── controllers/
│        │   ├── AuthController.java
│        │   └── PostController.java
│        ├── dto/
│        │   ├── AuthenticationResponse.java
│        │   ├── LoginRequest.java
│        │   ├── NewPostRequest.java
│        │   └── RegisterRequest.java
│        ├── exceptions/
│        │   ├── GlobalExceptionHandler.java
│        │   ├── JWTParsingException.java
│        │   ├── PasswordsDoNotMatchException.java
│        │   ├── UserAlreadyExistsException.java
│        │   └── UserNotFoundException.java
│        ├── models/
│        │   ├── Post.java
│        │   └── User.java
│        ├── repositories/
│        │   ├── PostRepository.java
│        │   └── UserRepository.java
│        └── services/
│            ├── AuthService.java
│            ├── AuthServiceImpl.java
│            ├── PasswordAuthService.java
│            ├── PasswordAuthServiceImpl.java
│            ├── PostService.java
│            └── PostServiceImpl.java
│       └── test/java/com/pranay/cheddit/
│           ├── ChedditApplicationTests.java
│               ├── controllers/
│                    │   ├── AuthControllerTest.java
│                    │   └── PostControllerTest.java
│                    └── services/
		         ├── AuthServiceImplTest.java
		         └── PostServiceImplTest.java
    └── FrontEnd/
        ├── src/
        │   ├── App.js
        │   ├── api/
        │   │   └── authApi.jsx
        │   ├── assets/
        │   │   └── abstractelement-blue-yellow-8bit.png
        │   ├── components/
        │   │   ├── Header/
        │   │   │   ├── Header.jsx
        │   │   │   └── HeaderButton.jsx
        │   │   └── Post/
        │   │       └── Post.jsx
        │   ├── config/
        │   │   └── apiConfig.js
        │   ├── hooks/
        │   │   ├── useLoginHooks.jsx
        │   │   ├── useNewPostHooks.jsx
        │   │   └── useSignUpHooks.jsx
        │   ├── index.js
        │   ├── logo.svg
        │   └── pages/
        │       ├── Home.jsx
        │       ├── Login.jsx
        │       ├── NewPost.jsx
        │       └── SignUp.jsx
        └── test/
            ├── AppTests/
            │   ├── App.test.jsx
            │   └── index.test.jsx
            ├── componentTests/
            │   ├── Header.test.jsx
            │   └── Post.test.jsx
            ├── hookTests/
            │   ├── useLoginHooks.test.jsx
            │   ├── useNewPostHooks.test.jsx
            │   └── useSignUpHooks.test.jsx
            └── pageTests/
                ├── NewPage.test.jsx
                ├── login.test.jsx
                └── signUp.test.jsx
```
<!-- 
---


## ⚙️ Modules

<details closed><summary>Cheddit</summary>

| File                                                                                                                                                                        | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| ---                                                                                                                                                                         | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |

| [ChedditApplication.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/ChedditApplication.java)           | The code represents a structured Java Spring application named'ChedditApplication'. It includes the use of MongoDB as a database and supports asynchronous operations. Spring Boot's auto-configuration sets up the application context.                                                                   |

</details>

<details closed><summary>Controllers</summary>

| File                                                                                                                                                                          | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| ---                                                                                                                                                                           | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| [PostControllerTest.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/test/java/com/pranay/cheddit/cheddit/controllers/PostControllerTest.java) | The code is a set of unit tests for a'PostController' of a Reddit-like application. It verifies successful creation of a new post under various conditions, tests error handling when a post is created with an empty body or an unrecognized user, and whether all posts are successfully fetched. It also handles exceptions when fetching posts fails. The tests use Mockito for mocking objects and Spring's MockMvc for performing mock HTTP requests.                            |
| [AuthControllerTest.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/test/java/com/pranay/cheddit/cheddit/controllers/AuthControllerTest.java) | The provided code is a test suite for the Authentication controller in a Reddit-style forum application. It presents tests for registration and login functionalities. The tests cover a range of scenarios including successful registration and login, invalid username, invalid email, login failure, and an exception scenario during login. The testing framework used is JUnit and it incorporates mock objects using Mockito and Spring's MockMvc for simulating HTTP requests. |
| [AuthController.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/controllers/AuthController.java)         | This Java-based AuthController is part of a backend module for a'Cheddit' application. It provides RESTful APIs for user registration and login. The controller uses an AuthService to perform these operations asynchronously, returning either a successful response or a bad request upon failure. It also contains logging and supports Cross-Origin requests.                 |
| [PostController.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/controllers/PostController.java)         | The provided code pertains to the backend of a Reddit-like application, "Cheddit." It defines a'PostController' class that employs the'PostService' class to handle requests related to posts. It features the'allPosts' method which fetches all posts, and the'createNewPost' method that enables the creation of a new post. Both methods return the respective data or status encapsulated in an HTTP response entity.                                                             |

</details>

<details closed><summary>Services</summary>

| File                                                                                                                                                                                 | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| ---                                                                                                                                                                                  | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [AuthServiceImplTest.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/test/java/com/pranay/cheddit/cheddit/services/AuthServiceImplTest.java)         | The code tests the functionalities of the AuthServiceImpl in a'Cheddit' application, evaluating user registration and login processes. It checks conditions like whether a user already exists during registration, ensuring passwords match, etc. In login, the code verifies if a user is found and checks password validity. The methods throw exceptions when conditions are not met and return appropriate responses upon success. Mocking is used to isolate the AuthServiceImpl for unit testing.                           |
| [PostServiceImplTest.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/test/java/com/pranay/cheddit/cheddit/services/PostServiceImplTest.java)         | The code is a JUnit test for a Post Service in a Java Spring Boot application, which includes methods to create and retrieve posts. The tests cover scenarios like a successful post creation, a post creation failure due to user not found, retrieving all posts when posts exist, and retrieving posts when there are no posts. The tests use mock objects and Mockito library to simulate behaviour of dependencies such as repositories.                                                                                      |
| [AuthService.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/services/AuthService.java)                         | The provided Java code defines an interface for an AuthService in a Cheddit clone project. The AuthService interface provides two methods: `registerUser`, which accepts a RegisterRequest object and returns a CompletableFuture enclosing an AuthenticationResponse; and `loginUser`, which accepts a LoginRequest object and also returns a CompletableFuture encompassing an AuthenticationResponse. Both operations are meant to be utilized for authenticating users in a non-blocking, asynchronous manner.                 |
| [PostServiceImpl.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/services/PostServiceImpl.java)                 | The code is part of a'Cheddit-clone' project, structured with front-end and Java backend. Specifically, this'PostServiceImpl.java' class implements the PostService interface, with two core functions: creating new posts and retrieving all posts from a repository. New post creation includes user validation through an access token. If the user doesn't exist, it throws a'UserNotFoundException'. Asynchronous execution is enabled for the post creation method.                                                          |
| [PasswordAuthService.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/services/PasswordAuthService.java)         | The code forms a service interface in a backend of a'Cheddit-clone' application, composed of methods for password and JWT token management. It includes methods for hashing a password, generating a JWT token for a new user, validating a password against another, and extracting a user from a given JWT token. The service primarily aids in user authentication and authorization.                                                                                                                                           |
| [AuthServiceImpl.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/services/AuthServiceImpl.java)                 | The Java Code includes `AuthServiceImpl` class which provides asynchronous user authentication services for a Reddit-like application. The two core functionalities are `registerUser` and `loginUser`. `registerUser` validates inputs, checks if the user already exists, hashes the entered password, creates the user in the database and returns a JWT token. `loginUser` checks if the entered user credentials are valid, generates a JWT token if they are, and returns it. Exceptions are thrown for erroneous scenarios. |
| [PostService.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/services/PostService.java)                         | The provided code is a part of a'Reddit clone' project, structured with a separate frontend and backend. In the backend, a Java interface,'PostService', is declared in the'services' folder. This interface proposes two methods:'createNewPost' for submitting a new post using'NewPostRequest', and'getAllPosts' for retrieving all the existing posts. The frontend seems to be a React application, as suggested by the presence of files like App.js and index.js.                                                           |
| [PasswordAuthServiceImpl.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/services/PasswordAuthServiceImpl.java) | The code is a service layer in a Java Spring-boot application for password-based authorization. It provides functionalities for hashing a password, generating a JSON Web Token (JWT) for a user, validating hashed passwords, and extracting a username from a given JWT. Exception handling is incorporated to handle failures in parsing the JWT.                                                                                                                                                                               |

</details>

<details closed><summary>Jbehavetests</summary>

| File                                                                                                                                                             | Summary                                                                                                                                                                                                                                                                                                                                                                                                      |
| ---                                                                                                                                                              | ---                                                                                                                                                                                                                                                                                                                                                                                                          |
| [story.story](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/test/java/com/pranay/cheddit/cheddit/jbehaveTests/story.story)           | The code is for a user story in Behavior Driven Development (BDD) that tests the registration feature of a ‘Cheddit’ application. It covers a scenario where a new user, with valid details, successfully registers an account, ensuring the functionality of the registration form in the application is working as expected.                                                                               |
| [signupStory.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/test/java/com/pranay/cheddit/cheddit/jbehaveTests/signupStory.java) | The provided Java code is a JBehave test class for a signup feature of "Cheddit", a clone website. It uses a story-based approach to run the SignupSteps functions with JUnitStory. It provides a configuration to load the story tester from its classpath. Test results are reported in TXT format and on the console. Steps for the test scenarios are injected through an instance of SignupSteps class. |

</details>

<details closed><summary>Stories</summary>

| File                                                                                                                                                             | Summary                                                                                                                                                                                                                                                                                                                                                                                                                 |
| ---                                                                                                                                                              | ---                                                                                                                                                                                                                                                                                                                                                                                                                     |
| [signup.story](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/test/java/com/pranay/cheddit/cheddit/jbehaveTests/stories/signup.story) | This code is a part of a Java-based testing suite for a Reddit-like application, focusing on user registration functionality. It contains narratives and scenarios which validate successful registration, handling existing usernames, and password mismatches. The tests ensure that users can register successfully, existing usernames are appropriately managed, and password mismatches are correctly identified. |

</details>

<details closed><summary>Steps</summary>

| File                                                                                                                                                                   | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| ---                                                                                                                                                                    | ---                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| [SignupSteps.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/test/java/com/pranay/cheddit/cheddit/jbehaveTests/steps/SignupSteps.java) | The provided Java code is a set of JBehave test steps for the user registration process in a Cheddit clone application backend. It tests three scenarios: registering a new user with valid details, attempting registration with an existing username, and attempting registration with mismatched passwords. It issues HTTP requests to the registration endpoint and asserts correctness based on the HTTP response codes and body messages. |

</details>

<details closed><summary>Models</summary>

| File                                                                                                                                         | Summary                                                                                                                                                                                                                                                                                                                                                                                                                             |
| ---                                                                                                                                          | ---                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [User.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/models/User.java) | The given Java code defines a User model in a Spring-based backend application for a Cheddit Clone project. Fields include ID, username, email, password, createdAt, and updatedAt. Lombok library annotations are used for simplifying code and Jakartas for validation rules. The User model is mapped to MongoDB and an additional constructor is defined for creating new User objects with a hashed password.                  |
| [Post.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/models/Post.java) | The code provided is a Java model class for a'Post' in a Reddit-like platform called'Cheddit'. Fields include'id','user','postText','taggedUsername','createdAt', and'updatedAt', with'id' being the primary key. The'Post' class leverages Lombok library for boilerplate code reduction and uses Spring Data annotations for MongoDB integration.'CreatedDate' and'LastModifiedDate' annotations manage timing details for posts. |

</details>

<details closed><summary>Repositories</summary>

| File                                                                                                                                                                   | Summary                                                                                                                                                                                                                                                                                                                                                                                                                      |
| ---                                                                                                                                                                    | ---                                                                                                                                                                                                                                                                                                                                                                                                                          |
| [UserRepository.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/repositories/UserRepository.java) | The provided Java code defines a'UserRepository' interface extending'MongoRepository'. This interface is part of a backend for a Cheddit-clone app. It includes methods to query MongoDB for a'User' based on'username' or'email'. The directory structure also indicates the app includes frontend components, tests, and configuration.                                                                                    |
| [PostRepository.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/repositories/PostRepository.java) | The provided code is from a Java backend of an application modeled after Cheddit, more specifically, a repository interface for handling posts Using Spring Data MongoDB for easy data access and manipulation. The PostRepository interface extends MongoRepository, allowing for MongoDB CRUD operations on'Post' objects, identified by a String ID. The application also contains frontend elements in JavaScript/React. |

</details>

<details closed><summary>Dto</summary>

| File                                                                                                                                                                          | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| ---                                                                                                                                                                           | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| [AuthenticationResponse.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/dto/AuthenticationResponse.java) | The project structure illustrates a Reddit clone application, named Cheddit, with separate frontend and backend directories. The backend appears to be a Java Maven project. The provided Java code is a Data Transfer Object for the Authentication Response, built using Lombok annotations for automated boilerplate code generation. The class holds two key properties: token and username, which could be utilized for user validation and identification during run-time.     |
| [RegisterRequest.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/dto/RegisterRequest.java)               | The provided Java code defines a class `RegisterRequest` with fields: `username`, `email`, `password`, and `confirmPassword`. The class is part of the backend module for a'Cheddit' clone project. It includes several validation constraints, such as specific size ranges for username and password, an email validity check, and non-blank requirements for all fields. It's used to handle user registration requests, ensuring all inputs meet the defined constraints.        |
| [LoginRequest.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/dto/LoginRequest.java)                     | The provided code represents a LoginRequest Java class from the backend of a Cheddit Clone application. This class contains two private properties: email and password, with validation constraints for ensuring both are not blank, and in the email's case, is a valid format. The class utilizes Lombok annotations to automatically implement commonly used methods and constructors. This class is used as a Data Transfer Object (DTO) for handling login requests from users. |
| [NewPostRequest.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/dto/NewPostRequest.java)                 | The code defines a'NewPostRequest' Java class in the'cheddit' application backend. This class represents a request to create a new post, with properties'postText' (required and should not be blank) for text content, and'accessToken' (also required) to verify the logged-in user. Usage of Jakarta validation constraints ensures data integrity, and Lombok annotations simplify boilerplate code for constructors and getters/setters.                                        |

</details>

<details closed><summary>Exceptions</summary>

| File                                                                                                                                                                                             | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| ---                                                                                                                                                                                              | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| [PasswordsDoNotMatchException.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/exceptions/PasswordsDoNotMatchException.java) | The provided code depicts a structure for a Cheddit clone project with backend in Java (using Maven for dependencies) and frontend in JavaScript (likely React). Specific Java code defines a custom runtime exception,'PasswordsDoNotMatchException', used for handling situations when user passwords do not match, significantly improving error reporting and handling within the application.                                                                         |
| [UserAlreadyExistsException.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/exceptions/UserAlreadyExistsException.java)     | The code is a custom exception for a Java-based backend of a'Cheddit' clone application. It defines an exception named'UserAlreadyExistsException,' extending'RuntimeException.' This exception is likely thrown when attempting to register a user who already exists in the system. The exception constructor accepts a custom error message.                                                                                                                            |
| [GlobalExceptionHandler.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/exceptions/GlobalExceptionHandler.java)             | The provided code, from a project named Cheddit-clone, is a GlobalExceptionHandler in Java/Spring handling different exceptions for HTTP requests. It is designed to capture and handle several specific exceptions including MethodArgumentNotValidException, UserAlreadyExistException, PasswordDoNotMatchException, UserNotFoundException, and RuntimeException. The handler returns a detailed, relevant error message embedded inside a BadRequest (400) HTTP status. |
| [JWTParsingException.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/exceptions/JWTParsingException.java)                   | The provided Java code defines a custom exception, `JWTParsingException`, which extends the `RuntimeException` class. This exception is likely thrown when there's a problem parsing JSON Web Tokens (JWT) in the'Cheddit' application. The constructor accepts an error message as a parameter which is passed to the superclass for final error reporting.                                                                                                               |
| [UserNotFoundException.java](https://github.com/Pranay-a-1/cheddit-clone/blob/main/Backend/cheddit/src/main/java/com/pranay/cheddit/cheddit/exceptions/UserNotFoundException.java)               | The given code defines a custom exception named'UserNotFoundException' in a clone of a Reddit-like application named'Cheddit.' This exception is thrown when a user-related error occurs, such as when a user isn't found in the system. Based on its location in the Backend directory, it's clear this exception relates to server-side operations.                                                                                                                      |

</details>

<details closed><summary>Frontend</summary>

| File                                                                                                  | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| ---                                                                                                   | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| [package-lock.json](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/package-lock.json) | The code provided represents the directory structure and part of the package-lock.json file of a project named "Cheddit-Clone". The backend, likely a Java project, uses Maven for build automation (shown by.mvn, mvnw files). The frontend uses React (indicated by react packages in the package-lock.json). The frontend is also set up for testing, as indicated by testing-library packages, and it uses other packages for UI/UX enhancements, HTTP requests (axios), and date manipulation (moment). |
| [package.json](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/package.json)           | The code shows a directory structure for a project'cheddit-clone'. The project splits into a frontend and backend. The frontend build with React, has scripts for starting, testing, and building the project, and dependencies includes libraries for UI design, API requests, and testing. The backend directory contains a '.mvn' file, indicating a Maven project.'Package.json' file indicates use of packages for react development, HTTP requests, date manipulation, and testing utilities.          |

</details>

<details closed><summary>Public</summary>

| File                                                                                                 | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| ---                                                                                                  | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| [index.html](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/public/index.html)       | The given directory structure and HTML file pertain to a project named'cheddit-clone', structured with separate FrontEnd and Backend directories. The HTML file resides in the FrontEnd'public' directory and acts as a template for the React application. Metadata is provided for mobile and desktop installations. The'%PUBLIC_URL%' placeholders will be replaced with the'public' directory URL during the build process. A development server can be started, or a production bundle can be created using NPM or Yarn commands. |
| [manifest.json](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/public/manifest.json) | The directory tree represents a'Cheddit-Clone' application, divided into a frontend built with ReactJS and a backend developed using Spring Boot (Java). The manifest.json in the frontend public directory outlines the key web app properties, including application name, icons for varying resolutions, start URL, display setting, and theme/background colors. These properties dictate how the application is presented to the user, especially on mobile devices.                                                              |
| [robots.txt](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/public/robots.txt)       | The provided code denotes a directory structure for a'Cheddit-Clone' application with front-end and back-end elements. The back-end infrastructure uses Maven for handling project dependencies. The front-end framework is organized with specific JavaScript components and configurations, including an `App.js`, `api`, and `hooks` directory. The'robots.txt' file in the public directory allows all bots, denoted by'*', unrestricted access to crawl the application's publicly accessible areas.                              |

</details>

<details closed><summary>Src</summary>

| File                                                                                              | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| ---                                                                                               | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| [index.js](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/index.js)           | The provided code directory tree signifies a "Cheddit-clone" application with separate Backend (Java) and FrontEnd (ReactJS) components. The detailed code snippet indicates the initiation of the React app. It imports'App.js' component and the Bootstrap CSS library, then renders the'App' component in the root node. The commented part provides an option for measuring app performance using custom logging or analytics methods.                            |
| [App.js](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/App.js)               | This code outlines the main structure of a React application that comprises of a user signup, login, home and new post page. It utilizes React hooks for login state management and React-router-dom for managing routes. These routes are enclosed within a Bootstrap container. Each page route is linked to a different component, controlling page navigation within the application. The login data and status are passed as props to the respective components. |
| [setupTests.js](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/setupTests.js) | This directory structure represents a Cheddit clone application, divided into frontend and backend. The frontend uses packages detailed in package.json, with primary application logic in App.js and tests setup in setupTests.js. The backend is structured as a Maven project, with source code residing in the src directory. The setupTests.js file imports and uses jest-dom for improved asserting on DOM nodes in Jest tests.                                 |

</details>

<details closed><summary>Header</summary>

| File                                                                                                                      | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| ---                                                                                                                       | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| [Header.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/components/Header/Header.jsx)             | The code is a component of the Cheddit Clone application that outputs the header. This header contains navigation links and switches on account of the user's login status. For anonymous users, it shows'Login' and'Signup' buttons. For logged-in users, it additionally offers'NewPost','Welcome', and'Logout' buttons tied to the logged-in user's data. The header is stylized using React-Bootstrap's'Navbar','Nav', and'Container' components. |
| [HeaderButton.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/components/Header/HeaderButton.jsx) | The provided JavaScript code defines five react components representing buttons for a webpage's header section. These buttons, namely'Login','Signup','New Post','Welcome' (displays a username), and'Logout', are rendered with respective icons. These components are linked to specific routes via'NavLink' from'react-router-dom' for navigational purposes. The button components are exported for use in other parts of the application.        |

</details>

<details closed><summary>Post</summary>

| File                                                                                                    | Summary                                                                                                                                                                                                                                                                                                                                                |
| ---                                                                                                     | ---                                                                                                                                                                                                                                                                                                                                                    |
| [Post.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/components/Post/Post.jsx) | The provided code is a React functional component named'Post'. It takes a'post' object as a property and displays it in a formatted way using Bootstrap's'Row' and'Card' components. The post detail includes user's first name, last name, username, post creation time (formatted to show relative time using'moment.js'), and the actual post text. |

</details>

<details closed><summary>Componenttests</summary>

| File                                                                                                                      | Summary                                                                                                                                                                                                                                                                                                                                                                                |
| ---                                                                                                                       | ---                                                                                                                                                                                                                                                                                                                                                                                    |
| [Post.test.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/test/componentTests/Post.test.jsx)     | The given code represents a unit test for the Post component in a Cheddit clone web application. The test uses a mock post data with specific user and post details to ensure the Post component renders correctly. It verifies the presence of user name, user's handle, post text, and the post's date on the screen after the Post component is rendered.                           |
| [Header.test.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/test/componentTests/Header.test.jsx) | The code consists of a series of tests for the Header component in a'Cheddit' application. It verifies the correct display of the Header, Login and Signup links for non-logged-in users, as well as the absence of New Post, Welcome, and Logout buttons. Conversely, it checks that the latter three are present and the Login and Signup links are absent when a user is logged in. |

</details>

<details closed><summary>Apptests</summary>

| File                                                                                                              | Summary                                                                                                                                                                                                                                                                                                                                                                   |
| ---                                                                                                               | ---                                                                                                                                                                                                                                                                                                                                                                       |
| [App.test.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/test/AppTests/App.test.jsx)     | This code from a'Cheddit' clone project sets up a unit test for the front-end App component. It uses the testing-library/react utilities to render the App, and it checks if the'Cheddit' header is present in the document. Additionally, it mocks the'axios' HTTP client's post function to isolate this component for testing purposes.                                |
| [index.test.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/test/AppTests/index.test.jsx) | This code is a unit test for testing the root rendering functionality of a React application. Specifically, it tests if ReactDOM's createRoot() method is called with the correct element. The test mocks ReactDOM.createRoot, appends a div element with id as root to the document body and requires the index.js file. It then checks if the mocked method was called. |

</details>

<details closed><summary>Pagetests</summary>

| File                                                                                                                   | Summary                                                                                                                                                                                                                                                                                                                                                 |
| ---                                                                                                                    | ---                                                                                                                                                                                                                                                                                                                                                     |
| [login.test.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/test/pageTests/login.test.jsx)     | The provided code is a series of tests for a Login component in a Cheddit-clone project. Specifically, the tests verify that the login page, the sign-in button, email, and password input fields are properly rendered on the Login page. The tests are written using the React Testing Library and Jest.                                              |
| [NewPage.test.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/test/pageTests/NewPage.test.jsx) | The provided code is a unit test for the'NewPost' component in a Reddit clone application. It utilizes the React Testing Library to examine if the'New Post' page renders successfully with a'Submit' button and a body field for user input. It checks that these elements are present in the document after the rendering of the'New Post' component. |
| [signUp.test.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/test/pageTests/signUp.test.jsx)   | The code is a group of test cases for a sign-up page component in a web application. Using the Jest and React Testing Library, it checks the page's proper rendering and verifies the presence of username, email, and password input fields. It mocks API requests using a mocked'axios' library.                                                      |

</details>

<details closed><summary>Hooktests</summary>

| File                                                                                                                                   | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| ---                                                                                                                                    | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| [useLoginHooks.test.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/test/hookTests/useLoginHooks.test.jsx)     | The code runs unit tests for a login functionality in a React application. It mocks an authentication API and checks if it properly handles successful and unsuccessful login attempts, testing user input, and the responses received-either a successful login or an alert for a failed attempt. It also tests how the app alters some global storage items upon login actions.                                                                          |
| [useNewPostHooks.test.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/test/hookTests/useNewPostHooks.test.jsx) | The code is a testing suite for the NewPost component in a Reddit-like application. It tests post submission functionality, which includes checking whether valid and invalid submissions work as intended. Specifically, it tests if a valid post triggers the `createNewPost` API call with appropriate data, and if an invalid post triggers a console.error. This is implemented using mock functions to simulate API responses.                       |
| [useSignUpHooks.test.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/test/hookTests/useSignUpHooks.test.jsx)   | The provided code includes tests for a signup functionality in a web app. These tests check for both successful and unsuccessful user signups, ensuring that an alert is displayed with a corresponding message. Also, it confirms that the signup method from the'authApi' is called with the correct user details. Rendering, user event simulations, and calls to the API are done using utilities from'react-testing-library' and jest mock functions. |

</details>

<details closed><summary>Pages</summary>

| File                                                                                                | Summary                                                                                                                                                                                                                                                                                                                                                                                                                      |
| ---                                                                                                 | ---                                                                                                                                                                                                                                                                                                                                                                                                                          |
| [NewPost.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/pages/NewPost.jsx) | The NewPost.jsx code in the FrontEnd of a Cheddit clone provides the functionality to create a new post. Using the'react-router-dom' and'axios' libraries, it provides users an interface to input a new post text, which triggers a handleSubmit event that feeds into custom standalone'useNewPostHooks'. The new post submission is then either redirected to the home'/' page or remains on the current page.            |
| [Home.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/pages/Home.jsx)       | The'Home.jsx' file, part of the frontend of a Clone Cheddit application, utilizes React hooks to import and display all posts. On page loading, it initiates an API call to fetch all posts which are then sorted by creation date using the `useState` and `useEffect` hooks. The sorted posts are stored in `postsArray` and mapped into the `Post` component for display.                                                 |
| [Login.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/pages/Login.jsx)     | The `Login` component in the code manages user authentication for a web application. It captures the user's email and password, handling changes through the `useLoginHooks` custom hook. If a user is already logged in, it redirects to the homepage. It also sets user login status and data upon successful login. The interface uses a Bootstrap-themed card to operate the login form, complete with a Sign In button. |
| [SignUp.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/pages/SignUp.jsx)   | The provided code is a part of a React.js frontend application, specifically the SignUp component. This component presents a registration form with fields for email, username, and password confirmation. User input is handled by'useSignUpHooks'. Upon successful registration, it provides a link to the login page, or the user can choose to navigate to the login page if they already have an account.               |

</details>

<details closed><summary>Hooks</summary>

| File                                                                                                                | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| ---                                                                                                                 | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [useLoginHooks.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/hooks/useLoginHooks.jsx)     | The provided code is a custom React hook, `useLoginHooks`, designed to manage the state and behaviour of a login form. It keeps track of an email and a password through a `useState` Hook. It provides a `handleChange` function to update these values and a `handleSubmit` function to manage the login process using an API call. In case of successful login, it updates the login status and user data, and handles different types of error scenarios as well.                                                                               |
| [useNewPostHooks.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/hooks/useNewPostHooks.jsx) | The "useNewPostHooks.jsx" file defines a custom React hook "useNewPostHooks" that is used to create a new post. It manages post information state, handles post data changes, and performs post submission by making an API call using axios. It also handles navigation upon successful post creation. The hook returns the post values, change-handler, submit-handler, and a boolean flag indicating if the post creation succeeded. Errors in post creation are managed and communicated. Token from local storage is used for authorization.   |
| [useSignUpHooks.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/hooks/useSignUpHooks.jsx)   | The provided code defines'useSignUpHooks', a React hook used for handling the sign-up process in a web application. The hook manages the state of user's input via'values', the sign-up success state, and relevant event handlers.'handleChange' updates input values,'handleSubmit' submits the sign-up form (makes API call for sign-up, provides appropriate feedback, handles possible errors), and'onSuccessRegister' alerts the success of the sign-up operation. The hook returns these states and functions for use in sign-up components. |

</details>

<details closed><summary>Config</summary>

| File                                                                                                   | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| ---                                                                                                    | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| [apiConfig.js](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/config/apiConfig.js) | The given code snippet is for setting the base URL for API calls in a web application. The application is structured with a frontend and backend directory. The backend is a Java application built with Maven and the frontend is a JavaScript application, possibly React, with structure for different functionalities such as API calls, components, configs, and pages. The base URL is set to interact with a service running locally at port 7001. |

</details>

<details closed><summary>Api</summary>

| File                                                                                              | Summary                                                                                                                                                                                                                                                                                                                                                                                                          |
| ---                                                                                               | ---                                                                                                                                                                                                                                                                                                                                                                                                              |
| [authApi.jsx](https://github.com/Pranay-a-1/cheddit-clone/blob/main/FrontEnd/src/api/authApi.jsx) | The provided code is responsible for sending API requests in a Cheddit clone application. It employs Axios to make HTTP requests to the backend, including user registration and login functions, post creation, and retrieval of all posts. It also employs JWT for authorization in the HTTP headers when fetching all posts. The base URL for all APIs is referenced from a config file, ensuring modularity. |

</details> -->

---

## 🚀 Getting Started



### 🔧 Installation

1. Clone the cheddit-clone repository:
```sh
git clone https://github.com/Pranay-a-1/cheddit-clone
```

2. Change to the project directory:
```sh
cd cheddit-clone/Backend/cheddit
```

3. Install the dependencies:
```sh
mvn clean install
```

### 🤖 Running cheddit-clone

```sh
mvn spring-boot:run
```

### 🧪 Tests
```sh
mvn test
```

---


---


[**Return**](#Top)

---

