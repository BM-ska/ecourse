import React, { useEffect, useState } from 'react';
import axios from 'axios';
import UpdateCategories from './UpdateCategories';

const boardStyle: React.CSSProperties = {
  background: 'white',
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
  height: '20vh',
};

interface Category {
  categoryName: string;
  id: number;
}

function ViewAllCategories() {
  const [list, setList] = useState<Category[]>([]);

  useEffect(() => {
    if (list) {
      axios.get('http://localhost:8080/api/v1/categories').then((res) => {
        const allCategories: Category[] = res.data;
        setList(allCategories);
      });
    }
  }, []);

  return (
    <>
      <div style={boardStyle}>Select category</div>
      <UpdateCategories categoryArray={list} />
    </>
  );
}
export default ViewAllCategories;
