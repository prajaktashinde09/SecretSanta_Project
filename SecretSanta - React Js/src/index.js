import ReactDOM from 'react-dom';
import React from 'react'
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import About from "./Components/about";
import Home from "./App";
import Navbar from "./Components/Navbar";
import "bootstrap/dist/css/bootstrap.min.css";
import Navbar2 from './Components/Navbar2.js'
import './index.css';
import Feedback from './Components/feedback';
import * as serviceWorker from './serviceWorker';
import RegistrationForm1 from './Components/Reg.js';
import Supplier from './Components/Supplier.js';
import LoginForm1 from './Components/Log.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import Men from './Components/Men';
import Kids from './Components/Kids';
import Birthday from './Components/Birthday';
import Anniversary from './Components/Anniversary';
import Women from './Components/Women';
import Couples from './Components/Couples';
import HouseWarming from './Components/HouseWarming';
import Festival from './Components/Festival';
import Footer from './Components/Footer';

import Offers from './Components/Offfers';

import Admin from './Components/Admin';
import Logout from './Components/Logout';
import ShowCart from './Components/ShowCart';
import OfferPage from './Components/OfferPage'; 
import PerfectGiftPage from './Components/PerfectGiftPage';
import ProductList from './Components/ProductList';
import Approve from './Components/Approve';
import AddOffer from './Components/AddOffer'
import './index.css'



  function App1() {
    return (
     
        
        <div class="body1"> 
      <Router>
        <div className="App1">
          <Navbar2/>
          <Navbar />
          
      {/* <Carousel1 /> */}
        
          <div >
            <Switch>
             
              <Route path="/about" component={About} />
              <Route path="/admin" component={Admin} />
              {/* <Route path="/contact" component={Contact} /> */}
              <Route path="/Login" component={LoginForm1} />
              <Route path="/LogOut" component={Logout} />
              
              <Route path="/ShowCart" component={ShowCart} />
              {/* <Route path="/Registration" component={RegistrationForm} /> */}
              <Route path="/Registration" component={RegistrationForm1} /> 
              <Route path="/Supplier" component={Supplier} /> 
              <Route path="/Feedback" component={Feedback} />
              
              <Route path="/PefectGiftage" component={PerfectGiftPage} />
              <Route path="/OfferPage" component={OfferPage} />


              <Route  path='/products' component={ProductList} />
              <Route  path='/approve' component={Approve} />
              <Route  path='/addoffer' component={AddOffer} />
             
            </Switch>
          </div>
       
         
          <div>
            <Switch>
             
              <Route path="/Men" component={Men} />
              <Route path="/Women" component={Women} />
              <Route path="/Kids" component={Kids} /> 
              <Route path="/Birthday" component={Birthday} />
              <Route path="/Couples" component={Couples} />
              <Route path="/Anniversary" component={Anniversary} />
              <Route path="/Festival" component={Festival} />
              <Route path="/HouseWarming" component={HouseWarming} /> 
              <Route path="/Offers" component={Offers} /> 
              <Route exact path="/" component={Home}/>   
           </Switch>
          </div>
        </div>
      </Router>
     
     
      </div>
    
        
         
     
      
    );
  }


  // ReactDOM.render(< Navbar2 />, document.getElementById('root'));
  ReactDOM.render(< App1 />, document.getElementById('root'));
  // ReactDOM.render(<App />, document.getElementById('middle'));
  //ReactDOM.render(<Login />, document.getElementById('middle'));


// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
