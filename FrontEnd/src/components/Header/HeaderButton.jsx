import { FaSignInAlt, FaSignOutAlt, FaUser, } from 'react-icons/fa'
import { Button } from 'react-bootstrap';
import { IoCreateSharp } from "react-icons/io5";
import { NavLink } from 'react-router-dom';

const LoginButton = () => (
    <NavLink to="/login">
      <FaSignInAlt /> Login
    </NavLink>
  );

const SignupButton = () => (
    <NavLink to="/signup">
      <FaUser /> Signup
    </NavLink>
  );

const NewPostButton = () => (
    <NavLink to="/new-post">
      <IoCreateSharp />New Post
    </NavLink>
  );

const WelcomeButton = ({ username }) => (
    <Button variant='light'>
      <FaUser /> Welcome {username}
    </Button>
  );

const LogoutButton = () => (
    <Button variant='light'>
      <FaSignOutAlt /> Logout
    </Button>
  );


export { LoginButton, SignupButton, NewPostButton, WelcomeButton, LogoutButton };