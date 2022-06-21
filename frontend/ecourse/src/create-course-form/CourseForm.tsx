import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {
  Button, Form, Input, Select,
} from 'antd';
import { useNavigate } from 'react-router-dom';
import { useForm } from 'antd/es/form/Form';
import FailedToCreateCourse from './failed/FailedToCreateCourse';

const formStyle = {
  background: 'white',
  paddingTop: '30px',
} as const;

interface Category {
    categoryName: string;
    id: number;
}

interface IForm {
    categoryName: string;
    courseName: string;
    shortDescription?: string;
    longDescription: string;
    courseLink: string|undefined;
}

let options: any[] = [];

function handleUrl(url: string): string|undefined {
  if (url === undefined) {
    return url;
  }
  if (url.startsWith('http://') || url.startsWith('https://')) {
    return url;
  }
  return `https://${url}`;
}

function CourseForm() {
  const [list, setList] = useState<any[]>([]);

  useEffect(() => {
    if (list) {
      axios.get('http://localhost:8080/api/v1/categories')
        .then((res) => {
          const allCategories: Category[] = res.data;
          options = [];
          Object.values(allCategories).forEach((category: Category) => {
            options.push(
              { value: category.categoryName, label: category.categoryName },
            );
          });
          setList(options);
        });
    }
  }, []);

  const [input, setInput] = useState<IForm>({
    categoryName: '', courseName: '', shortDescription: '', longDescription: '', courseLink: '',
  });
  const [form] = useForm();
  const [disabledSave, setDisabledSave] = useState(true);

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
      courseLink: handleUrl(formFields.courseLink),
    });
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
            {
              pattern: /^(?!.*\s{2,})(?!^ )[0-9A-Za-z\s]{1,}$/,
              message: 'Wrong format! There can not be more than one subsequent space or any special character in course name.',
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
            {
              max: 80,
              message: 'Short description can be maximum 50 characters.',
            },
            {
              pattern: /^(?!.*\s{2,})(?!^ )[0-9A-Za-z\s]{1,}$/,
              message: 'Wrong format! There can not be more than one subsequent space or any special character in short description.',
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
            {
              pattern: /^(?!.*\s{2,})(?!^ )[0-9A-Za-z\s]{1,}$/,
              message: 'Wrong format! There can not be more than one subsequent space or any special character in long description.',
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
              message: 'Course link must be minimum 5 characters.',
            },
            {
              pattern: /^(http:\/\/www\.|https:\/\/www\.|http:\/\/|https:\/\/)?[a-z0-9]+([\-\.]{1}[a-z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$/, // eslint-disable-line
              message: 'Wrong URL format. Valid is for e.g. google.com, www.google.com, https://google.com, http://google.com',
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
          <Button
            type="primary"
            htmlType="submit"
            disabled={disabledSave}
            onClick={() => {
              axios.post('http://localhost:8080/api/v1/courses', input)
                .then(() => navigate('/add-course/success', { replace: true }))
                .catch(() => {
                  setfailedPostRequest(true);
                });
            }}
          >
            Create
          </Button>
        </Form.Item>
      </Form>
      {failedPostRequest && <FailedToCreateCourse />}
    </>
  );
}

export default CourseForm;
