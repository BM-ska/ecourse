/* eslint-disable react/destructuring-assignment */
import React from 'react';
import './CategoryButton.css';

import { Button } from 'antd';

const categoryButtonStyle = {
  border: '2px solid black',
  borderRadius: '10px',
  fontSize: '12px',
  fontWeight: 'bold',
} as const;

// const displayCategory = (event: React.MouseEvent<HTMLButtonElement>) => {
//   console.log('button clicked')};
function foo() {
  alert('foo');
}

function CategoryButton(props: any) {
  return (
    <Button type="ghost" className="hover" onClick={() => foo()} style={categoryButtonStyle}>{props.name}</Button>
  );
}

export default CategoryButton;
