import React from 'react';
import './App.css';
import { Layout } from 'antd';
import { Route, Routes } from 'react-router-dom';
import SiteHeader from './header/SiteHeader';
import SiteFooter from './footer/SiteFooter';
import CategoryForm from './create-category-form/CategoryForm';
import SiteContent from './content/startPage/SiteContent';
import SuccessfullyCreatedCategory from './create-category-form/success/SuccessfullyCreatedCategory';
import ViewAllCategories from './content/allCategories/ViewAllCategories';
import ViewAllCourses from './content/allCourses/ViewAllCourses';
import CourseForm from './create-course-form/CourseForm';
import SuccessfullyCreatedCourse from './create-course-form/success/SuccessfullyCreatedCourse';

function App() {
  return (
    <div>
      <Layout>
        <SiteHeader />
        <Routes>
          <Route path="/" element={<SiteContent />} />
          <Route path="/add-category" element={<CategoryForm />} />
          <Route path="/add-course" element={<CourseForm />} />
          <Route path="/add-course/success" element={<SuccessfullyCreatedCourse />} />
          <Route
            path="/add-category/success"
            element={<SuccessfullyCreatedCategory />}
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
