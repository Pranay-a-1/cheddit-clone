import axios from 'axios';
import { API_BASE_URL } from '../config/apiConfig';

export const signUp = async (userData) => {
    return axios.post(`${API_BASE_URL}/user/register`, userData);
}