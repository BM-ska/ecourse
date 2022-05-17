import React from 'react';
import { Button, Layout } from 'antd';
import { GithubOutlined } from '@ant-design/icons';

const { Footer } = Layout;
const footerStyle = {
  borderTop: '1px solid #e8e8e8',
  position: 'fixed',
  left: 0,
  bottom: 0,
  width: '100%',
  backgroundColor: '#bbd9a2',
  textAlign: 'center',
} as const;

function SiteFooter() {
  return (
    <Footer style={footerStyle}>
      <div>
        Visit us on GitHub

        <Button size="large" href="https://github.com/BM-ska/ecourse" type="text" shape="default" icon={<GithubOutlined style={{ fontSize: '40px' }} />} />

      </div>

    </Footer>
  );
}

export default SiteFooter;
