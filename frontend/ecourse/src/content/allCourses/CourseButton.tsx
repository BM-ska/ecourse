import React, { useCallback } from 'react';
import './CourseButton.css';

import { Button } from 'antd';
import { useNavigate } from 'react-router-dom';

interface ICourseButtonInfo {
  buttonName: string;
  routingPath: string;
}

const categoryButtonStyle = {
  border: '2px solid black',
  borderRadius: '10px',
  fontSize: '12px',
  fontWeight: 'bold',
  background: '#bbd9a2',
} as const;

function CategoryButton({ buttonName, routingPath }: ICourseButtonInfo) {
  const navigate = useNavigate();
  const handleOnClick = useCallback(
    () => navigate(routingPath, { replace: true }),
    [navigate, routingPath],
  );

  return (
    <Button
      onClick={handleOnClick}
      type="ghost"
      className="hover"
      style={categoryButtonStyle}
    >
      {buttonName}
    </Button>
  );
}

export default CategoryButton;
