import React from 'react';
import { Button } from 'antd';
import { FolderFilled } from '@ant-design/icons';
import { Content } from 'antd/lib/layout/layout';

const contentStyle: React.CSSProperties = {
  textAlign: 'center',
  height: '100vh',
};
function SiteContent() {
  return (
    <Content style={contentStyle}>
      <div style={{ paddingTop: '10px' }}>
        Welcome to our page! Check out avaiable courses!
      </div>
      <div
        style={{
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center',
          height: '20vh',
        }}
      >
        <div
          style={{
            lineHeight: '30px',
            border: '2px solid black',
            borderRadius: '10px',
            padding: '5px',
            width: '20%',
          }}
        >
          <Button type="text" shape="circle">
            <FolderFilled style={{ fontSize: '40px' }} />
          </Button>
          <Button
            shape="circle"
            style={{ fontSize: '30px', textAlign: 'center' }}
            type="text"
          >
            {' '}
            My Learning
            {' '}
          </Button>
        </div>
      </div>
    </Content>
  );
}

export default SiteContent;
