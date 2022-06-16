import React from 'react';
import { BsCheckLg } from 'react-icons/bs';

function SuccessfullyCreatedCourse() {
  return (
    <h1 style={{
      background: 'white',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      height: '20vh',
    }}
    >
      Successfully created course!
      <BsCheckLg />
    </h1>
  );
}
export default SuccessfullyCreatedCourse;
