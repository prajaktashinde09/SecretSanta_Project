
import React from 'react';
import Axios from 'axios';
//import { Card,  Image } from 'semantic-ui-react';
import { Card, Button, Col, Row, Container } from 'react-bootstrap';

class GiftPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      giftList: [],
      session: false,
      userId: 0,
      productId: [],
      msg:""
    
    }
  };

  

  componentDidMount() {
    Axios.get("/OfferPage")
      .then((res) => {
        console.log("Axios Response => ", res.data);
        this.setState({ giftList: res.data });
        console.log("state => ", this.state.giftList);
      })
      .catch((err) => {
        console.log("Axios err => ", err)
      })

  }
 
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

  render() {
    return (
      <div >
      {
        <Container >

          <Row >
            {this.state.giftList.map((product) =>
              <Col md={4} key={product.id}>
                <Card style={{ width: '18rem', margin: '1rem' }} >
                  <Card.Body>
                    <Card.Title>{product.product_name}</Card.Title>
                    <Card.Img variant="top" src={product.imagePath} alt="img" />
                    <Card.Text>{product.description}</Card.Text>
                    <Card.Text>{product.price}</Card.Text>
                    <Card.Text> Get {product.offer} % off !!!+</Card.Text>
                    <input
                      type="submit"
                      value="Add To Cart"
                      onClick={(event, i) => this.handleButton(event, product.product_id)} />

                  </Card.Body>
                </Card>
              </Col>

            )}
          </Row>
        </Container>
      }
     

    </div>
    )
  }
}


export default GiftPage;


