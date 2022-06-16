import React, { useCallback } from 'react';
import './HeaderButton.css';

import { Button } from 'antd';
import { useNavigate } from 'react-router-dom';
import IHeaderButtonInfo from './model/IHeaderButtonInfo';

const startButtonStyle: React.CSSProperties = {
  fontSize: '15px',
  fontWeight: 'bold',
};

function StartButton({
  buttonName,
  routingPath,
} : IHeaderButtonInfo) {
  const navigate = useNavigate();
  const handleOnClick = useCallback(() => navigate(routingPath, { replace: true }), [navigate]);

  return (
    <Button
      onClick={handleOnClick}
      type="ghost"
      className="hover"
      style={startButtonStyle}
    >
      {buttonName}

    </Button>
  );
}

export default StartButton;
