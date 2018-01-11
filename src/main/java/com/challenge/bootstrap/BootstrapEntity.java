package com.challenge.bootstrap;

import com.challenge.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.utility.OrdersUtility;

import java.util.List;

@Component
public class BootstrapEntity {
	
	@Autowired
	private OrdersUtility OrdersUtility; 
	
	public List<Order> bootStrapOrders(String inputFileName) {
		return OrdersUtility.readOrders(inputFileName);
	}
}
