import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Container } from 'react-bootstrap';
import Header from "./components/Header/Header";
import React, { useState } from 'react';
import Signup from "./pages/SignUp";
import Login from "./pages/Login";
import Home from "./pages/Home";
import NewPost from "./pages/NewPost";


function App() {
  
  const [loggedInUserData, setLoggedInUserData] = useState(undefined);
  const [loginStatus, setLogInStatus] = useState(false);


  return (
    <>
      <Container fluid="md">
        <BrowserRouter>
          <Header loggedInUserData={loggedInUserData}/>
          <Routes>
          <Route path="/signup" element={<Signup />} />
          <Route path="/new-post" element={<NewPost />} />
          <Route path="/login" element={<Login setLogInStatus={setLogInStatus} loginStatus={loginStatus} setLoggedInUserData={setLoggedInUserData} />} />
          <Route path="/" element={<Home />} />

          </Routes>
        </BrowserRouter>
      </Container>
    </>
  );
}

export default App;