import './App.css';
import React, { Component } from "react";
import GiftPage from './Components/GiftPage';
import { Container } from 'react-bootstrap';
import OfferPage from './Components/OfferPage';
import PerfectGiftPage from './Components/PerfectGiftPage';
import Carousel1 from './Components/carousel';
import ProductTable from './Components/ProductList';


import Approve from './Components/Approve';





export default class Home extends Component {
  render() {
    return (
      <div>
        
        <Container>
        {/* <Carousel1 /> */}
          <GiftPage/> 
          {/* <OfferPage/> */}
        </Container>
       

      </div>
    );
  }
}

