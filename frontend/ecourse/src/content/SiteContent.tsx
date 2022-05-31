import React from 'react';
import {
  Button, Layout,
  Collapse,
} from 'antd';
import { FolderFilled } from '@ant-design/icons';

const { Panel } = Collapse;

const { Content } = Layout;
const contentStyle = {
  textAlign: 'center',
  height: '100vh',
} as const;

// function startLayout() {
//   return (
//     <Content style={contentStyle}>
//       <h1 style={{ paddingTop: '10px' }}>Welcome to our page! Check out avaiable courses!</h1>
//       <div style={{
//         display: 'flex',
//         alignItems: 'center',
//         justifyContent: 'center',
//         height: '20vh',
//       }}
//       >
//         <div style={{
//           lineHeight: '30px',
//           border: '2px solid black',
//           borderRadius: '10px',
//           padding: '5px',
//           width: '20%',
//         }}
//         >
//           <Button type="text" shape="circle">
//             <FolderFilled style={{ fontSize: '40px' }} />
//           </Button>
//           <Button
//             shape="circle"
//             style={{ fontSize: '30px', textAlign: 'center' }}
//             type="text"
//           >
//             {' '}
//             My Learning
//             {' '}

//           </Button>
//         </div>
//       </div>

//     </Content>
//   );
// }

function categoryLayout() {
  return (
    <Content style={contentStyle}>
      <h1 style={{ paddingTop: '10px' }}>Choose a course from the available ones</h1>
      <div style={{
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        height: '20vh',
        background: 'pink',
      }}
      >

        <div style={{
          display: 'block', width: 700, padding: 30,
        }}
        >
          <Collapse>
            <Panel header="GeeksforGeeks" key="1">

              <p>Greetings from GeeksforGeeks</p>

            </Panel>
            <Panel header="Computer Science" key="2">

              <p>This is Best computer Science Portal</p>

            </Panel>
          </Collapse>
        </div>

      </div>

    </Content>
  );
}

function SiteContent() {
  return (categoryLayout());
}

export default SiteContent;
