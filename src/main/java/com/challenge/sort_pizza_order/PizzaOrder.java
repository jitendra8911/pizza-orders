package com.challenge.sort_pizza_order;


import com.challenge.entity.Order;
import com.challenge.storage.StorageProperties;
import com.challenge.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.challenge.bootstrap.BootstrapEntity;

import com.challenge.utility.SortUtility;
import com.challenge.utility.OrdersUtility;

import java.util.List;

@SpringBootApplication

@ComponentScan("com.challenge.bootstrap")
@ComponentScan("com.challenge.utility")
@ComponentScan("com.challenge.storage")
@ComponentScan("com.challenge.controller")
@EnableConfigurationProperties(StorageProperties.class)
public class PizzaOrder {
	
	public static void main(String[] args) throws ClassNotFoundException {
		ApplicationContext ctx = SpringApplication.run(PizzaOrder.class, args);

		
		BootstrapEntity bootstrap = ctx.getBean(BootstrapEntity.class);
		
		List<Order> inputOrders = bootstrap.bootStrapOrders(args[0]);
		
		SortUtility sortUtility = ctx.getBean(SortUtility.class);
		List<Order> sortedOrders = sortUtility.sortOrders(inputOrders);
		
		OrdersUtility ordersUtility = ctx.getBean(OrdersUtility.class);
		ordersUtility.writeOrders(args[1], sortedOrders);
		
	  }

	@Bean
	Runnable init(StorageService storageService) {
		return () -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
	}

