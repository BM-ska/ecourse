import React, { useCallback } from 'react';
import './HeaderButton.css';

import { Button } from 'antd';
import { useNavigate } from 'react-router-dom';
import IHeaderButtonInfo from './model/IHeaderButtonInfo';

const categoryButtonStyle: React.CSSProperties = {
  border: '2px solid black',
  borderRadius: '10px',
  width: '80%',
  overflow: 'hidden',
  whiteSpace: 'nowrap',
};

const buttonStyle: React.CSSProperties = {
  position: 'relative',
  display: 'inline-block',
  fontSize: '0.8vw',
  fontWeight: 'bold',
  textAlign: 'center',
};

function HeaderButton({ buttonName, routingPath }: IHeaderButtonInfo) {
  const navigate = useNavigate();
  const handleOnClick = useCallback(
    () => navigate(routingPath, { replace: true }),
    [navigate],
  );

  return (
    <Button
      onClick={handleOnClick}
      type="ghost"
      className="hover"
      style={categoryButtonStyle}
    >
      <span style={buttonStyle}>{buttonName}</span>
    </Button>
  );
}

export default HeaderButton;
