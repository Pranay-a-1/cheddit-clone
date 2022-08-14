import { render, screen } from '@testing-library/react';
import LogIn from '../components/LogIn';

describe('LogIn.jsx tests', () => {
    it('should render LogIn component', () => {
        render(<LogIn />)
    })

    it('should have sign in button', () => {
        render(<LogIn />);
        const buttonText = screen.getAllByRole('button');
        expect(buttonText).toContain('Sign In');
    })
})