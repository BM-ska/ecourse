import React from 'react';
import { BiCommentError } from 'react-icons/bi';

function FailedToCreateCourse() {
  return (
    <h1 style={{
      background: 'white',
      color: 'red',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      height: '20vh',
    }}
    >
      Course already exists! Try again!
      <BiCommentError />
    </h1>
  );
}
export default FailedToCreateCourse;
