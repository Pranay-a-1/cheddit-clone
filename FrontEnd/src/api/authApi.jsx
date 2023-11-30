import axios from 'axios';
import { API_BASE_URL } from '../config/apiConfig';

export const signUp = async (userData) => {
    return axios.post(`${API_BASE_URL}/user/register`, userData);
}

export const login = async (userData) => {
    return axios.post(`${API_BASE_URL}/user/login`, userData);
}

export const createNewPost = async (postData) => {
    return axios.post(`${API_BASE_URL}/new-post`, postData);
}