import React from 'react';
import { BsCheckLg } from 'react-icons/bs';

function SuccessfullyCreatedCourse() {
  return (
    <div style={{
      background: 'white',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      height: '20vh',
    }}
    >
      Successfully created course!
      <BsCheckLg />
    </div>
  );
}
export default SuccessfullyCreatedCourse;
