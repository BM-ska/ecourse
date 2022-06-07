import React from 'react';
import { Col, Layout, Row } from 'antd';
import CategoryButton from './CategoryButton';
import StartButton from './StartButton';

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
        <Col span={2}><CategoryButton buttonName="Categories" routingPath="/categories" /></Col>
        <Col span={1}><CategoryButton buttonName="Add Category" routingPath="/add-category" /></Col>
        <Col span={18}><StartButton buttonName="Ecourse" routingPath="/" /></Col>
        <Col span={1}><CategoryButton buttonName="Profile" routingPath="/" /></Col>
        <Col span={2}><CategoryButton buttonName="Login" routingPath="/" /></Col>
      </Row>

    </Header>
  );
}

export default SiteHeader;
