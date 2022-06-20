import React from 'react';
import { Button } from 'antd';
import { GithubOutlined } from '@ant-design/icons';
import { Footer } from 'antd/lib/layout/layout';

const footerStyle: React.CSSProperties = {
  borderTop: '1px solid #e8e8e8',
  position: 'fixed',
  left: 0,
  bottom: 0,
  width: '100%',
  backgroundColor: '#bbd9a2',
  textAlign: 'center',
};

function SiteFooter() {
  return (
    <Footer style={footerStyle}>
      <div>
        Visit us on GitHub
        <Button
          size="large"
          href="https://github.com/BM-ska/ecourse"
          type="text"
          shape="default"
          icon={<GithubOutlined style={{ fontSize: '40px' }} />}
        />
      </div>
    </Footer>
  );
}

export default SiteFooter;
