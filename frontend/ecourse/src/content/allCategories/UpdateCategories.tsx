import React from 'react';
import { Col, Row } from 'antd';
import CategoryButton from './CategoryButton';

const boardStyle: React.CSSProperties = {
  background: 'white',
  alignItems: 'center',
};

interface Category {
    categoryArray:{
        categoryName: string;
        id: number;
    }[]
    }

function UpdateCategories({ categoryArray }: Category) {
  const cols = [];
  const colCount = categoryArray.length;

  console.log(categoryArray);

  for (let i = 0; i < colCount; i += 1) {
    cols.push(
      <Col key={i.toString()} span={6}>
        <CategoryButton buttonName={categoryArray[i].categoryName} routingPath={`/${categoryArray[i].categoryName}`.replace(/ /g, '-')} />
      </Col>,
    );
  }

  return (
    <Row style={boardStyle} gutter={[16, 16]}>
      {cols}
    </Row>
  );
}
export default UpdateCategories;
