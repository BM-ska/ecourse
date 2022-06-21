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

const primaryButtonStyle: React.CSSProperties = {
  fontSize: '15px',
  fontWeight: 'bold',
};

function HeaderButton({ buttonName, routingPath, isHeader: isPrimary }: IHeaderButtonInfo) {
  const navigate = useNavigate();
  const handleOnClick = useCallback(
    () => navigate(routingPath, { replace: true }),
    [navigate, routingPath],
  );
  if (isPrimary) {
    return (
      <Button
        onClick={handleOnClick}
        type="ghost"
        className="hover"
        style={primaryButtonStyle}
      >
        {buttonName}
      </Button>
    );
  }

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
