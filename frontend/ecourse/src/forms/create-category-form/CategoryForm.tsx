import React, { useState } from 'react';
import { Form, Input } from 'antd';
import { useForm } from 'antd/es/form/Form';
import FailedToCreate from '../failed/FailedToCreate';
import CreateButton from './CreateButton';

const formStyle = {
  background: 'white',
  paddingTop: '30px',
} as const;

function CategoryForm() {
  const [input, setInput] = useState('');
  const [disabledSave, setDisabledSave] = useState(true);
  const [failedPostRequest, setfailedPostRequest] = useState(false);
  const [form] = useForm();

  const onChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setInput(e.target.value);
  };

  const handleFormChange = () => {
    const hasErrors = form.getFieldsError().some(({ errors }) => errors.length);
    setDisabledSave(hasErrors);
  };
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
          <CreateButton
            input={input}
            disabledSave={disabledSave}
            setfailedPostRequest={setfailedPostRequest}
          />
        </Form.Item>
      </Form>
      {failedPostRequest && <FailedToCreate category />}
    </>
  );
}

export default CategoryForm;
