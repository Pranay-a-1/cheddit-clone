import { Form, Button, Container, Row, Col, Image } from 'react-bootstrap';

const NewPost = () => {

    return (
        <Form>
            {/* <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Email address</Form.Label>
                <Form.Control type="email" placeholder="name@example.com" />
            </Form.Group> */}
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>Type your peep</Form.Label>
                <Form.Control as="textarea" rows={3} />
            </Form.Group>
            <div className="d-grid">
                <button type="submit" className="btn btn-primary">
                    Create New Post
                </button>
            </div>
        </Form>
    );
};

export default NewPost;