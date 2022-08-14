import { Form, Button, Container, Row, Col, Image } from 'react-bootstrap';
//import Form from 'react-bootstrap/Form';
//import artImage from '../images/modernArt.png';
const SignUp = () => {

    return (
        <Form>
            <h3>Sign Up</h3>
            <div className="mb-3">
                <label>Username</label>
                <input
                    type="text"
                    className="form-control"
                    placeholder="Username"
                />
            </div>
            {/* <div className="mb-3">
                <label>Last name</label>
                <input type="text" className="form-control" placeholder="Last name" />
            </div> */}
            <div className="mb-3">
                <label>Email address</label>
                <input
                    type="email"
                    className="form-control"
                    placeholder="Enter email"
                />
            </div>
            <div className="mb-3">
                <label>Password</label>
                <input
                    type="password"
                    className="form-control"
                    placeholder="Enter password"
                />
            </div>
            <div className="mb-3">
                <label>Password</label>
                <input
                    type="password"
                    className="form-control"
                    placeholder="Confirm password"
                />
            </div>
            <div className="d-grid">
                <button type="submit" className="btn btn-primary">
                    Sign Up
                </button>
            </div>
            <p className="forgot-password text-right">
                Already registered <a href="/sign-in">sign in?</a>
            </p>
        </Form>
    );
}

export default SignUp;