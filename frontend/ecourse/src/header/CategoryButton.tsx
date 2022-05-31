/* eslint-disable react/destructuring-assignment */
import React, { useCallback } from 'react';
import './CategoryButton.css';

import { Button } from 'antd';
import { useNavigate } from 'react-router-dom';
import ICategoryButtonInfo from './model/ICategoryButtonInfo';

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

function CategoryButton(props: ICategoryButtonInfo) {
  const navigate = useNavigate();
  // eslint-disable-next-line max-len
  const handleOnClick = useCallback(() => navigate(props.routingPath, { replace: true }), [navigate]);

  return (
    <Button
      onClick={handleOnClick}
      type="ghost"
      className="hover"
      style={categoryButtonStyle}
    >
      {props.buttonName}
    </Button>
    <Button type="ghost" className="hover" onClick={() => foo()} style={categoryButtonStyle}>{props.name}</Button>
  );
}

export default CategoryButton;
