package com.challenge.sort_pizza_order;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.challenge.bootstrap.BootstrapEntity;

import com.challenge.utility.SortUtility;
import com.challenge.utility.OrdersUtility;

@SpringBootApplication

@ComponentScan("com.challenge.config")
@ComponentScan("com.challenge.bootstrap")
@ComponentScan("com.challenge.utility")
public class PizzaOrder {
	
	public static void main(String[] args) throws ClassNotFoundException {
		ApplicationContext ctx = SpringApplication.run(PizzaOrder.class, args);

		
		BootstrapEntity bootstrap = ctx.getBean(BootstrapEntity.class);
		
		bootstrap.bootStrapOrders(args[0]);
		
		SortUtility sortUtility = ctx.getBean(SortUtility.class);
		sortUtility.sortOrders();
		
		OrdersUtility ordersUtility = ctx.getBean(OrdersUtility.class);
		ordersUtility.writeOrders(args[1]);
		
	  }	
	}

