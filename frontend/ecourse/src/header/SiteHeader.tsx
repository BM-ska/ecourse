import React from 'react';
import { Col, Row } from 'antd';
import { Header } from 'antd/lib/layout/layout';
import StartButton from './StartButton';
import HeaderButton from './HeaderButton';

const headerStyle: React.CSSProperties = {
  background: '#bbd9a2',
  padding: 0,
  textAlign: 'center',
};

function SiteHeader() {
  return (
    <Header style={headerStyle}>
      <Row>
        <Col span={1}>
          <HeaderButton buttonName="Categories" routingPath="/categories" />
        </Col>
        <Col span={2}><HeaderButton buttonName="Add Course" routingPath="/add-course" /></Col>
        <Col span={1}>
          <HeaderButton buttonName="Add Category" routingPath="/add-category" />
        </Col>
        <Col span={17}>
          <StartButton buttonName="Ecourse" routingPath="/" />
        </Col>
        <Col span={1}>
          <HeaderButton buttonName="Profile" routingPath="/" />
        </Col>
        <Col span={2}>
          <HeaderButton buttonName="Login" routingPath="/" />
        </Col>
      </Row>
    </Header>
  );
}

export default SiteHeader;
