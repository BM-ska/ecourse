import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const boardStyle: React.CSSProperties = {
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

  }

function ViewAllCourses() {
  const { categoryName } = useParams();

  const [list, setList] = useState<Course[]>([]);

  useEffect(() => {
    axios.get(`http://localhost:8080/api/v1/courses/${categoryName}`.replace(/-/g, ' '))
      .then((res) => {
        const allCourses: Course[] = res.data;
        setList(allCourses);

        console.log(res.data);
        console.log(list);
      });
  }, []);

  return (
    <h1 style={boardStyle}>
      Select course
    </h1>
  );
}

export default ViewAllCourses;
