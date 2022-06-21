import { RightOutlined } from '@ant-design/icons';
import { Card } from 'antd';
import React from 'react';

const courseCardStyle: React.CSSProperties = {
  border: '1px solid black',
  background: 'white',
  width: '90%',
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
      // eslint-disable-next-line jsx-a11y/control-has-associated-label
      extra={<a href={routingPath}><RightOutlined /></a>}
      style={courseCardStyle}
    >
      <span style={spanStyle}>{shortDescription}</span>

    </Card>
  );
}
export default CourseButton;
