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

function App() {
  return (
    <div>
      <Layout>
        <SiteHeader />
        <Routes>
          <Route path="/" element={<SiteContent />} />
          <Route path="/add-category" element={<CategoryForm />} />
          <Route path="/add-category/success" element={<SuccessfullyCreatedCategory />} />
          <Route path="/categories" element={<ViewAllCategories />} />
        </Routes>
        <SiteFooter />
      </Layout>
    </div>

  );
}

export default App;
