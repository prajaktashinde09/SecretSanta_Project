import React from "react";
import '../CSS/index.scss';
import '../CSS/reg.css';
import { MDBCarousel, MDBCarouselCaption, MDBCarouselInner, MDBCarouselItem, MDBView, MDBMask, MDBContainer } from
"mdbreact";

const Carousel1 = () => {
  return (
    <MDBContainer className='m-0 p-0  carousel carousel-inner carousel1'  fluid>
      <MDBCarousel
      activeItem={1}
      length={3}
      showControls={true}
      showIndicators={true}
      className="z-depth-1"
    >
      <MDBCarouselInner>
        <MDBCarouselItem itemId="1">
          <MDBView>
            <img
              className="d-block w-100"
              src={require('../Images/c1.jpg')}
              alt="First slide"
            />
          <MDBMask overlay="black-slight" />
          </MDBView>
          <MDBCarouselCaption>
            <h3 className="h4-responsive">Best Gift shop</h3>
            <p>Shop here</p>
          </MDBCarouselCaption>
        </MDBCarouselItem>

        <MDBCarouselItem itemId="2">
          <MDBView>
            <img
              className="d-block w-100"
              src={require('../Images/c7.jpg')}
              alt="Second slide"
            />
          <MDBMask overlay="black-slight" />
          </MDBView>
          <MDBCarouselCaption>
            <h3 className="h4-responsive">Gift for every occasion</h3>
            <p>Shop here</p>
          </MDBCarouselCaption>
        </MDBCarouselItem>
        
        <MDBCarouselItem itemId="3">
          <MDBView>
            <img
              className="d-block w-100"
              src={require('../Images/c6.jpg')}
              alt="Third slide"
            />
          <MDBMask overlay="black-slight" />
          </MDBView>
          <MDBCarouselCaption>
            <h3 className="h4-responsive">Upto 70% off</h3>
            <p>Shop here</p>
          </MDBCarouselCaption>
        </MDBCarouselItem>
      </MDBCarouselInner>
    </MDBCarousel>
    </MDBContainer>
  );
}


export default Carousel1;

// import React from "react";
// import c1 from './c1.jpg';
// import c2 from './c2.jpg';
// import c3 from './c3.jpg';
// import Carousel from 'nuka-carousel';


// export default class Carousel1 extends React.Component{
//     render(){
//         return(
//         <>
//          <Carousel>
//         <img src={require('./c1.jpg')} />
//         <img src={require('./c4.jpg')} />
//         <img src={require('./c.jpg')} />
//         <img src={require('./c1.jpg')} />
//         <img src={require('./c1.jpg')} />
//         <img src={require('./c1.jpg')} />
//       </Carousel>
//         </>);
//     }

// }
