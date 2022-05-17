import React from 'react';
import './App.css';
import { Layout } from 'antd';
import SiteContent from './content/SiteContent';
import SiteHeader from './header/SiteHeader';
import SiteFooter from './footer/SiteFooter';

function App() {
  return (
    <div>
      <Layout>
        <SiteHeader />
        <SiteContent />
        <SiteFooter />
      </Layout>

    </div>

  );
}

export default App;
