import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Container } from 'react-bootstrap';
import Header from "./components/Header/Header";
import React, { useState } from 'react';
import Signup from "./pages/SignUp";


function App() {
  
  const [loggedInUserData, setLoggedInUserData] = useState(undefined);

  return (
    <>
      <Container fluid="md">
        <BrowserRouter>
          <Header loggedInUserData={loggedInUserData}/>
          <Routes>
            <Route path="/signup" element={<Signup />} />
          </Routes>
        </BrowserRouter>
      </Container>
    </>
  );
}

export default App;