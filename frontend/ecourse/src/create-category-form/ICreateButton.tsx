import React from 'react';

interface ICreateButton {
    disabledSave: boolean;
    input: string;
    setfailedPostRequest: React.Dispatch<React.SetStateAction<boolean>>;
  }
export default ICreateButton;
