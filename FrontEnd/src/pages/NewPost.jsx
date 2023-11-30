import { FloatingLabel, Form, Card, Button } from 'react-bootstrap';
import useNewPostHooks from '../hooks/useNewPostHooks';
import { Navigate } from 'react-router-dom';
import { useState } from 'react';
import axios from 'axios';

const NewPost = ({  loggedInUserData }) => {

    const { values, handleChange, handleSubmit, newPostCreated } = useNewPostHooks({ loggedInUserData });

    const { postText } = values;

    return (
        <>
            {newPostCreated && <Navigate to='/' replace='true' />}
            <Card>
                <Card.Header as="h5">Create a new post</Card.Header>
                <Card.Body>
                    <Form onSubmit={handleSubmit}>
                        <FloatingLabel controlId="floatingTextarea2" label="Create a new post">
                            <Form.Control
                                as="textarea"
                                placeholder="Leave a post here"
                                style={{ height: '100px' }}
                                name="postText"
                                value={postText}
                                onChange={handleChange}
                            />
                        </FloatingLabel>
                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>
                </Card.Body>
            </Card>
        </>
    )



}

export default NewPost;
