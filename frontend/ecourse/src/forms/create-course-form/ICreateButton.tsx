import React from 'react';
import IForm from './IForm';

interface ICreateButton {
    disabledSave: boolean;
    input: IForm;
    setfailedPostRequest: React.Dispatch<React.SetStateAction<boolean>>;
  }
export default ICreateButton;
