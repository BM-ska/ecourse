import React from 'react';
import { Col, Layout, Row } from 'antd';
import StartButton from './StartButton';
import HeaderButton from './HeaderButton';

const { Header } = Layout;
const headerStyle: React.CSSProperties = {
  background: '#bbd9a2',
  padding: 0,
  textAlign: 'center',
};

function SiteHeader() {
  return (
    <Header style={headerStyle}>
      <Row>
        <Col span={2}><HeaderButton buttonName="Categories" routingPath="/categories" /></Col>
        <Col span={1}><HeaderButton buttonName="Add Category" routingPath="/add-category" /></Col>
        <Col span={18}><StartButton buttonName="Ecourse" routingPath="/" /></Col>
        <Col span={1}><HeaderButton buttonName="Profile" routingPath="/" /></Col>
        <Col span={2}><HeaderButton buttonName="Login" routingPath="/" /></Col>
      </Row>

    </Header>
  );
}

export default SiteHeader;
