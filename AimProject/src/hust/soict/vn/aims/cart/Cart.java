package hust.soict.vn.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.vn.aims.disc.DigitalVideoDisc;
import hust.soict.vn.aims.media.Media;
public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;

	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	public void addMedia(Media media) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full.");
		} else if (itemsOrdered.contains(media)) {
			System.out.println("Media already in cart.");
		} else {
			itemsOrdered.add(media);
			System.out.println("Added " + media.toString() + " to cart.");
		}
		System.out.println("Current number of items in cart: " + itemsOrdered.size());
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.remove(media)) {
			System.out.println("Removed " + media.toString() + " from cart.");
		} else {
			System.out.println("Couldn't find this item.");
		}
	}

	public float totalCost() {
		float cost = 0;
		for (Media m : itemsOrdered) {
			cost += m.getCost();
		}
		return cost;
	}

	public void print() {
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("**************************************************");
	}

	public void searchById(int id) {
		System.out.println("Search results for ID: " + id);
		for (Media m : itemsOrdered) {
			if (m.getId() == id) {
				System.out.println(m.toString());
				return;
			}
		}
		System.out.println("No items found.");
	}

	public void searchByTitle(String title) {
		boolean found = false;
		System.out.println("Search results for keywords: " + title);
		for (Media m : itemsOrdered) {
			if (m.isMatch(title)) {
				System.out.println(m.toString());
				found = true;
			}
		}
		if (!found)
			System.out.println("No items found.");
	}
	public void sortByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortByCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	public Media fetchMedia(String title) {
		for (Media m : itemsOrdered) {
			if (m.isMatch(title))
				return m;
		}
		return null;
	}

	public void placeOrder() {
		if (itemsOrdered.isEmpty()) {
			System.out.println("The cart is empty.");
			return;
		}
		
		itemsOrdered.clear();
		System.out.println("Your order has been placed.");
	}


}

