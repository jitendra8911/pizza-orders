package com.challenge.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.challenge.Entity.Order;

@Configuration
public class AppConfig {

	@Bean(name="inputOrders")
	public static List<Order> getInputOrders() {
		List<Order> orders = new ArrayList();
		return orders;
	}
	
	@Bean(name="sortedOrders")
	public static List<Order> getSortedOrders() {
		List<Order> orders = new ArrayList();
		return orders;
	}
}
