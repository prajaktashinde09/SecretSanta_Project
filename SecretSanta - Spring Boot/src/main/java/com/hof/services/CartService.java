package com.hof.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hof.domain.OrderDetails;
import com.hof.domain.Orders;
import com.hof.domain.Product;
import com.hof.domain.User;
import com.hof.domain.dto.Cart;
import com.hof.repository.OrdersDetailsRepository;
import com.hof.repository.OrdersRepository;
import com.hof.repository.ProductRepository;
import com.hof.repository.UserRepository;

@Service
public class CartService implements ICartService {
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired 
	ProductRepository productRepository;
	
	@Autowired 
	OrdersRepository orderRepository;
	
	@Autowired
	OrdersDetailsRepository orderDetialsRepository;

	@Override
	public User getUserData(Integer userId) {
		Optional<User> u = userRepository.findById(userId);
		
		return u.get();
	}

	@Override
	public Product getSingleProductData(Integer productId) {
		
		return productRepository.getOne(productId);
	}

	@Override
	public boolean checkUserPrevOrderExistsInOrderTable(User user) {
		
		Orders orders = orderRepository.findByUser(user);
		//System.out.println("orders ==== "+orders.toString());
		if(orders == null)
			return true;
		
		return false;
	}

	@Override
	public Orders addNewOrder(Orders o) {
		
		return orderRepository.save(o);
		
		
	}

	@Override
	public Orders getPrevOrderFromOrderTable(User user) {
		
		return orderRepository.findByUser(user);
	}

	@Override
	public OrderDetails addOrderDetails(OrderDetails orderDetails) {
		
		return orderDetialsRepository.save(orderDetails);
	}

	@SuppressWarnings("unchecked")
	public List<Cart> showCart(Orders orders) {
		List<OrderDetails> odlist = orderDetialsRepository.findByorder(orders); 
		List<Cart> prodlist=new ArrayList(); 
		
		for (OrderDetails od : odlist) {
			
			Cart cart =new Cart();
			cart.setPrice(od.getProduct().getPrice());
			cart.setProductName(od.getProduct().getProductName());
			cart.setQuantity(od.getProductQuantity());
			if(od.getProduct().getOffer() != null)
			{
				cart.setOffer(od.getProduct().getOffer());
			}
			else
				cart.setOffer(0);
			
			cart.setImage(od.getProduct().getImagePath());
			prodlist.add(cart);
			
			System.out.println("product details");
		}
		
		
		
		return prodlist;
	}

	
	

	

}
