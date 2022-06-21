import React, { ReactElement } from 'react';
import { Col, Row } from 'antd';
import OutsideButton from './OutsideButton';

const boardStyle: React.CSSProperties = {
  background: 'white',
  alignItems: 'center',
};

interface Course {
  courseArray: {
    id: number;
    courseName: string;
    categoryName: string;
    shortDescription: string;
    longDescription: string;
    courseLink: string;
  }[];
}

function UpdateCourses({ courseArray }: Course) {
  const cols: ReactElement<any, any>[] = [];

  courseArray.forEach((course) => {
    cols.push(
      <Col key={course.id} span={6}>
        <OutsideButton
          buttonName={course.courseName}
          routingPath={`${course.courseLink}`}
        />
      </Col>,
    );
  });

  return (
    <Row style={boardStyle} gutter={[16, 16]}>
      {cols}
    </Row>
  );
}
export default UpdateCourses;
