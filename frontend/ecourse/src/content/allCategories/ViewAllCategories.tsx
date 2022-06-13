import CategoryButton from './CategoryButton';
import axios from 'axios';
import { Col, Row} from 'antd';

const boardStyle = {
  background: 'white',
  paddingTop: '30px',
  textAlign: 'center',
} as const;

var x: any;

var categoriesList = [{ categoryName: "Computer Science", id: 1 },
                      { categoryName: "Maths", id: 2 },
                      { categoryName: "Physics", id: 3 },
                      { categoryName: "Computer Science1", id: 1 },
                      { categoryName: "Maths1", id: 2 },
                      { categoryName: "Physics1", id: 3 },
                      { categoryName: "Computer Science2", id: 1 },
                      { categoryName: "Maths2", id: 2 },
                      { categoryName: "Physics2", id: 3 },
                      { categoryName: "Physics", id: 3 },
                      { categoryName: "Computer Science1", id: 1 },
                      { categoryName: "Maths1", id: 2 },
                      { categoryName: "Physics1", id: 3 },
                      { categoryName: "Computer Science2", id: 1 },
                      { categoryName: "Maths2", id: 2 },
                      { categoryName: "Physics2", id: 3 },
                      { categoryName: "Maths2", id: 2 },
                      { categoryName: "Computer Science1", id: 1 },
                      { categoryName: "Maths1", id: 2 },
                      { categoryName: "Physics1", id: 3 },
                      { categoryName: "Computer Science2", id: 1 },
                      { categoryName: "Maths2", id: 2 },
                      { categoryName: "Physics2", id: 3 }];

function updateCategories(){

  const cols = [];
  const colCount = categoriesList.length;
  let colCode = '';
  
  for (let i = 0; i < colCount; i++) {
    cols.push(
      <Col key={i.toString()} span={6}>
        <CategoryButton buttonName={categoriesList[i].categoryName} routingPath="/" />
      </Col>,
    );
  }

  return (
    <>
      <Row gutter={[16, 16]}>
        {cols}
      </Row>
      </>
  );
};

function getCategories() {
  axios.get('http://localhost:8080/api/v1/categories')
      .then(res => {
        x = res.data;
        
        console.log(x);
      })
}

 function ViewAllCategories() {
  //getCategories();

  return (
    <><>
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
    </><>

        {updateCategories()}
      </></>
    
  );
}
export default ViewAllCategories;
