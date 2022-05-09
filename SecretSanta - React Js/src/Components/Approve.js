import React from 'react';
import Axios from 'axios';
import Navbar3 from './Navbar3';

class Approve extends React.Component{
    state = {
        supplierList:[],
        sid:[]
      }

      componentDidMount()
      {
        Axios.get("/getlist")
       
        .then((res) => {
          console.log("Axios Response => ", res.data);
          this.setState({supplierList:res.data});
          console.log("state => ", this.state.supplierList);

        })
        .catch((err) => {
          console.log("Axios err => ", err)
        })
          
      }
      handleDestination(event) {
        const options = this.state.sid;
        let index;
        if (event.target.checked) {
          options.push(+event.target.value);
        } else {
          index = options.indexOf(+event.target.value);
          options.splice(index, 1);
        }
        this.setState({ sid: options });
        console.log(this.state);
      }

      handleButton(event) {
        event.preventDefault();
        console.log("in handlebutton");
        console.log("selected list id: ",this.state.sid);
        
        Axios.post('/getSidArray',this.state.sid)
        .then(res => (
          console.log("status is: " , res.data)
        ))

        window.location.reload(false);
      }
     
      render(){
        return(
            <center>
               <Navbar3 />
            <table border="2px">
                <tr>
                    <th>ID</th>
                    <th>Gift Name</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>ImagePath</th>
                    <th>Quantity</th>
                    <th>Gift For</th>
                    <th>Occasion</th>
                    <th>Select Items</th>
                </tr>
                <tr>
                    
                </tr>
                 {this.state.supplierList.map(product => (
                   
                 <tr>
                     <td>{product.supplierId}</td>
                     <td>{product.productName}</td>
                     <td>{product.description}</td>
                     <td>{product.categoryId}</td>
                     <td>{product.price}</td>
                     <td><img src={product.imagePath} style={{height:"100px",width:"100px"}}/></td>
                     <td>{product.quantity}</td>
                     <td>{product.giftId}</td>
                     <td>{product.occasionId}</td>
                     {/* <td>{product.discountoffer}</td> */}
                     {/* <td>{product.offerprice}</td> */}
                     <td>
                <input
                  type="checkbox"
                  name="dest"
                  value={product.supplierId}
                  onClick={event => this.handleDestination(event)}
                />
              </td>
                 </tr>
                 ))
                 }
            </table>
            <input
          type="submit"
          value="approve"
          onClick={event => this.handleButton(event)}
        />
            </center>
        )
    }
}
export default Approve;