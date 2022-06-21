import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Form, Input, Select } from 'antd';
import { useForm } from 'antd/es/form/Form';
import FailedToCreateCourse from './failed/FailedToCreateCourse';
import CreateButton from './CreateButton';
import IForm from './IForm';

const formStyle: React.CSSProperties = {
  background: 'white',
  paddingTop: '30px',
};

interface Category {
    categoryName: string;
    id: number;
}

interface CategoryLabel {
  value: string;
  label: string;
}

function CourseForm() {
  const [list, setList] = useState<CategoryLabel[]>([]);
  const [input, setInput] = useState<IForm>({
    categoryName: '', courseName: '', shortDescription: '', longDescription: '', courseLink: '',
  });
  const [disabledSave, setDisabledSave] = useState(true);
  const [failedPostRequest, setfailedPostRequest] = useState(false);
  const [form] = useForm();

  useEffect(() => {
    console.log('use Effect!');
    if (list) {
      axios.get('http://localhost:8080/api/v1/categories')
        .then((res) => {
          const allCategories: Category[] = res.data;
          const options: CategoryLabel[] = [];
          Object.values(allCategories).forEach((category: Category) => {
            options.push(
              { value: category.categoryName, label: category.categoryName },
            );
          });
          setList(options);
        });
    }
  }, [list]);

  const handleFormChange = () => {
    const hasErrors = form.getFieldsError().some(
      ({ errors }) => errors.length,
    ) || !form.isFieldsTouched(true);
    setDisabledSave(hasErrors);
    const formFields = form.getFieldsValue(true);
    setInput({
      categoryName: formFields.categoryName,
      courseName: formFields.courseName,
      shortDescription: formFields.shortDescription,
      longDescription: formFields.longDescription,
      courseLink: formFields.courseLink,
    });
    console.log(input);
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
          <Select
            showSearch
            placeholder="Select a category"
            options={list}
          />
        </Form.Item>
        <Form.Item
          label="Course name"
          name="courseName"
          rules={[
            {
              required: true,
              message: 'Please input course name!',
            },
            {
              min: 2,
              message: 'Course name must be minimum 2 characters.',
            },
          ]}
        >
          <Input />
        </Form.Item>

        <Form.Item
          label="Short description"
          name="shortDescription"
          rules={[
            {
              required: true,
              message: 'Please input short description!',
            },
            {
              min: 5,
              message: 'Short description must be minimum 5 characters.',
            },
          ]}
        >
          <Input />
        </Form.Item>

        <Form.Item
          label="Long description"
          name="longDescription"
          rules={[
            {
              required: true,
              message: 'Please input long description!',
            },
            {
              min: 20,
              message: 'Long description must be minimum 20 characters.',
            },
          ]}
        >
          <Input />
        </Form.Item>

        <Form.Item
          label="Course link"
          name="courseLink"
          rules={[
            {
              required: true,
              message: 'Please input course link!',
            },
            {
              min: 5,
              message: 'course link must be minimum 5 characters.',
            },
          ]}
        >
          <Input />
        </Form.Item>

        <Form.Item
          wrapperCol={{
            offset: 11,
            span: 16,
          }}
        >
          <CreateButton
            disabledSave={disabledSave}
            input={input}
            setfailedPostRequest={setfailedPostRequest}
          />
        </Form.Item>
      </Form>
      {failedPostRequest && <FailedToCreateCourse />}
    </>
  );
}

export default CourseForm;
