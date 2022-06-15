import axios from 'axios';
import UpdateCategories from './UpdateCategories';
import { useEffect, useState } from 'react';

const boardStyle = { 
  background: 'white',
  paddingTop: '30px',
  textAlign: 'center',
} as const;

interface Category {
        categoryName: string;
      id: number;
  }

function ViewAllCategories() {

  const [list, setList] = useState<Category[]>([]);

  useEffect(function effectFunction() {

    if (list) {

      axios.get('http://localhost:8080/api/v1/categories')
      .then(res => {
        const allCategories: Category[] = res.data;
        setList(allCategories);
      }) 

    }

}, []);

  
  return (
    <>
      <h1 style={{
        background: 'white',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        height: '20vh',
      }}
      >
        Select category
      </h1>
      <UpdateCategories categoryArray={list}/>
    </>
    
  );
}
export default ViewAllCategories;