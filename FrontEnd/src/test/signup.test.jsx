import { render, screen } from '@testing-library/react';
import SignUp from '../components/SignUp';

describe('SignUp.jsx tests', () => {
    it('should render LogIn component', () => {
        render(<SignUp />)
    })

    it('should have sign in button', () => {
        render(<SignUp />);
        const buttonText = screen.getAllByRole('button');
        expect(buttonText).toContain(screen.getByRole('button', { name: /register/i }));
    })
})