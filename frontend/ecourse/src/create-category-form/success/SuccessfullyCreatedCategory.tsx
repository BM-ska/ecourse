import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import { BsCheckLg } from 'react-icons/bs';

function SuccessfullyCreatedCategory() {
  return (
    <h1 style={{
      background: 'white',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      height: '20vh',
    }}
    >
      Successfully created category!
      <BsCheckLg />
    </h1>
  );
}
export default SuccessfullyCreatedCategory;