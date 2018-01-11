package com.challenge.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.utility.OrdersUtility;

@Component
public class BootstrapEntity {
	
	@Autowired
	private OrdersUtility OrdersUtility; 
	
	public void bootStrapOrders(String inputFileName) {
		OrdersUtility.readOrders(inputFileName);
	}
}
