import React, { useCallback } from 'react';
import './CategoryButton.css';

import { Button } from 'antd';
import { useNavigate } from 'react-router-dom';
import ICategoryButtonInfo from './model/ICategoryButtonInfo';

const categoryButtonStyle: React.CSSProperties = {
  border: '2px solid black',
  borderRadius: '10px',
  fontWeight: 'bold',
  background: '#bbd9a2',
  width: '80%',
  overflow: 'hidden',
  whiteSpace: 'nowrap',
};

const spanStyle: React.CSSProperties = {
  position: 'relative',
  display: 'inline-block',
  fontSize: '0.8vw',
  fontWeight: 'bold',
  textAlign: 'center',
};

function CategoryButton({ buttonName, routingPath }: ICategoryButtonInfo) {
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
      <span style={spanStyle}>{buttonName}</span>
    </Button>
  );
}

export default CategoryButton;
