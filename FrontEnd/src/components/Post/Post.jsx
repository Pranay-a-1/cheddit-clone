import React from 'react';
import { Row, Card } from 'react-bootstrap';
import moment from 'moment';

const Post = ({ post }) => {
    return (
        <Row xs={1} md={1} lg={1} className="g-4">
            <Card>
                <Card.Body>
                    <Card.Text>
                        <strong>{post.user.firstName} {post.user.lastName} </strong>
                        <span> @{post.user.username} - </span>
                        <span> {moment(post.createdAt).fromNow()} </span>
                    </Card.Text>
                    <Card.Text>{post.postText}</Card.Text>
                </Card.Body>
            </Card>
        </Row>
    );
}

export default Post;
