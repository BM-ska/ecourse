import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import UpdateCourses from './UpdateCourses';

const boardStyle: React.CSSProperties = {
  fontSize: '25px',
  background: 'white',
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
  height: '20vh',
};

interface Course {
  id: number;
  courseName: string;
  categoryName: string;
  shortDescription: string;
  longDescription: string;
  courseLink: string;
}

function ViewAllCourses() {
  const { categoryName } = useParams();

  const [list, setList] = useState<Course[]>([]);

  useEffect(() => {
    if (list) {
      axios
        .get(
          `http://localhost:8080/api/v1/courses/${categoryName}`.replace(
            /-/g,
            ' ',
          ),
        )
        .then((res) => {
          const allCourses: Course[] = res.data;
          setList(allCourses);
        });
    }
  }, []);

  return (
    <>
      <div style={boardStyle}>Select course</div>
      <UpdateCourses courseArray={list} />
      <div style={boardStyle} />
    </>
  );
}

export default ViewAllCourses;
