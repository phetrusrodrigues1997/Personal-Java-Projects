package hackathon;

import java.time.LocalDateTime;
import java.util.TreeSet;
import java.util.Set;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
	private static Scanner userInput = new Scanner(System.in); // Scanner to get the user input.
	String selectedItems = "";
	static int counter = 0 ; ;

	static Set<String> setOfItems = new TreeSet<>();

	public Main() {

	}

	public static void main(String[] args) {
		Item item = new Item();

		// First interaction with the user
		System.out.println("Welcome to FiveGuys, our items for sale today are: " + "\n");
		System.out.println(
				"Ham Burger: £6.95     Fries: £4.50     Drink: £3.15     Cheese Burger: £5.95     Milkshake: £5.25     Double Cheese Burger: £7.95     Hot Dog: £4.50"
						+ "\n");
		System.out.println("Enter your name: ");

		String name = userInput.nextLine(); // The user's name is saved into a variable
		int numberOfItemsDiscounted = 0;
		double totalPrice = 0; // Total price spent by the customer

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime now = LocalDateTime.now();

		int index = 0; // Variable to keep the while loop going for as long as necessary.

		// Second interaction with the user. The loop will keep going until the user
		// enters "Finished"
		while (index == 0) {
			System.out.println("Enter an item from the menu or enter 'finished' when you complete your order: ");
			String line = userInput.nextLine(); // Variable to symbolise the item entered by the user
			counter++ ;
			if (line.equalsIgnoreCase("Finished")) {
				index = 1; // Index is now 1 so the loop should end
				break; // For some reason it doesn't end so I used a break.
			}

			if (item.check(line)) {
				// Checks whether the user should get a discount
				if (item.shouldGetADiscount(name)) {

					numberOfItemsDiscounted++;
					item.setNumberOfItemsDiscounted(numberOfItemsDiscounted); // Sets the current number of items to be
																				// discounted

				}

				String userInput = line.substring(0, 1).toUpperCase() + line.substring(1);  

				setOfItems.add(userInput);

				System.out.println("Item entered succesfully!" + "\n");

				totalPrice += item.getPrice(line); // Each item's price is added to the total price variable as long as
													// the
													// loop is still going.

			} else {
				System.out.println("This item is not on the menu" + "\n");
			}

		}

		System.out.println("\n" + "Total price: £" + totalPrice );

		// Checks whether the user should get a discount, if so then we display how much
		// they have saved
		if (item.shouldGetADiscount(name)) {
			System.out.println("Discount code accepted !");
			System.out.println("Full amount discounted: £" + item.getFullDiscountAmount());
			System.out.println("You have saved: " + Math.round(item.getFullDiscountAmount() / totalPrice * 100) + "%");
		} else {
			System.out.println("You are not eligible for a discount!" );
		}
		String boughtItems = "";
		for (String s : setOfItems) {
			boughtItems += s + " ";
		}
		
		System.out.println("Total number of purchased items: " + (counter - 1) + "\n" + "You have bought: " + boughtItems );
		System.out.println("Bought on " + dtf.format(now) + "at " + time.format(now) + "\n");
		System.out.println("Bye " + name + "! Thanks for shopping at FiveGuys! :)");

	}
}
