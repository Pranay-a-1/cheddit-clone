import { render, screen} from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import Header from '../../components/Header/Header';

describe ('Header Tests', () => {


    const setup = () => render(<Header />, { wrapper: BrowserRouter });

    it('should render the header', () => {
        setup();
        const header = screen.getByText(/Cheddit/i);
        expect(header).toBeInTheDocument();
    })

    it('should render Login and Signup links when user is not logged in', () => {
        const loggedInUserData = false;
        render(<Header loggedInUserData={loggedInUserData} />, { wrapper: BrowserRouter });
        expect(screen.getByText(/Login/i)).toBeInTheDocument();
        expect(screen.getByText(/Signup/i)).toBeInTheDocument();
    });

    it('should not render New Peep, Welcome, and Logout buttons when user is not logged in', () => {
    const loggedInUserData = false;
    render(<Header loggedInUserData={loggedInUserData} />, { wrapper: BrowserRouter });
    expect(screen.queryByText(/New Peep/i)).not.toBeInTheDocument();
    expect(screen.queryByText(/Welcome/i)).not.toBeInTheDocument();
    expect(screen.queryByText(/Logout/i)).not.toBeInTheDocument();
    });

    it('should render New Peep, Welcome, and Logout buttons when user is logged in', () => {
    const loggedInUserData = { username: 'Test User' };
    render(<Header loggedInUserData={loggedInUserData} />, { wrapper: BrowserRouter });
    expect(screen.getByText(/New Peep/i)).toBeInTheDocument();
    expect(screen.getByText(/Welcome Test User/i)).toBeInTheDocument();
    expect(screen.getByText(/Logout/i)).toBeInTheDocument();
    });

    it('should not render Login and Signup links when user is logged in', () => {
    const loggedInUserData = { username: 'Test User' };
    render(<Header loggedInUserData={loggedInUserData}/>, { wrapper: BrowserRouter });
    expect(screen.queryByText(/Login/i)).not.toBeInTheDocument();
    expect(screen.queryByText(/Signup/i)).not.toBeInTheDocument();
    });



})