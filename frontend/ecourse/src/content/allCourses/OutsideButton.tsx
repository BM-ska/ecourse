import React from 'react';
import './CourseButton.css';

import { Button } from 'antd';

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

function OutsideButton({ buttonName, routingPath }: ICourseButtonInfo) {
  return (
    <Button
      type="ghost"
      className="hover"
      style={categoryButtonStyle}
      href={routingPath}
    >
      {buttonName}
    </Button>
  );
}

export default OutsideButton;
