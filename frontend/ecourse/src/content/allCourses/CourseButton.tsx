import { RightOutlined } from '@ant-design/icons';
import { Button, Card } from 'antd';
import React from 'react';

const courseCardStyle: React.CSSProperties = {
  border: '1px solid black',
  background: 'white',
  width: '100%',
  overflow: 'hidden',
  textAlign: 'center',
};

const spanStyle: React.CSSProperties = {
  position: 'relative',
  display: 'inline-block',
  fontSize: '1vw',
  textAlign: 'center',
};

interface ICourseButtonInfo {
  buttonName: string;
  routingPath: string;
  shortDescription: string;
}

function CourseButton({ buttonName, routingPath, shortDescription }: ICourseButtonInfo) {
  return (
    <Card
      title={<span style={spanStyle}>{buttonName}</span>}
      extra={<Button href={routingPath}><RightOutlined /></Button>}
      style={courseCardStyle}
    >
      <span style={spanStyle}>{shortDescription}</span>

    </Card>
  );
}
export default CourseButton;
