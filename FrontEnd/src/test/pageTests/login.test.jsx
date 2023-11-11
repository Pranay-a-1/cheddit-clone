import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import Login from '../../pages/Login';


describe('Login Tests', () => {

    const setup = () => render(<Login />, { wrapper: BrowserRouter });

    it('should render the login page', async () => {
        setup();
        const signInButton = await screen.findByRole('button', { name: /Sign In/i });
        expect(signInButton).toBeInTheDocument();
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