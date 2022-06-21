import React, { ReactElement } from 'react';
import { Col, Row } from 'antd';
import CategoryButton from './CategoryButton';

const boardStyle: React.CSSProperties = {
  background: 'white',
  alignItems: 'center',
  textAlign: 'center',
};

interface Category {
  categoryArray: {
    categoryName: string;
    id: number;
  }[];
}

function UpdateCategories({ categoryArray }: Category) {
  const cols: ReactElement<any, any>[] = [];

  categoryArray.forEach((category) => {
    cols.push(
      <Col key={category.id} span={4}>
        <CategoryButton
          buttonName={category.categoryName}
          routingPath={`/${category.categoryName}`.replace(/ /g, '-')}
        />
      </Col>,
    );
  });

  return (
    <Row style={boardStyle} gutter={[16, 16]}>
      {cols}
    </Row>
  );
}
export default UpdateCategories;
