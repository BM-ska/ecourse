import React from 'react';
import { BsCheckLg } from 'react-icons/bs';

function SuccessfullyCreatedCategory() {
  return (
    <div
      style={{
        background: 'white',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        height: '20vh',
      }}
    >
      Successfully created category!
      <BsCheckLg />
    </div>
  );
}
export default SuccessfullyCreatedCategory;
