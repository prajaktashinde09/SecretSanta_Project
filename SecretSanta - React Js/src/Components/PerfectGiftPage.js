import React from 'react';
import Axios from 'axios';
import { Card, Image } from 'semantic-ui-react';

class AddOffer extends React.Component{
    state = {
        supplierList:[],
        sid:[],
        giftfor:null,
        occasion:null,
        category:null,
        session: false,
        userId: 0,
        productId: [],
        msg:""
      }

     
        //selected giftfor value is pushed
      handleChange = (event) => {
        const options = this.state.sid;
        this.setState({ giftfor: (+event.target.value) });
        options.push(+event.target.value);
        this.setState({ sid: options });
        console.log(this.state.sid);


    }

   //selected occasion value is pushed
    handleChangeSecond = (event) => {
        const options = this.state.sid;
        this.setState({occasion: (+event.target.value) });
        options.push(+event.target.value);
        this.setState({ sid: options });
        console.log(this.state.sid);

    } 

     //selected category value is pushed
    handleChangeThird = (event) => {
        const options = this.state.sid;
        this.setState({ category: (+event.target.value) });
        options.push(+event.target.value);
        this.setState({ sid: options });
        console.log(this.state.sid);
    }

//send giftfor, category and occasion  to backend 
      handleButtonSubmit(event) {

        console.log("state === > ",this.state.sid);

        Axios.post("/perfectGiftPage",this.state.sid)
       
        .then((res) => {
          console.log("Axios Response => ", res.data);
          this.setState({supplierList:res.data});
          console.log("state => ", this.state.supplierList);

        })
        .catch((err) => {
          console.log("Axios err => ", err)
        })
        this.setState({ sid: [] });

      }

      ///add to cart
  handleButton(event,x) {
    //1.islogged in or not
    //2.
   event.preventDefault();
    console.log(x);
    console.log("in handlebutton i= ", x);
    let user_id = Number(localStorage.getItem('userSessionId')); ;
    if (localStorage.getItem('userSessionId')) {
      const options = this.state.productId;
      console.log("user is logged in");
      options.push(x);
      options.push( user_id);
      this.setState({ productId: options });
      console.log("add to cart state: ",this.state)

      Axios.post('/addToCart',this.state.productId)
        .then((res) => {
          this.setState({ msg: res.data })
          console.log("status is: " , res.data)  
        })
        alert(this.state.msg);
    }//end of if loop
    else {
      alert("Please Login for adding products into cart");
      console.log("Please Login for adding products into cart");
    }

  }//end of handlebutton
   
     
      render(){
        return(
            <div>
                {/*  GiftFor */}
                <select value="1"
                value={this.state.giftfor}
                    onChange={e => this.handleChange(e)}>
                    <option value="0" >select</option>
                    <option value="1" >1.Men</option>
                    <option value="2">2.Women</option>
                    <option value="3">3.Infants</option>
                    <option value="4">4.Kids</option>
                    <option value="5">5.Couples</option>
                    <option value="6">6.Generalized</option>

                </select>
        
                <br></br>
                 {/*  Occasion */}
                <select value="1"
                 value={this.state.occasion}
                    onChange={e => this.handleChangeSecond(e)}>
                    <option value="0" >select</option>
                    <option  value="1">1.Birthday</option>
                    <option value="2">2.Anniversary</option>
                    <option value="3">3.Festival</option>
                    <option value="4">4.HouseWarming</option>
                    <option value="5">5.AllOccasions</option>

                </select>
                
                <br></br>
             {/*  Category */}
                <select value="1"
                   value={this.state.category}
                    onChange={e => this.handleChangeThird(e)}>
                    <option value="0" >select</option>
                    <option value="1" >1.Gourmet</option>
                    <option value="2">2.Cakes</option>
                    <option value="3">3.Toys</option>
                    <option value="4">4.Flowers</option>
                    <option value="5"> 5.Fashion</option>
                    <option value="6"> 6.Personalizedf</option>
                    <option value="7">7.Games</option>
                    <option value="8">8.Home</option>

                </select>

                <input
                    type="submit"
                    value="Find"
                    onClick={event => this.handleButtonSubmit(event)}
                />

<div >
        {
          this.state.supplierList.map(product => (
            <Card  >
              <Image src='https://www.w3schools.com/images/picture.jpg' wrapped ui={false} />
              <Card.Content>
                <Card.Header>{product.product_name}</Card.Header>
                <Card.Meta>
                  {product.description}
                </Card.Meta>
                <Card.Description>
                  {product.price}
                </Card.Description>
              </Card.Content>
              <Card.Content extra>
                <a>

                  <input
                    type="submit"
                    value="Add To Cart"
                    onClick={(event,i) => this.handleButton(event,product.product_id)} />

                </a>
              </Card.Content>
            </Card>
          ))
        }
        {/* <Card>
      
        </Card>
         */}

      </div>
            
            </div>
        )
    }
}
export default AddOffer ;