/* eslint-disable react/destructuring-assignment */
import React, { useCallback } from 'react';
import './HeaderButton.css';

import { Button } from 'antd';
import { useNavigate } from 'react-router-dom';
import IHeaderButtonInfo from './model/IHeaderButtonInfo';

const startButtonStyle = {
  fontSize: '15px',
  fontWeight: 'bold',
} as const;

function StartButton(props: IHeaderButtonInfo) {
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