package com.challenge.utility;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.challenge.entity.Order;

import static org.junit.Assert.assertEquals;

public class SortUtilityUnitTest {

	private final SortUtility sortUtility = new SortUtility();

	@Test
	public void testSortOrders() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("VegVeg", (long) 1474295087));
		orders.add(new Order("Meat", (long) 1506176687));
		orders.add(new Order("p1zza", (long) 1477491887));
		orders.add(new Order("Bread", (long) 1477405487));
		orders.add(new Order("meatMeaT", (long) 1474295087));
		orders.add(new Order("Pizza", (long) 1477319087));
		orders.add(new Order("pizza", (long) 1477578287));
		orders.add(new Order("bread", (long) 1477232687));
		orders.add(new Order("bread", (long) 1474640687));


		List<Order> sortedOrders = sortUtility.sortOrders(orders);

		assertEquals(sortedOrders.get(0).getName(), "Meat");
		assertEquals(sortedOrders.get(1).getName(), "pizza");
		assertEquals(sortedOrders.get(2).getName(), "p1zza");
		assertEquals(sortedOrders.get(3).getName(), "Bread");
		assertEquals(sortedOrders.get(4).getName(), "Pizza");
		assertEquals(sortedOrders.get(5).getName(), "bread");
		assertEquals(sortedOrders.get(6).getName(), "bread");
		assertEquals(sortedOrders.get(7).getName(), "meatMeaT");
		assertEquals(sortedOrders.get(8).getName(), "VegVeg");


	}

}
