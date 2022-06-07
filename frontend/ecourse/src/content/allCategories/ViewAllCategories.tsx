import React from 'react';
import CategoryButton from './CategoryButton';
import { Col, Layout, Row } from 'antd';
// eslint-disable-next-line import/no-extraneous-dependencies
// import { BsCheckLg } from 'react-icons/bs';

//const { Header } = Layout;
const boardStyle = {
  background: 'white',
  paddingTop: '30px',
  textAlign: 'center',
} as const;

function ViewAllCategories() {
  return (
    <><>
      <h1 style={{
        background: 'white',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        height: '20vh',
      }}
      >
        Select category
      </h1>
    </><>
        <h2 style={boardStyle}>
          <Row>
            <Col span={24}><CategoryButton buttonName="Liczby pierwsze" routingPath="/categories" /></Col>
          </Row>

        </h2>
      </></>
    
  );
}
export default ViewAllCategories;
