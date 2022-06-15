import { Col, Row } from "antd";
import CategoryButton from "./CategoryButton";


interface Category {
    categoryArray:{
        categoryName: string;
        id: number;
    }[]
    }
  
function UpdateCategories(props: Category){
    const cols = [];
    const colCount = props.categoryArray.length;
 
    console.log(props.categoryArray);

    for (let i = 0; i < colCount; i++) {
        cols.push(
        <Col key={i.toString()} span={6}>
            <CategoryButton buttonName={props.categoryArray[i].categoryName} routingPath="/" />
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
export default UpdateCategories;