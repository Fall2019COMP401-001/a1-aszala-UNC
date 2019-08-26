package a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		// Create Scanner Object to read input in from User
		Scanner scan = new Scanner(System.in);
		
		// String -> Customer First and Last  Double -> Customer Total Cost
		HashMap<String, Double> customers = new HashMap<>();
				
		// Get the first input, representing the total number of customers
		// that are going to be entered.
		int totalCustomers = scan.nextInt();
		
		// Array of names to preserve order of input
		String[] customerNames = new String[totalCustomers];
		
		// Loop through each customer and collect the needed information
		for (int i=0;i<totalCustomers;i++) {
			// Get the First and Last Name
			String name = scan.next() + " " + scan.next();
			customerNames[i] = name;
			
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
		for (String name : customerNames) {
			System.out.println(name.charAt(0) + ". " + 
					name.split(" ")[1] + ": " + String.format("%.2f", customers.get(name)));
		}
		
		// Close scanner as user input is no longer needed.
		scan.close();
	}
}