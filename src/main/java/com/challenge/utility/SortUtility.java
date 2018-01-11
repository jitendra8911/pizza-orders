package com.challenge.utility;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.Entity.Order;

@Component
public class SortUtility {

	public SortUtility() {

	}

	public SortUtility(List<Order> inputOrders) {
		this.inputOrders = inputOrders;

	}
	@Resource(name="inputOrders")
	private List<Order> inputOrders;
	
	@Resource(name="sortedOrders")
	private List<Order> sortedOrders;
	
	public void sortOrders() {
		Comparator<Order> byEpoch = Comparator.comparing(Order::getEpoch).reversed();
        Comparator<Order> byName = (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName());
        sortedOrders.addAll(inputOrders.stream().sorted(byEpoch.thenComparing(byName)).collect(Collectors.toList()));
        System.out.println("after sorting");
        System.out.println(sortedOrders);
	}

}
