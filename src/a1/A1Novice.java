package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		// Create Scanner Object to read input in from User
		Scanner scan = new Scanner(System.in);
		
		// Get the first input, representing the total number of customers
		// that are going to be entered.
		int totalCustomers = scan.nextInt();
		
		// Create arrays that will store all information for each user.
		String[] customerFirstNames = new String[totalCustomers];
		String[] customerLastNames = new String[totalCustomers];
		double[] customerTotalCost = new double[totalCustomers];
		
		// Loop through each customer and collect the needed information
		for (int i=0;i<totalCustomers;i++) {
			// Get the 3 segments of the next input line: First, Last, Items Bought
			String[] customerData = { scan.next(), scan.next(), scan.next() };
			
			// Using the customer data get the total number of items bought (Index: 2)
			int itemsBought = Integer.parseInt(customerData[2]);
			
			double totalCost = 0.0;
			
			// Loop through each item bought and total it all up
			for (int j=0;j<itemsBought;j++) {
				// Get the 3 segments of next input line: Quantity, Name, Price
				String[] itemData = { scan.next(), scan.next(), scan.next() };
				
				// Add the total cost of the item to the total customer cost.
				//			  	Price of Item (Index: 2)		Quantity of that Item (Index: 0)
				totalCost += (Double.parseDouble(itemData[2]) * Integer.parseInt(itemData[0]));
			}
			
			// Store First Name, Last Name, Total Customer Cost into the earlier created arrays
			customerTotalCost[i] = totalCost;
			customerFirstNames[i] = customerData[0];
			customerLastNames[i] = customerData[1];
		}
		
		// Loop through each customer and print all the information
		for (int i=0;i<totalCustomers;i++) {
			// Prints first letter of the first name, last name, total cost of customer to 2 decimal places.
			System.out.println(customerFirstNames[i].charAt(0) + ". " +
								customerLastNames[i] + ": " + String.format("%.2f", customerTotalCost[i]));
		}
		
		// Close scanner as user input is no longer needed.
		scan.close();
	}
}
