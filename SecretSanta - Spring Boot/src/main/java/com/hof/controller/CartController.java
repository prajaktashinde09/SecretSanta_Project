package com.hof.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hof.domain.OrderDetails;
import com.hof.domain.Orders;
import com.hof.domain.Product;
import com.hof.domain.User;
import com.hof.domain.dto.Cart;
import com.hof.domain.dto.CommonResponseDto;
import com.hof.services.CartService;
import com.hof.services.ICartService;
import com.hof.services.ProductService;

@RestController
public class CartController {
	
	@Autowired
	ProductService productService;
	
	
	@Autowired 
	CartService cartService;
	
	float price=0;
	List<OrderDetails> showCart = new ArrayList();
	//add to cart; 
	@PostMapping("/addToCart")
	public String addToCart(@RequestBody String sid ){
		List<Integer> numlist=new ArrayList();
		System.out.println("sid: "+sid);
		String strNew = sid.substring(1, sid.length()-1);
		
		String array1[]= strNew.split(",");
		
		for (String temp: array1){
		      System.out.println(temp);
		      numlist.add(Integer.parseInt(temp));  
		}
		Integer productID = numlist.get(0);
		Integer userID = numlist.get(1);
		
		CommonResponseDto commonResponseDto = new CommonResponseDto();
		User user = this.cartService.getUserData(userID);
		Product product= this.cartService.getSingleProductData(productID);
		System.out.println("product id= "+productID);
		System.out.println("user id= "+ userID);
		
		//1.check if user logged in not
		
			//2.check user has previus order or not from order table
			if(cartService.checkUserPrevOrderExistsInOrderTable(user))
			{
				
				System.out.println("USER DOES NOT HAVE PREVIOUS ORDER");
				
				//create new order for user
				Orders o=new Orders();
				o.setOrderId(0);
				o.setUser(user);
				o.setOrderDate(new Date());
				this.price = price + product.getPrice() ;
				o.setTotalAmount(price);
				//insert into db
				this.cartService.addNewOrder(o);
		
			}
			System.out.println("USER HAVE PREVIOUS ORDER");
			this.price = price + product.getPrice() ;
			
			Orders order=this.cartService.getPrevOrderFromOrderTable(user);
			
			//setting orderDetails tbales values
			
			OrderDetails orderDetails   = new OrderDetails();
			orderDetails.setOrder(order);
			orderDetails.setProduct(product);
			orderDetails.setProductQuantity(1);
			
			this.cartService.addOrderDetails(orderDetails);
			
			commonResponseDto.setResponseCode(1);
			commonResponseDto.setResponseMessage("Product is added Successfully to cart");
			showCart.add(orderDetails);
		return "success add to cart";
	}
	
	
		//show cart
		@GetMapping("/showCart/{id}")//Integer userId
		public List<Cart> showCart(@PathVariable Integer id)
		{
			User user = this.cartService.getUserData(id);
			Orders order=this.cartService.getPrevOrderFromOrderTable(user);
			
			List<Cart> jsonCart = cartService.showCart(order);
			
			return jsonCart;
			
		}
	
	//delete from cart
	@PostMapping("/deleteFromCart")
	public CommonResponseDto deleteProductFromCart( )
	{
		
		return null;
		
	}

}