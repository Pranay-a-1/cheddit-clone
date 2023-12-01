import React, { useState, useEffect } from 'react';
import { getAllPosts } from '../api/authApi';
import Post from '../components/Post/Post';

const Home = () => {

    const [postsArray, setPostsArray] = useState([]);


    const fetchPosts = async () => {
        const posts = await getAllPosts()
        .then(posts => 
            posts.sort((a, b) => {
                return new Date(b.createdAt) - new Date(a.createdAt);
            }));
        setPostsArray(posts);
    }

    useEffect(() => {
        fetchPosts();
    }, []);

    return (
        <>
            {postsArray.map(post => (
                <Post key={post.id} post={post} />
            ))}
        </>
    );
}

export default Home;