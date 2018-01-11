package com.challenge.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.challenge.entity.Order;

@Component
public class OrdersUtility {
	
	public void writeOrders(String fileName, List<Order> sortedOrders) {
		
		Path path = Paths.get(fileName);
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			StringBuilder result = new StringBuilder("");
			result.append("Order time").append("\n");
            ZoneId zone = ZoneId.systemDefault();
            sortedOrders.forEach(order -> {
                DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").withZone(zone);
                String dateTime = df.format(Instant.ofEpochMilli(order.getEpoch()));
                result.append(order.getName()).append(" ");
				result.append(dateTime).append("\n");
			});
		    writer.write(result.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Order> readOrders(String fileName) {
		List<Order> inputOrders = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(fileName))) {

			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split("\\s+");
				if (words.length == 2) {
					Order order = new Order(words[0], Long.parseLong(words[1]));
					inputOrders.add(order);
				}
			}
			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("before sorting");
		System.out.println(inputOrders);

		return inputOrders;
	}
	
}
