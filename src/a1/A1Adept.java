package a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		// Create scanner object to read User input
		Scanner scan = new Scanner(System.in);
		
		// Create HashMaps to store the items in the store and the customers.
		
		// String -> Item Name   Double -> Item Cost
		HashMap<String, Double> storeItems = new HashMap<>();
		
		// String -> Customer First and Last  Double -> Customer Total Cost
		HashMap<String, Double> customers = new HashMap<>();
		
		// Get total number of items in store from input
		int itemsInStore = scan.nextInt();
		
		// Put all the inputed items in the HashMap with their corresponding value
		for (int i=0;i<itemsInStore;i++)
			//             Item Name       Item Price
			storeItems.put(scan.next(), scan.nextDouble());
		
		// Get total number of customers from input
		int totalCustomers = scan.nextInt();
		
		// Loop through each customer, calculate the total cost and
		// put their info in the HashMap
		for (int i=0;i<totalCustomers;i++) {
			// Get the first and last name of the customer
			String name = scan.next() + " " + scan.next();
			
			// Get the items the customer bought
			int itemsBought = scan.nextInt();
			
			double totalCost = 0.0;
			
			// For each of the items bought, get the cost of the item and multiple by the quantity
			// Add the resulting value to the total cost of the customer
			for (int j=0;j<itemsBought;j++)
				//            Quantity       *   Item Price From HasMap
				totalCost += (scan.nextInt() * storeItems.get(scan.next()));
			
			// The the cost and then name into the customer HashMap
			customers.put(name, totalCost);
		}
		
		Map.Entry<String, Double> maxCustomer = null;

		// Calculate the biggest buyer from the customers
		// Loop through each customer in the HashMap
		for (Map.Entry<String, Double> customer : customers.entrySet()) {
			// If the current customer in the loop is higher than the original highest
			// then replace the old current highest with the new current highest customer
			if (maxCustomer == null || customer.getValue().compareTo(maxCustomer.getValue()) > 0)
				maxCustomer = customer;
		}

		Map.Entry<String, Double> minCustomer = null;
		
		// Calculate the smallest buyer from the customers		
		// Loop through each customer in the HashMap
		for (Map.Entry<String, Double> customer : customers.entrySet()) {

			// If the current customer in the loop is lower than the original lowest
			// then replace the old current lowest with the new current lowest customer
			if (minCustomer == null || customer.getValue().compareTo(minCustomer.getValue()) < 0)
				minCustomer = customer;
		}
		
		double totalCostOfAllCustomers = 0.0;

		// Calculate the grand total of the customers
		// Loop through each customer in the HashMap
		for (Map.Entry<String, Double> customer : customers.entrySet())
			// Add the total cost of the customer to the grand total
			totalCostOfAllCustomers += customer.getValue();
		
		// Print the biggest customer and their amount formatted to 2 decimal places
		System.out.println("Biggest: " + maxCustomer.getKey() +
							" (" + String.format("%.2f", maxCustomer.getValue()) + ")");

		// Print the smallest customer and their amount formatted to 2 decimal places
		System.out.println("Smallest: " + minCustomer.getKey() +
							" (" + String.format("%.2f", minCustomer.getValue()) + ")");
		
		// Print the average of all the customers formatted to 2 decimal places
		System.out.println("Average: " + String.format("%.2f", (totalCostOfAllCustomers / customers.size())));
		
		// Close scanner as user input is no longer needed
		scan.close();
	}
}