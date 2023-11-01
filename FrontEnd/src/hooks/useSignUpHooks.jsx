import { useState } from 'react';
import { signUp } from '../api/authApi';

const useSignUpHooks = () => {

    const [signUpSuccess, setSignUpSuccess] = useState(false);

    const [values, setValues] = useState({
        username: "",
        email: "",
        password: "",
        confirmPassword: "",
    });



    const handleChange = e => {
        const { name, value } = e.target;
        setValues({
            ...values,
            [name]: value
        })
    }

    const onSuccessRegister = () => {
        alert("SignUp successful, please login");
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            await signUp(values);
            setSignUpSuccess(true);
            onSuccessRegister();
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
                alert('An error occurred during sign up.');
            }
        }
    };

    return { values, signUpSuccess, handleChange, handleSubmit , onSuccessRegister};

}

export default useSignUpHooks;