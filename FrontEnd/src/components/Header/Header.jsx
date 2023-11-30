import { Navbar, Nav, Container } from 'react-bootstrap';
import { NavLink } from 'react-router-dom';
import { LoginButton, SignupButton, NewPostButton, WelcomeButton, LogoutButton } from '../Header/HeaderButton';

const Header = ({ loggedInUserData, setLogInStatus }) => {
  return (
    <>
          <Navbar bg="light" variant="light">
              <Container>
                  <Navbar.Brand><NavLink to="/">Cheddit </NavLink></Navbar.Brand>
                  <Nav>
                    {!loggedInUserData && <LoginButton />}
                    {!loggedInUserData && <SignupButton />}
                    {loggedInUserData && <NewPostButton />}
                    {loggedInUserData && <WelcomeButton username={loggedInUserData.username} />}
                    {loggedInUserData && <LogoutButton />}
                  </Nav>
              </Container>
          </Navbar>
      </>
  );
};

export default Header;