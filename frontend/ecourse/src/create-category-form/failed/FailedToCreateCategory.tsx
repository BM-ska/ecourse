import React from 'react';
import { BiCommentError } from 'react-icons/bi';

function FailedToCreateCategory() {
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
      Category already exists! Try again!
      <BiCommentError />
    </div>
  );
}
export default FailedToCreateCategory;
