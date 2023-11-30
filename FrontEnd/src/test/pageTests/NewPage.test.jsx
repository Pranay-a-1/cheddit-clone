import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import NewPost from '../../pages/NewPost';


describe('New Post Tests', () => {



    const setup = () => render(<NewPost />, { wrapper: BrowserRouter });

    it('should render the New Post page', async () => {
        setup();
        const newPostButton = await screen.findByRole('button', { name: /Submit/i });
        expect(newPostButton).toBeInTheDocument();
    })

    
    it('should render a body input', () => {
        setup();
        const bodyField = screen.getByPlaceholderText('Leave a post here');
        expect(bodyField).toBeInTheDocument();
    })
}); 
