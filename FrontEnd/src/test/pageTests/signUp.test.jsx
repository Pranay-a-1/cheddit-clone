import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import SignUp from '../../pages/SignUp';

jest.mock("axios", () => ({
    ...jest.requireActual("axios"),
    post: jest.fn(),
}));


describe('Sign Up Tests', () => {

    const setup = () => render(<SignUp />, { wrapper: BrowserRouter });

    it('should render the sign up page', () => {
        setup();
        const signUpText = screen.getByText(/Register/i);
        expect(signUpText).toBeInTheDocument();
    })

    it('should render a username input', () => {
        setup();
        const usernameInput = screen.getByPlaceholderText('Username');
        expect(usernameInput).toBeInTheDocument();
    })

    it('should render a email input', () => {
        setup();
        const emailField = screen.getByRole('textbox', { name: /email address/i });
        expect(emailField).toBeInTheDocument();
    })

    it('should render a password input', () => {
        setup();
        const passwordField = screen.getByPlaceholderText('Password');
        expect(passwordField).toBeInTheDocument();
    })


});