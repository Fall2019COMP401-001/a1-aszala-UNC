package a1;

import java.util.HashMap;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		// Create scanner object to read User input
		Scanner scan = new Scanner(System.in);
		
		// Create HashMap to store the quantity of the items bought and
		// to store the amount of customers bought that item
		
		// String -> Item Name    Integer -> Quantity of item bought
		HashMap<String, Integer> quantityBought = new HashMap<>();
		// String -> Item Name    Integer -> Amount of Customers who bought that item
		HashMap<String, Integer> customersWhoBought = new HashMap<>();
		
		// Get items that are in the store
		int itemsInStore = scan.nextInt();

		String[] itemNames = new String[itemsInStore];
		
		// Loop through the items and add them to the HashMap
		for (int i=0;i<itemsInStore;i++) {
			// get the item name
			String itemName = scan.next();
			
			// Skip the price value
			scan.nextDouble();
			
			// Put the item into the HashMaps with a default value of 0
			quantityBought.put(itemName, 0);
			customersWhoBought.put(itemName, 0);
			
			// Store order of items names into String array
			itemNames[i] = itemName;
		}
		
		// Get Total Customers
		int totalCustomers = scan.nextInt();
		
		// Loop Through Customers
		for (int i=0;i<totalCustomers;i++) {
			// Skip Customer First and Last Name
			scan.next();
			scan.next();
			
			int numItemsBought = scan.nextInt();
			
			// Calculates the quantity and the amount of customers who bought given item
			for (int j=0;j<numItemsBought;j++) {
				int quantity = scan.nextInt();
				String itemName = scan.next();
				
				// Update the quantity bought and the amount of customers who bought HashMaps
				quantityBought.replace(itemName, quantityBought.get(itemName) + quantity);
				customersWhoBought.replace(itemName, customersWhoBought.get(itemName) + 1);
			}
			
		}

		// Loop through the items in the store in the order that they were added
		for (String itemName : itemNames) {
			int itemQuantity = quantityBought.get(itemName);
			
			// Check if the quantity bought of the item is greater than zero
			if (itemQuantity > 0)
				// Print Desired output of quantity is not 0
				System.out.println(customersWhoBought.get(itemName) + " customers bought " + itemQuantity + " " + itemName);
			else
				// Print that no customers bought because quantity bought was zero
				System.out.println("No customers bought " + itemName);
		}
		
		// Close scanner as user input is no longer needed
		scan.close();
		
	}
}