import React from 'react';
import { BsCheckLg } from 'react-icons/bs';

function SuccessfullyCreated() {
  return (
    <div
      style={{
        fontSize: '30px',
        background: 'white',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        height: '20vh',
      }}
    >
      Successfully created
      <BsCheckLg />
    </div>
  );
}
export default SuccessfullyCreated;
