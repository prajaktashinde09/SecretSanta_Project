import React from 'react';
import '../index.css';


export default class Footer extends React.Component {
    render(){
        return(
            <>
            <body>
                <div class="footer">
               
                <p><span class="fa fa-twitter fa-2x"> </span>
                <span class="fa fa-facebook fa-2x"></span>
                <span class="fa fa-linkedin fa-2x"></span>
                <span class="fa fa-youtube fa-2x"></span></p>

                <p class="p1">Copyright:
                <span class="glyphicon glyphicon-copyright-mark"></span>
                <span>secretsanta@cybage.com</span>
                </p>
                
                </div>
            </body>
            </>
        );
    }

}
// import React from "react";
// import './index.css';
// import { MDBCol, MDBContainer, MDBRow, MDBFooter } from "mdbreact";

// const Footer = () => {
//   return (
//     <MDBFooter  className="font-small pt-4 mt-4 Fcolor">
//       <MDBContainer fluid className="text-center text-md-left">
//         <MDBRow>
//           <MDBCol md="6">
//             <h3 className="title">Let Us Help You</h3>
//             <ul>
//             <li className="list-unstyled">
//                 <a href="#!">Your Account</a>
//               </li>
//               <li className="list-unstyled">
//                 <a href="#!">Returns Centre</a>
//               </li>
//               <li className="list-unstyled">
//                 <a href="#!">Help</a>
//               </li>
              
//             </ul>
//           </MDBCol>
//           <MDBCol md="6">
//             <h3 className="title">Get to Know Us</h3>
//             <ul>
//             <li className="list-unstyled">
//                 <a href="#!">Home</a>
//               </li>
//               <li className="list-unstyled">
//                 <a href="#!">AboutUs</a>
//               </li>
//               <li className="list-unstyled">
//                 <a href="#!">ContactUs</a>
//               </li>
              
//             </ul>
//           </MDBCol>
//         </MDBRow>
//       </MDBContainer>
//       <div className="footer-copyright text-center py-3">
//         <MDBContainer fluid>
//           &copy; {new Date().getFullYear()} Copyright
//         </MDBContainer>
//       </div>
//     </MDBFooter>
//   );
// }

