import { render, fireEvent, screen, waitFor } from '@testing-library/react';
import { signUp } from '../../api/authApi'; 
import { BrowserRouter} from 'react-router-dom';
import {createNewPost} from '../../api/authApi';

import NewPost from '../../pages/NewPost';

jest.mock('../../api/authApi'); 

describe('useNewPostHooks Tests', () => {


    it('should handle successful new post', async () => {
        createNewPost.mockResolvedValueOnce({});

        const setup = () => render(<NewPost />, { wrapper: BrowserRouter });

        await setup();

        fireEvent.change(screen.getByPlaceholderText('Leave a post here'), { target: { value: 'testPost' } });

        fireEvent.click(screen.getByText('Submit'));

        await waitFor(() => expect(createNewPost).toHaveBeenCalledWith({"accessToken": "Bearer null", "postText": "testPost"}));


    });

    it('should handle unsuccessful new post', async () => {
        createNewPost.mockRejectedValueOnce({ response: { data: 'Error Message' } });

        const setup = () => render(<NewPost />, { wrapper: BrowserRouter });

        await setup();

        fireEvent.change(screen.getByPlaceholderText('Leave a post here'), { target: { value: 'testPost' } });

        // Mock console.error
        console.error = jest.fn();

        fireEvent.click(screen.getByText('Submit'));

        //error response in console.log
        await waitFor(() => expect(console.error).toHaveBeenCalled());

    });




});