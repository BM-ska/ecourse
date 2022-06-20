import React from 'react';
import { BiCommentError } from 'react-icons/bi';

function FailedToCreateCourse() {
  return (
    <div style={{
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
    </div>
  );
}
export default FailedToCreateCourse;
