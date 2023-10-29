import { FaSignInAlt, FaSignOutAlt, FaUser, } from 'react-icons/fa'
import { Navbar, Nav, Container, Row, Col, Button } from 'react-bootstrap';
import { IoCreateSharp } from "react-icons/io5";
import { NavLink } from 'react-router-dom';
import { LoginButton, SignupButton, NewPeepButton, WelcomeButton, LogoutButton } from './HeaderButtons';  

const Header = ({ loggedInUserData, setLogInStatus }) => {
  return (
    <>
          <Navbar bg="light" variant="light">
              <Container>
                  <Navbar.Brand><NavLink to="/">Cheddit </NavLink></Navbar.Brand>
                  <Nav>
                    {!loggedInUserData && <LoginButton />}
                    {!loggedInUserData && <SignupButton />}
                    {loggedInUserData && <NewPeepButton />}
                    {loggedInUserData && <WelcomeButton username={loggedInUserData.username} />}
                    {loggedInUserData && <LogoutButton />}
                  </Nav>
              </Container>
          </Navbar>
      </>
  );
};

export default Header;