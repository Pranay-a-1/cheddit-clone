import { render, fireEvent, screen, waitFor } from '@testing-library/react';
import { signUp } from '../../api/authApi'; 
import { BrowserRouter} from 'react-router-dom';

import SignUp from '../../pages/SignUp';

jest.mock('../../api/authApi'); 

describe('useSignUpHooks Tests', () => {
    beforeEach(() => {
        global.alert = jest.fn();
    });

    it('should handle successful sign up', async () => {
        signUp.mockResolvedValueOnce({});

        const setup = () => render(<SignUp />, { wrapper: BrowserRouter });

        await setup();

        fireEvent.change(screen.getByPlaceholderText('Username'), { target: { value: 'testUser' } });
        fireEvent.change(screen.getByPlaceholderText('Enter email'), { target: { value: 'test@example.com' } });
        fireEvent.change(screen.getByPlaceholderText('Password'), { target: { value: 'password123' } });
        fireEvent.change(screen.getByPlaceholderText('Confirm Password'), { target: { value: 'password123' } });

        fireEvent.click(screen.getByText('Submit'));

        await waitFor(() => expect(global.alert).toHaveBeenCalledWith('SignUp successful, please login'));
    });

    it('should call signUp from authApi with correct parameters', async () => {
        const userData = { 
            username: 'testUser', 
            email: 'test@example.com', 
            password: 'password123',
            confirmPassword: 'password123' 
        };
    
        const setup = () => render(<SignUp />, { wrapper: BrowserRouter });
    
        await setup();
    
        fireEvent.change(screen.getByPlaceholderText('Username'), { target: { value: 'testUser' } });
        fireEvent.change(screen.getByPlaceholderText('Enter email'), { target: { value: 'test@example.com' } });
        fireEvent.change(screen.getByPlaceholderText('Password'), { target: { value: 'password123' } });
        fireEvent.change(screen.getByPlaceholderText('Confirm Password'), { target: { value: 'password123' } });
    
        fireEvent.click(screen.getByText('Submit'));
    
        expect(signUp).toHaveBeenCalledWith(userData);
    });


    it('should handle unsuccessful sign up', async () => {
        signUp.mockRejectedValueOnce({ response: { data: 'Error Message' } });

        const setup = () => render(<SignUp />, { wrapper: BrowserRouter });

        await setup();

        fireEvent.change(screen.getByPlaceholderText('Username'), { target: { value: 'testUser' } });
        fireEvent.change(screen.getByPlaceholderText('Enter email'), { target: { value: 'test@example.com' } });
        fireEvent.change(screen.getByPlaceholderText('Password'), { target: { value: 'password123' } });
        fireEvent.change(screen.getByPlaceholderText('Confirm Password'), { target: { value: 'password123' } });

        fireEvent.click(screen.getByText('Submit'));

        await waitFor(() => expect(global.alert).toHaveBeenCalledWith('Error Message'));

    });
        
});