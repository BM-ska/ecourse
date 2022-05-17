import React from 'react';
import { Col, Layout, Row } from 'antd';
import CategoryButton from './CategoryButton';

const { Header } = Layout;
const headerStyle = {
  background: '#bbd9a2',
  padding: 0,
  textAlign: 'center',
} as const;

function SiteHeader() {
  return (
    <Header style={headerStyle}>
      <Row>
        <Col span={3}><CategoryButton name="Categories" /></Col>
        <Col span={18}><h1>Ecourse</h1></Col>
        <Col span={1}><CategoryButton name="Profile" /></Col>
        <Col span={2}><CategoryButton name="Login" /></Col>
      </Row>

    </Header>
  );
}

export default SiteHeader;
