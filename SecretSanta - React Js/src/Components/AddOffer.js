import React from 'react';
import Axios from 'axios';
import Navbar3 from './Navbar3';

class AddOffer extends React.Component{
    state = {
        supplierList:[],
        sid:[],
      }

      componentDidMount()
      {
        Axios.get("/giftListOffer")
       
        .then((res) => {
          console.log("Axios Response => ", res.data);
          this.setState({supplierList:res.data});
          console.log("state => ", this.state.supplierList);

        })
        .catch((err) => {
          console.log("Axios err => ", err)
        })
          
      }
      //multiple selected product ids
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

      //selected offer value is pushed
      handleChange = (event) => {
        const options = this.state.sid;
        options.push(+event.target.value);
        this.setState({ sid: options });
        console.log(this.state);

    }

//send array of id and offer to backend
      handleButton(event) {
        event.preventDefault();
        console.log("in handlebutton");
        console.log("selected  list id: ",this.state.sid);
        
        Axios.post('/addOffer',this.state.sid)
        .then(res => (
          console.log("status is: " , res.data)
        ))
      }

    //   handleClick = (gifts, offer) => {
    //     let object = { ...gifts, offer }
    //     console.log("================================>",object);

    //     axios.post('http://localhost:8000/addoffer', object).then(function (response) {
    //         console.log(response.data);
    //         //    this.props.history.push('/gifts')
    //     })
    //         .catch(function (error) {
    //             console.log(error);
    //         });
    // }
     
      render(){
        return(
            <div>
               <Navbar3 />
            <table border="1" align="cneter">
                <tr>
                    <th>ID</th>
                    <th>Gift Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>ImagePath</th>
                    <th>Select Items</th>
                </tr>
                <tr>
                    
                </tr>
                 {this.state.supplierList.map(product => (
                   
                 <tr>
                     <td>{product.product_id}</td>
                     <td>{product.product_name}</td>
                     <td>{product.description}</td>
                     <td>{product.price}</td>
                     <td><img src={product.img} style={{height:"100px",width:"100px"}}/></td>
                     <td>
                <input
                  type="checkbox"
                  name="dest"
                  value={product.product_id}
                  onClick={event => this.handleDestination(event)}
                />
              </td>
                 </tr>
                 ))
                 }
            </table>
               
                <select value="0"
                    value={this.state.offer}
                    onChange={e => this.handleChange(e)}>

                    <option value="30">No Offer</option>
                    <option value="50">30 % off</option>
                    <option value="70">50 % off</option>

                </select>
        
                <br></br>

                <input
                    type="submit"
                    value="Add offers"
                    onClick={event => this.handleButton(event)}
                />
                                
  
            </div>
        )
    }
}
export default AddOffer ;