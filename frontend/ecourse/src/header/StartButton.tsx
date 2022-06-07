/* eslint-disable react/destructuring-assignment */
import React, { useCallback } from 'react';
import './CategoryButton.css';

import { Button } from 'antd';
import { useNavigate } from 'react-router-dom';
import ICategoryButtonInfo from './model/ICategoryButtonInfo';

const startButtonStyle = {
  fontSize: '15px',
  fontWeight: 'bold',
} as const;

function StartButton(props: ICategoryButtonInfo) {
  const navigate = useNavigate();
  // eslint-disable-next-line max-len
  const handleOnClick = useCallback(() => navigate(props.routingPath, { replace: true }), [navigate]);

  return (
    <Button
      onClick={handleOnClick}
      type="ghost"
      className="hover"
      style={startButtonStyle}
    >
      {props.buttonName}


    </Button>
  );
}

export default StartButton;
