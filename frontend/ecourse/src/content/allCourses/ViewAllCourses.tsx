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

// https://dev.to/franciscomendes10866/get-data-using-dynamic-react-routes-1ac3

interface Course {
    categoryName: string;
    id: number;
  }

function ViewAllCourses() {
  const { categoryName } = useParams();

  const [list, setList] = useState<Course[]>([]);

  //   useEffect(() => {
  //     if (list) {
  //       axios.get('http://localhost:8080/api/v1/${categoryName}');
  //         .then((res) => {
  //           const allCourse: Course[] = res.data;
  //           setList(allCourse);
  //         });

  //         console.log(list);
  //     }
  //   }, []);

  return (
    <h1 style={boardStyle}>
      Select course
    </h1>
  );
}

export default ViewAllCourses;
