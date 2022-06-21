import React from 'react';
import { BiCommentError } from 'react-icons/bi';

function FailedToCreate({ course, category } : {course?: boolean, category?: boolean}) {
  return (
    <div
      style={{
        background: 'white',
        color: 'red',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        height: '20vh',
      }}
    >
      {course
    && <span>Course</span>}
      {category
    && <span>Category</span>}
      already exists! Try again!
      <BiCommentError />
    </div>
  );
}

FailedToCreate.defaultProps = {
  course: false,
  category: false,
};

export default FailedToCreate;
