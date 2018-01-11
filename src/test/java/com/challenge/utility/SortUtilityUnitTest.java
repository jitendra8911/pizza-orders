package com.challenge.utility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.challenge.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class SortUtilityUnitTest {

	@Mock(name="inputOrders")
	private List<Order> inputOrders = Arrays.asList(
			new Order("VegVeg", (long) 1474295087),
			new Order("Meat", (long) 1506176687),
			new Order("p1zza", (long) 1477491887),
			new Order("Bread", (long) 1477405487),
			new Order("meatMeaT", (long) 1474295087),
			new Order("Pizza", (long) 1477319087),
			new Order("pizza", (long) 1477578287),
			new Order("bread", (long) 1477232687),
			new Order("bread", (long) 1474640687));




	@InjectMocks
	private final SortUtility sortUtility = new SortUtility(inputOrders);

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

		Mockito.when(inputOrders.stream()).thenReturn(orders.stream());

		sortUtility.sortOrders();
	}

}
