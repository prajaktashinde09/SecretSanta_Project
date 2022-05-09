import React from "react";
// import "./component/products.css";
import axios from 'axios';
import EditProductComponent from "./editproduct";
import Navbar3 from './Navbar3';

class ProductTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            Products: [],

        };
    }

    componentDidMount() {

    
        axios.get('/productList').then(res => {
            this.setState({ Products: res.data });
        })
    }

    handleClick = productId => {
        let id = productId;
        axios.put(`/delete/${+id}`)
            .then(function (response) {
                console.log(response);
             window.location.reload();
            })
            .catch(function (error) {
                console.log(error);
            });
        }

        sendValue = (e, pid) => {
            e.preventDefault();
            const options = this.state.pid;
            options.push(pid)
            this.setState({ pid: options });
            console.log("id is: ", this.state.pid);
            this.props.history.push('/editproduct/' + this.state.pid);//editcomponet
        };

        render() {
            return (
                <div>
                     <Navbar3 />
                    <table align="center" border="2px">
                        <tbody>
                            <tr>
                                <th>ID</th>
                                <th>Gift Name</th>  
                                <th>Price</th>
                                <th>Image</th>
                                <th>Quantity</th>
                                <th>Offer Price</th>
                                <th>Select </th>

                            </tr>


                            {this.state.Products.map(index => (
                                <tr>
                                    <td>{index.product_id}</td>
                                    <td>{index.product_name}</td>            
                                    <td>Rs.{index.price}</td>
                                    <td><img src={index.imagePath} alt="" style={{height:"100px",width:"100px"}}></img></td>
                                    <td>{index.quantity}</td>
                                    {/* <td>{index.offer}%</td> */}
                                    <td><EditProductComponent mainId={index.product_id} giftname={index.product_name} quantity={index.quantity}
                                        price={index.price} className="btn btn-info" Value="Edit" /></td>
                                    {/* <td><Link to={{ pathname: `/edit/${index.id}`, }}> Edit </Link></td> */}
                                    <td><button onClick={() => this.handleClick(index.pid)} className="btn btn-danger" >Delete</button></td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            );
        }
    }

    export default ProductTable;
