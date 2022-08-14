import { Form, Button, Container, Row, Col } from 'react-bootstrap';
//import Form from 'react-bootstrap/Form';
//import artImage from '../images/modernArt.png';
const LogIn = () => {

    return (
        <Container fluid >
            <Row>
                {/* <Col ><Image src={artImage} fluid /></Col> */}
                <Col >
                    {/* <Image src={artImage} fluid /> */}
                    <Form>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control type="email" placeholder="Enter email" />
                            {/* <Form.Text className="text-muted">
                                We'll never share your email with anyone else.
                            </Form.Text> */}
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" placeholder="Password" />
                        </Form.Group>

                        <Button variant="primary" type="submit">
                            Sign In
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container >
    );
}

export default LogIn