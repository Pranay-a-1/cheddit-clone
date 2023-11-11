import { useState } from 'react';
import { login } from '../api/authApi';


const useLoginHooks = ({ setLogInStatus, setLoggedInUserData }) => {

    const [values, setValues] = useState({
        email: "",
        password: "",
    });

    const handleChange = e => {
        const { name, value } = e.target;
        setValues({
            ...values,
            [name]: value
        })
    }

    const onSuccessLogin = (username) => {
        alert(`Welcome ${username}`);
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const res = await login(values);
            setLogInStatus(res.data.token ? true : false);
            setLoggedInUserData(res.data);
            localStorage.setItem("token", res.data.token);
            //throw error if no username
            if (res.data.username) {
                onSuccessLogin(res.data.username);
            } else {
                throw new Error('No username');
            }
        } catch (error) {
            console.log(error);
            // If the response data is a string
            if (typeof error.response?.data === 'string') {
                alert(error.response.data);
            }
            // If the response data is expected to be an object with a 'message' field
            else if (typeof error.response?.data?.message === 'string') {
                alert(error.response.data.message);
            }
            // Default error message if none of the above conditions are met
            else {
                alert('An error occurred during login.');
            }
        }
    };



    return { values, handleChange, handleSubmit }

}

export default useLoginHooks;