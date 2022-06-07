import React from 'react';
import CategoryButton from './CategoryButton';
import { Col, Row } from 'antd';
import axios from 'axios';

const boardStyle = {
  background: 'white',
  paddingTop: '30px',
  textAlign: 'center',
} as const;

var x: any;

function updateCategories(){
  return(
  <h2 style={boardStyle}>
      <Row>
        <Col span={24}><CategoryButton buttonName="Liczby pierwsze" routingPath="/categories" /></Col>
      </Row>

    </h2>
  );
}

function getCategories() {
  axios.get('http://localhost:8080/api/v1/categories')
      .then(res => {
        x = res.data;
      })
}

 function ViewAllCategories() {
  getCategories();

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

        
      </></>
    
  );
}
export default ViewAllCategories;
