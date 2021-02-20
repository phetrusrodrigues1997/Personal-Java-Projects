package hackathon;



/**
 * This class models an item, that is available to buy at five guys. 
 * @author Phetrus & Josh
 *
 */
public class Item {
	private double price = 0;
	private boolean discount = false;
	private int numberOfItemsDiscounted = 0;

	public Item() {}
	
	/**
	 * This method will set the global variable "discount" equal to true if the user's name 
	 * matches one of the names listed below.
	 * It returns true if a discount has been applied and false otherwise.
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
	 * @param item : String
	 * @return the price of the item
	 */
	public double getPrice(String item) {
		if (item.equalsIgnoreCase("Burger")) {
			price = 5.00;
			if (discount) {
				price -= 0.50;
			}
		} else if (item.equalsIgnoreCase("Fizzy Drink")) {
			price = 1.50;
			if (discount) {
				price -= 0.50;
			}
		} else if (item.equalsIgnoreCase("Fries")) {
			price = 2.50;
			if (discount) {
				price -= 0.50;
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
	//It returns the full discount amount.
	public double getFullDiscountAmount() {
		double fullAmount = numberOfItemsDiscounted * 0.50;
		return fullAmount;
	}

}
