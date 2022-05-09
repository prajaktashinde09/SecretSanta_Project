package com.hof.services;

import com.hof.domain.OrderDetails;
import com.hof.domain.Orders;
import com.hof.domain.Product;
import com.hof.domain.User;

public interface ICartService {

	User getUserData(Integer userId);

	Product getSingleProductData(Integer productId);

	boolean checkUserPrevOrderExistsInOrderTable(User u);

	Orders addNewOrder(Orders o);

	Orders getPrevOrderFromOrderTable(User user);

	OrderDetails addOrderDetails(OrderDetails orderDetails);
	
	
	
	

}
