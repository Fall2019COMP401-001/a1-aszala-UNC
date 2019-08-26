package a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		// Create Scanner Object to read input in from User
		Scanner scan = new Scanner(System.in);
		
		// Get the first input, representing the total number of customers
		// that are going to be entered.
		int totalCustomers = scan.nextInt();
		
		// String -> Customer First and Last  Double -> Customer Total Cost
		HashMap<String, Double> customers = new HashMap<>();
		
		// Loop through each customer and collect the needed information
		for (int i=0;i<totalCustomers;i++) {
			// Get the First and Last Name
			String name = scan.next() + " " + scan.next();
			
			int itemsBought = scan.nextInt();
			
			double totalCost = 0.0;
			
			// Loop through each item bought and total it all up
			for (int j=0;j<itemsBought;j++) {
				int quantity = scan.nextInt();
				
				// Skip over the name of the item as it is not needed
				scan.next();
				
				double price = scan.nextDouble();
				
				// Add the total cost of the item to the total customer cost
				totalCost += (quantity * price);
			}
			
			// Store First Name, Last Name, Total Customer Cost into the HashMap
			customers.put(name, totalCost);
		}
		
		// Loop through each customer and print all the information
		for (Map.Entry<String, Double> customer : customers.entrySet()) {
			System.out.println(customer.getKey().charAt(0) + ". " + 
					customer.getKey().split(" ")[1] + ": " + String.format("%.2f", customer.getValue()));
		}
		
		// Close scanner as user input is no longer needed.
		scan.close();
	}
}