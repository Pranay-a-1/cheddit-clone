import { BrowserRouter } from "react-router-dom";
import { Container } from 'react-bootstrap';
import Header from "./components/Header/Header";
import React, { useState } from 'react';


function App() {
  
  const [loggedInUserData, setLoggedInUserData] = useState(undefined);

  return (
    <>
      <Container fluid="md">
        <BrowserRouter>
        <Header loggedInUserData={loggedInUserData}/>
        </BrowserRouter>
      </Container>
    </>
  );
}

export default App;
