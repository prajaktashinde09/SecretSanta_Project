import React from 'react';
import Axios from 'axios';
import{ browserHistory } from 'react-router';

class Approve extends React.Component{
    state = {
        supplierList:[],
        userId: 0,
        bill: 0
      }
 
      calculateBill = (supplierList) =>{
        let options = this.state.bill;
        supplierList.forEach(supplierList => {
           
           options = options + (supplierList.price-((supplierList.price * supplierList.offer )/100))
         });
        this.setState({ bill: options }); 
        console.log("bill =  ",this.state.bill)
          
      }
      componentDidMount()
      {
        let id = Number(localStorage.getItem('userSessionId'));
        console.log("user id in show cart =>",this.state.userId)
        Axios.get(`/showCart/${+id}`)
        .then((res) => {
          console.log("Axios Response => ", res.data);
          this.setState({supplierList:res.data});
          console.log("state => ", this.state.supplierList)
          this.calculateBill(this.state.supplierList)
        })
        .catch((err) => {
          console.log("Axios err => ", err)
        })
        

        
      }     
      handleButton(event) {
        event.preventDefault();
        console.log("in handlebutton");
        const path = '/Feedback'
        browserHistory.push(path);
        window.location.reload(false);
      }

      
      render(){
        
        return(
            <center>
            <table border="2px">
                <tr>
                    <th>Gift Name</th>
                    <th>ImagePath</th>
                    <th>Quantity</th>
                    <th>Offer Price</th>
                    <th>Price</th>
                </tr>
                 {this.state.supplierList.map((product) => (
                  
                 <tr>
                     <td>{product.productName}</td>
                     <td><img src={product.image} style={{height:"50px",width:"50px"}}/></td>
                     <td>{product.quantity}</td>  
                     <td>{product.offer}</td> 
                     <td>{product.price}</td>
                 </tr>
                
                 )//end
                  
                 )
                 
                 }
                
                 <tr><td><br></br></td><td><br></br></td><td><br></br></td><td>Total cost </td><td> € {this.state.bill}</td></tr>
            </table>
           <br></br>
            <input type="submit"  value="CheckOut" onClick={event => this.handleButton(event)}
        />
            </center>
        )
    }
}
export default Approve;