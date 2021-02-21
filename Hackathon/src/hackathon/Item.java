package hackathon;


/**
 * This class models an item, that is available to buy at five guys.
 * 
 * @author Phetrus & Josh
 *
 */
public class Item {
	private double price = 0;
	private boolean discount = false;
	

	private static enum availableItems {
		Fries, Drink, Ham_Burger, Milkshake, Double_Cheeseburger, Cheeseburger, Hot_Dog
	};

	private int numberOfItemsDiscounted = 0;

	public Item() {
	}

	/**
	 * This method will set the global variable "discount" equal to true if the
	 * user's name matches one of the names listed below. It returns true if a
	 * discount has been applied and false otherwise.
	 * 
	 * @param employee : String
	 * @return Whether the customer is able to get a discount
	 */
	public boolean shouldGetADiscount(String employee) {
		if (employee.equalsIgnoreCase("Phetrus1") || employee.equalsIgnoreCase("Josh1")) {
			discount = true;
			return true;
		} else {
			discount = false;
			return false;
		}

	}

	/**
	 * This method returns the price of an item.
	 * 
	 * @param item : String
	 * @return the price of the item
	 */
	public double getPrice(String requestedItem) {
		String item = requestedItem.replaceAll(" ", "_");

		if (item.equalsIgnoreCase("Ham_Burger")) {
			price = 6.95;

			if (discount) {
				price -= 0.50;

			}
		} else if (item.equalsIgnoreCase("Drink")) {
			price = 3.15;

			if (discount) {
				price -= 0.50;
			}
		} else if (item.equalsIgnoreCase("Fries")) {
			price = 4.50;
			if (discount) {
				price -= 0.50;
			}
		} else if (item.equalsIgnoreCase("Cheeseburger")) {
			price = 5.95;
			if (discount) {
				price -= 0.50;
			}
		} else if (item.equalsIgnoreCase("Milkshake")) {
			price = 5.25;
			if (discount) {
				price -= 0.50;
			} else if (item.equalsIgnoreCase("Double_Cheese_Burger")) {
				price = 7.95;
				if (discount) {
					price -= 0.50;
				}
			} else if (item.equalsIgnoreCase("Hot_Dog")) {
				price = 4.50;
				if (discount) {
					price -= 0.50;
				}
			}
		}

		return price;
	}

// In the main class, everytime a person with discount privileges buys an item, a variable is incremented,
// and then passed to this method. This method sets the global variable numberOfItemsDiscounted equal to 
	// the parameter being passed in.
	public void setNumberOfItemsDiscounted(int number) {
		numberOfItemsDiscounted = number;
		;

	}

	// This method uses the variable discussed in the method above.
	// It returns the full discount amount.
	public double getFullDiscountAmount() {
		double fullAmount = numberOfItemsDiscounted * 0.50;
		return fullAmount;
	}

	public boolean check(String userItem) {

		for (availableItems item : availableItems.values()) {
			if (item.name().equalsIgnoreCase(userItem.replaceAll(" ", "_"))) {
				return true;
			}

		}
		return false;
	}

}
