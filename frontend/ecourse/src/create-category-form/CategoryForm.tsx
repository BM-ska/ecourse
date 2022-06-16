import React, { useState } from 'react';
import axios from 'axios';
import { Button, Form, Input } from 'antd';
import { useNavigate } from 'react-router-dom';
import { useForm } from 'antd/es/form/Form';
import FailedToCreateCategory from './failed/FailedToCreateCategory';

const formStyle = {
  background: 'white',
  paddingTop: '30px',
} as const;

function CategoryForm() {
  const [input, setInput] = useState('');
  const [form] = useForm();
  const onChange = (e: React.ChangeEvent<HTMLInputElement>): void => {
    setInput(e.target.value);
  };

  const [disabledSave, setDisabledSave] = useState(true);

  const handleFormChange = () => {
    const hasErrors = form.getFieldsError().some(({ errors }) => errors.length);
    setDisabledSave(hasErrors);
  };

  const [failedPostRequest, setfailedPostRequest] = useState(false);

  const navigate = useNavigate();

  return (
    <>
      <Form
        onFieldsChange={handleFormChange}
        form={form}
        style={formStyle}
        labelCol={{
          span: 8,
        }}
        wrapperCol={{
          span: 8,
        }}
        autoComplete="off"
      >
        <Form.Item
          label="Category name"
          name="categoryName"
          rules={[
            {
              required: true,
              message: 'Please input category name!',
            },
            {
              min: 3,
              message: 'Category name must be minimum 3 characters.',
            },
          ]}
        >
          <Input onChange={onChange} />
        </Form.Item>

        <Form.Item
          wrapperCol={{
            offset: 11,
            span: 16,
          }}
        >
          <Button
            type="primary"
            htmlType="submit"
            disabled={disabledSave}
            onClick={() => {
              axios
                .post('http://localhost:8080/api/v1/categories', {
                  categoryName: input,
                })
                .then(() =>
                  navigate('/add-category/success', { replace: true })
                )
                .catch((error) => {
                  setfailedPostRequest(true);
                  console.log(error);
                });
            }}
          >
            Create
          </Button>
        </Form.Item>
      </Form>
      {failedPostRequest && <FailedToCreateCategory />}
    </>
  );
}

export default CategoryForm;
