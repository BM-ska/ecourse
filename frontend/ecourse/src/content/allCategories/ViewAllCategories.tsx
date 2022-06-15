import CategoryButton from './CategoryButton';
import axios from 'axios';
import { Col, Row} from 'antd';
import ReactDOM from 'react-dom';
import UpdateCategories from './UpdateCategories';
import { useEffect, useState } from 'react';

const boardStyle = { 
  background: 'white',
  paddingTop: '30px',
  textAlign: 'center',
} as const;

function getCategories() {
  axios.get('http://localhost:8080/api/v1/categories')
      .then(res => {

        //updateCategories(res.data);

        //console.log(categoriesList);
        //return updateCategories();
        var list = [{ categoryName: "Computer Science", id: 1 },
                      { categoryName: "Maths", id: 2 },
                      { categoryName: "Physics", id: 3 },
                      { categoryName: "Computer Science1", id: 1 },
                      { categoryName: "Maths1", id: 2 },
                      { categoryName: "Physics1", id: 3 },
                      { categoryName: "Computer Science2", id: 1 },
                      { categoryName: "Maths2", id: 2 },
                      { categoryName: "Maths2", id: 2 },
                      { categoryName: "Computer Science1", id: 1 },
                      { categoryName: "Maths1", id: 2 },
                      { categoryName: "Physics1", id: 3 },
                      { categoryName: "Computer Science2", id: 1 },
                      { categoryName: "Maths2", id: 2 },
                      { categoryName: "Physics2", id: 3 }];


         return list;             
      })
}

function ViewAllCategories() {

  const [list, setList] = useState<{
    categoryName: string;
    id: number;
}[]>([]);

  useEffect(() => {
      setList(() => getCategories());
  }, [list]);


  getCategories()
  
  // const root = ReactDOM.createRoot(document.getElementById('root'));
  // const allCategories : JSX.Element = <updateCategories categoryArray={list}/>;
  

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