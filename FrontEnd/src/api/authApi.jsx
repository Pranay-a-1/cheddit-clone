import axios from 'axios';
import { API_BASE_URL } from '../config/apiConfig';

export const signUp = async (userData) => {
    return await axios.post(`${API_BASE_URL}/user/register`, userData);
}

export const login = async (userData) => {
    return await axios.post(`${API_BASE_URL}/user/login`, userData);
}

export const createNewPost = async (postData) => {
    return await axios.post(`${API_BASE_URL}/new-post`, postData);
}

export const getAllPosts = async () => {
    const res = await axios.get(`${API_BASE_URL}`, {
        headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`,
        }
    });
    return res.data;
}
