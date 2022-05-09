import React from 'react'
import '../index.css'

export default class Navebar2 extends React.Component{
    state = {
        productName:"toy"
      }
    render(){
        const { productName
            , } = this.state;
        return(
            <>
            <head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></link>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"></link>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
            <header>
                
                <div>
                <img src={require('../Images/santa_logo_1.jpg')}  height="5%" width="5%"/>
                <div class="search-container">
                        <input type="text" placeholder="Search.." 
                        name="search" size="55" 
                        
                        ></input>
                        <button type="submit"><i class="fa fa-search "aria-hidden="true"></i></button>
                        <p> <span class="glyphicon glyphicon-envelope"></span>secretsanta@customercare.com &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-shopping-cart"></span></p>    
                       
                       
                </div>
                </div>
            </header>
            </>
        );
    }
}