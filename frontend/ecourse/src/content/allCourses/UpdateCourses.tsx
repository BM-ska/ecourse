import React from 'react';
import { Col, Row } from 'antd';
import CourseButton from './CourseButton';

const boardStyle: React.CSSProperties = {
  background: 'white',
  alignItems: 'center',
  textAlign: 'center',
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
  const cols = [];
  const colCount = courseArray.length;

  for (let i = 0; i < colCount; i += 1) {
    cols.push(
      <Col key={i.toString()} span={6}>
        <CourseButton
          buttonName={courseArray[i].courseName}
          routingPath={`${courseArray[i].courseLink}`}
          shortDescription={courseArray[i].shortDescription}
        />
      </Col>,
    );
  }

  return (
    <Row style={boardStyle} gutter={[16, 16]}>
      {cols}
    </Row>
  );
}
export default UpdateCourses;
