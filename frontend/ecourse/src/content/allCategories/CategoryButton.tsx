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
  background: '#bbd9a2',
} as const;

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
  );
}

export default CategoryButton;
