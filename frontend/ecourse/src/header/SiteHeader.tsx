import React from 'react';
import { Col, Row } from 'antd';
import { Header } from 'antd/lib/layout/layout';
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
        <Col span={2}>
          <HeaderButton buttonName="Categories" routingPath="/categories" isHeader={false} />
        </Col>
        <Col span={2}><HeaderButton buttonName="Add Course" routingPath="/add-course" isHeader={false} /></Col>
        <Col span={3}>
          <HeaderButton buttonName="Add Category" routingPath="/add-category" isHeader={false} />
        </Col>
        <Col span={10}>
          <HeaderButton buttonName="Ecourse" routingPath="/" isHeader />
        </Col>
        <Col span={3} />
        <Col span={2}>
          <HeaderButton buttonName="Profile" routingPath="/" isHeader={false} />
        </Col>
        <Col span={2}>
          <HeaderButton buttonName="Login" routingPath="/" isHeader={false} />
        </Col>
      </Row>
    </Header>
  );
}

export default SiteHeader;
