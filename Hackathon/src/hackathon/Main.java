package hackathon;

import java.util.Scanner;



public class Main {
	private static Scanner userInput = new Scanner(System.in); // Scanner to get the user input.

	public Main() {

	}

	public static void main(String[] args) {
		Item item = new Item();

		// First interaction with the user
		System.out.println("Welcome to FiveGuys, our items for sale today are: " + "\n");
		System.out.println("Burger: £5.00     Fries: £2.50      Fizzy Drink: £1.50" + "\n");
		System.out.println("Enter your name: ");

		String name = userInput.nextLine(); // The user's name is saved into a variable

		int numberOfItemsDiscounted = 0;
		double totalPrice = 0; // Total price spent by the customer

		int index = 0; // Variable to keep the while loop going for as long as necessary.

		// Second interaction with the user. The loop will keep going until the user
		// enters "Finished"
		while (index == 0) {
			System.out.println("Enter an item: ");
			String line = userInput.nextLine(); // Variable to symbolise the item entered by the user
			if (line.equalsIgnoreCase("Finished")) {
				index = 1; // Index is now 1 so the loop should end
				break; // For some reason it doesn't end so I used a break.
			}
			// Checks whether the user should get a discount
			if (item.shouldGetADiscount(name)) {

				numberOfItemsDiscounted++;
				item.setNumberOfItemsDiscounted(numberOfItemsDiscounted); // Sets the current number of items to be
																			// discounted

			}

			System.out.println("Item entered succesfully!" + "\n");

			totalPrice += item.getPrice(line); // Each item's price is added to the total price variable as long as the
												// loop is still going.

		}
        
		System.out.println("\n" + "Total price: £" + totalPrice + "\n");

		// Checks whether the user should get a discount, if so then we display how much
		// they have saved
		if (item.shouldGetADiscount(name)) {
			System.out.println("Discount code accepted !");
			System.out.println("Full amount discounted: £" + item.getFullDiscountAmount());
		} else {
			System.out.println("You are not eligible for a discount!" + "\n");
		}
		System.out.println("Thanks for shopping at FiveGuys! :)");

	}
}

