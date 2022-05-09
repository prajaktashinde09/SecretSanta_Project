import React from "react";
import axios from 'axios';
import { withRouter } from 'react-router-dom';


class EditProductComponent extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      pid: null,
      giftname: "",
      quantity: "",
      price: ""
    };

    this.onChangeProductName = this.onChangeProductName.bind(this);
    this.onChangeQuantity = this.onChangeQuantity.bind(this);
    this.onChangePrice = this.onChangePrice.bind(this);
    this.onSubmit = this.onSubmit.bind(this);


  }

  componentDidMount() {
    fetch('/')
      
      // .then(data => this.setState({
    
      //   pid: data.pid,
      //   giftname: data.giftname,
      //   quantity: data.quantity,
      //   price: data.price

      // })

      .then(data => (
        console.log("fetch data : ",data)
      ))
  };


  onChangeProductName(e) {
    this.setState({
      giftname: e.target.value
    });
  }

  onChangeProductId = (e) => {
    this.setState({
      pid: e.target.value
    });
  }

  onChangeQuantity(e) {
    this.setState({
      quantity: e.target.value
    })
  }

  onChangePrice(e) {
    this.setState({
      price: e.target.value
    })
  }

  onSubmit = (e, state) => {
    e.preventDefault();
    console.log(this.state)
    //  let id =`${this.state.pid}`
    let id = this.props.mainId;


    axios.post(`/editproduct/${+id}`, {
        productName : this.state.giftname,
        quantity : this.state.quantity,
      price: this.state.price
    })
      .then(function (response) {
        console.log(response);
        this.props.history.push('/products')//productlist.js
      })
      .catch(function (error) {
        console.log(error);
      });
  }


  render() {
    return (
      <div style={{ marginTop: 10 }}>
        <h3 align="center">Update Product</h3>
        <form onSubmit={this.onSubmit}>
          <div className="form-group">
            <label>Gift Id: </label>
            <input
              type="text"
              className="form-control"
              value={this.props.mainId}
              onChange={this.onChangeProductId}
            />
          </div>
          <div className="form-group">
            <label>Gift Name: </label>
            <input
              type="text"
              className="form-control"
              value={this.state.giftname}
              onChange={this.onChangeProductName}
            />
          </div>
          <div className="form-group">
            <label>Quantity: </label>
            <input type="text"
              className="form-control"
              value={this.state.quantity}
              onChange={this.onChangeQuantity}
            />
          </div>
          <div className="form-group">
            <label>Price: </label>
            <input type="text"
              className="form-control"
              value={this.state.price}
              onChange={this.onChangePrice}
            />
          </div>
          <div className="form-group">
            <input type="submit"
              value="Update Product"
              className="btn btn-primary" />
          </div>
        </form>
      </div>
    );
  }
}

export default withRouter(EditProductComponent);