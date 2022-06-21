import { RightOutlined } from '@ant-design/icons';
import { Card } from 'antd';
import React from 'react';

interface ICourseButtonInfo {
  buttonName: string;
  routingPath: string;
  shortDescription: string;
}

function CourseButton({ buttonName, routingPath, shortDescription }: ICourseButtonInfo) {
  return (
    <Card
      title={buttonName}
      // eslint-disable-next-line jsx-a11y/control-has-associated-label
      extra={<a href={routingPath}><RightOutlined /></a>}
      style={{ width: 300 }}
    >
      {shortDescription}
    </Card>
  );
}
export default CourseButton;
