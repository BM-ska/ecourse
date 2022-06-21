import React from 'react';
import axios from 'axios';
import { Button } from 'antd';
import { useNavigate } from 'react-router-dom';
import ICreateButton from './ICreateButton';

function CreateButton({ disabledSave, input, setfailedPostRequest } : ICreateButton) {
  const navigate = useNavigate();

  return (
    <Button
      type="primary"
      htmlType="submit"
      disabled={disabledSave}
      onClick={() => {
        axios.post('http://localhost:8080/api/v1/courses', input)
          .then(() => navigate('/add-course/success', { replace: true }))
          .catch((error) => {
            setfailedPostRequest(true);
            console.log(error);
          });
      }}
    >
      Create
    </Button>
  );
}

export default CreateButton;
