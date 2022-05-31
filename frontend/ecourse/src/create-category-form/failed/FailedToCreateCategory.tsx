import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import { BiCommentError } from 'react-icons/bi';

function FailedToCreateCategory() {
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
      Category already exists! Try again!
      <BiCommentError />
    </h1>
  );
}
export default FailedToCreateCategory;
