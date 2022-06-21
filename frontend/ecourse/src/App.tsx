import React from 'react';
import './App.css';
import { Layout } from 'antd';
import { Route, Routes } from 'react-router-dom';
import SiteHeader from './header/SiteHeader';
import SiteFooter from './footer/SiteFooter';
import CategoryForm from './forms/create-category-form/CategoryForm';
import SiteContent from './content/startPage/SiteContent';
import SuccessfullyCreated from './forms/success/SuccessfullyCreated';
import ViewAllCategories from './content/allCategories/ViewAllCategories';
import ViewAllCourses from './content/allCourses/ViewAllCourses';
import CourseForm from './forms/create-course-form/CourseForm';

function App() {
  return (
    <div>
      <Layout>
        <SiteHeader />
        <Routes>
          <Route path="/" element={<SiteContent />} />
          <Route path="/add-category" element={<CategoryForm />} />
          <Route path="/add-course" element={<CourseForm />} />
          <Route path="/add-course/success" element={<SuccessfullyCreated />} />
          <Route
            path="/add-category/success"
            element={<SuccessfullyCreated />}
          />
          <Route path="/categories" element={<ViewAllCategories />} />
          <Route path="/:categoryName" element={<ViewAllCourses />} />
        </Routes>
        <SiteFooter />
      </Layout>
    </div>

  );
}

export default App;
