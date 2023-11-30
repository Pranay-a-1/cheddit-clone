import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { createNewPost} from '../api/authApi';


const useNewPostHooks = ({ loggedInUserData }) => {

    let navigate = useNavigate();

    const [newPostCreated, setNewPostCreated] = useState(false);


    const [values, setValues] = useState({
        postText: "",
    })

    let { postText } = values;


    const handleChange = e => {
        const { name, value } = e.target;
        setValues({
            ...values,
            [name]: value
        })
    }

    const onSuccessPost = () => {
        alert("New Post created");
        navigate('/');
    }


    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            await createNewPost(
                {
                    accessToken: `Bearer ${localStorage.getItem('token')}`,
                    ...values,
                }
            );
            setNewPostCreated(true);
            onSuccessPost();
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
                alert('An error occurred during new post.');
            }
        }
    }


    return { values, handleChange, handleSubmit, newPostCreated }



}

export default useNewPostHooks;