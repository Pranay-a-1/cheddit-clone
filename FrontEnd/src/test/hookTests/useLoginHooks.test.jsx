import { render, fireEvent, screen, waitFor, act } from '@testing-library/react';
import { login } from '../../api/authApi'; 
import { BrowserRouter} from 'react-router-dom';

import Login from '../../pages/Login';

jest.mock('../../api/authApi'); 

describe('useLoginHooks Tests', () => {

    beforeEach(() => {
        global.alert = jest.fn();
        Storage.prototype.setItem = jest.fn();

    });

    it('should handle successful login', async () => {
        const user = { email: 'test@example.com', password: 'password123' };

        login.mockResolvedValueOnce({});

        const setup = () => render(<Login />, { wrapper: BrowserRouter });

        await setup();

        fireEvent.change(screen.getByPlaceholderText('Enter email'), { target: { value: user.email } });
        fireEvent.change(screen.getByPlaceholderText('Password'), { target: { value: user.password } });

        fireEvent.click(screen.getByText('Sign In'));

        await waitFor(() => expect(login).toHaveBeenCalledWith(user));
    });

    it('should handle unsuccessful login', async () => {
        const user = { email: 'test@example.com', password: 'password123' };

        login.mockRejectedValueOnce({ response: { data: 'Error Message' } });

        const setup = () => render(<Login />, { wrapper: BrowserRouter });

        await setup();

        fireEvent.change(screen.getByPlaceholderText('Enter email'), { target: { value: user.email } });
        fireEvent.change(screen.getByPlaceholderText('Password'), { target: { value: user.password } });


        fireEvent.click(screen.getByText('Sign In'));

        await waitFor(() => expect(global.alert).toHaveBeenCalledWith('Error Message'));

    });


});