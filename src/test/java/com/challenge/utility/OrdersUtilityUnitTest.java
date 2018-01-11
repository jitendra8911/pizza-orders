package com.challenge.utility;

import com.challenge.entity.Order;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrdersUtilityUnitTest {

    private final OrdersUtility ordersUtility = new OrdersUtility();

    @Test
    public void testReadOrders() {

        File file = new File("src/main/resources/PizzaOrders");
        String absolutePath = file.getAbsolutePath();

        List<Order> actualOrders;
        actualOrders = ordersUtility.readOrders(absolutePath);

        assertEquals(actualOrders.size(), 9);

    }

    @Test
    public void writeOrders() {
        File file = new File("src/main/resources/OutputPizzaOrders");
        String absolutePath = file.getAbsolutePath();
		List<Order> sortedOrders = new ArrayList<>();
		sortedOrders.add(new Order("Meat", (long) 1506176687));
		sortedOrders.add(new Order("pizza", (long) 1477578287));
		sortedOrders.add(new Order("p1zza", (long) 1477491887));
		sortedOrders.add(new Order("Bread", (long) 1477405487));
		sortedOrders.add(new Order("Pizza", (long) 1477319087));
		sortedOrders.add(new Order("bread", (long) 1477232687));
		sortedOrders.add(new Order("bread", (long) 1474640687));
		sortedOrders.add(new Order("meatMeaT", (long) 1474295087));
		sortedOrders.add(new Order("VegVeg", (long) 1474295087));

		ordersUtility.writeOrders(absolutePath, sortedOrders);
    }
}
