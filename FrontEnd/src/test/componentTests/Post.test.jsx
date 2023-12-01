import { render, screen } from '@testing-library/react';
import Post from '../../components/Post/Post';
import moment from 'moment';


describe('Post Tests', () => {

   it('should render Post component with correct data', () => {
        const mockPost = {
        user: {
            firstName: 'John',
            lastName: 'Doe',
            username: 'johndoe',
        },
        postText: 'This is a test post',
        createdAt: new Date(),
        };

        render(<Post post={mockPost} />);

        const nameElement = screen.getByText(/John Doe/i);
        expect(nameElement).toBeInTheDocument();

        const usernameElement = screen.getByText(/@johndoe/i);
        expect(usernameElement).toBeInTheDocument();

        const postTextElement = screen.getByText(/This is a test post/i);
        expect(postTextElement).toBeInTheDocument();

        const dateElement = screen.getByText(new RegExp(moment(mockPost.createdAt).fromNow(), 'i'));
        expect(dateElement).toBeInTheDocument();     
    });           
});