package com.challenge.utility;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.challenge.entity.Order;

@Component
public class SortUtility {

	public List<Order> sortOrders(List<Order> inputOrders) {
		List<Order> sortedOrders;
		Comparator<Order> byEpoch = Comparator.comparing(Order::getEpoch).reversed();
        Comparator<Order> byName = (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName());
        sortedOrders = inputOrders.stream().sorted(byEpoch.thenComparing(byName)).collect(Collectors.toList());
        System.out.println("after sorting");
        System.out.println(sortedOrders);

        return sortedOrders;
	}

}
