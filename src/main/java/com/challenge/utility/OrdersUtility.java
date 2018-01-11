package com.challenge.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.Entity.Order;
import com.challenge.sort_pizza_order.PizzaOrder;

@Component
public class OrdersUtility {
	
	@Resource(name="inputOrders")
	private List<Order> inputorders;
	
	@Resource(name="sortedOrders")
	private List<Order> sortedOrders;
	
	public void writeOrders(String fileName) {
		
		Path path = Paths.get(fileName);
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			StringBuilder result = new StringBuilder("");
			result.append("Order time").append("\n");
			sortedOrders.stream().forEach(order -> result.append(order).append("\n"));
		    writer.write(result.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  void readOrders(String fileName) {	
		try (Scanner scanner = new Scanner(new File(fileName))) {

			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split("\\s+");
				if (words != null && words.length == 2) {
					Order order = new Order(words[0], Long.parseLong(words[1]));
					inputorders.add(order);
				}
			}
			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("before sorting");
		System.out.println(inputorders);
	}
	
}
