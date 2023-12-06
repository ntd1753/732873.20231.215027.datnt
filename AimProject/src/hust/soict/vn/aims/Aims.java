package hust.soict.vn.aims;

import java.util.Scanner;
import hust.soict.vn.aims.cart.Cart;
import hust.soict.vn.aims.disc.DigitalVideoDisc;
import hust.soict.vn.aims.media.Book;
import hust.soict.vn.aims.media.CompactDisc;
import hust.soict.vn.aims.media.Media;
import hust.soict.vn.aims.store.Store;


public class Aims {

	private static Scanner sc;
	private static Store store;
	private static Cart cart;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		store = new Store();
		cart = new Cart();
		showMenu();
		sc.close();
	}

	public static String inputMediaTitle() {
		System.out.print("Enter title: ");
		sc.nextLine(); // Clear buffer
		return sc.nextLine();
	}

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");

		switch (sc.nextInt()) {
		case 0:
			System.out.println("Application closed.");
			return;
		case 1:
			storeMenu();
			break;
		case 2:
			updateStoreMenu();
			break;
		case 3:
			cartMenu();
			break;
		default:
			System.out.println("Invalid choice.");
		}
		showMenu();
	}

	public static void storeMenu() {
		store.displayItems();
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		switch (sc.nextInt()) {
		case 0:
			return;
		case 1:
			mediaDetailsMenu();
			break;
		case 2:
			addMediaToCartMenu();
			break;
		case 3:
			Media m = store.fetchMedia(inputMediaTitle());
			if (m == null) {
				System.out.println("Item not found.");
				return;
			}
			if (m instanceof DigitalVideoDisc)
				((DigitalVideoDisc) m).play();
			else if (m instanceof CompactDisc)
				((CompactDisc) m).play();
			else {
				System.out.println("Cannot play this media.");
			}
			break;
		case 4:
			cartMenu();
			break;
		default:
			System.out.println("Invalid choice.");
		}
		storeMenu();
	}

	public static void mediaDetailsMenu() {
		Media m = store.fetchMedia(inputMediaTitle());
		if (m == null) {
			System.out.println("Item not found.");
			return;
		}

		System.out.println(m.getDetails());

		boolean playable = m instanceof DigitalVideoDisc || m instanceof CompactDisc;

		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		if (playable)
			System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1" + (playable ? "-2" : ""));

		switch (sc.nextInt()) {
		case 0:
			return;
		case 1:
			cart.addMedia(m);
			break;
		case 2:
			if (playable) {
				if (m instanceof DigitalVideoDisc)
					((DigitalVideoDisc) m).play();
				else
					((CompactDisc) m).play();
			} else {
				System.out.println("Invalid choice");
			}
			break;
		default:
			System.out.println("Invalid choice.");
		}
	}

	public static void updateStoreMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media from store.");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");

		switch (sc.nextInt()) {
		case 0:
			return;
		case 1:
			addMediaToStoreMenu();
			break;
		case 2:
			removeMediaFromStoreMenu();
			break;
		default:
			System.out.println("Invalid choice.");
		}
		updateStoreMenu();
	}

	public static void addMediaToStoreMenu() {
		System.out.println("Choose type of media: ");
		System.out.println("--------------------------------");
		System.out.println("1. Digital Video Disc (DVD)");
		System.out.println("2. Compact Disc (CD)");
		System.out.println("3. Book");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");

		switch (sc.nextInt()) {
		case 0:
			return;
		case 1:
			store.addMedia(DigitalVideoDisc.createDVD());
			break;
		case 2:
			store.addMedia(CompactDisc.createCD());
			break;
		case 3:
			store.addMedia(Book.createBook());
			break;
		default:
			System.out.println("Invalid choice.");
		}
	}

	public static void removeMediaFromStoreMenu() {
		Media m = store.fetchMedia(inputMediaTitle());
		if (m == null) {
			System.out.println("Item not found.");
			return;
		}

		store.removeMedia(m);
	}

	public static void cartMenu() {
		cart.print();
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");

		switch (sc.nextInt()) {
		case 0:
			return;
		case 1:
			filterCartMenu();
			break;
		case 2:
			sortCartMenu();
			break;
		case 3:
			removeMediaFromCartMenu();
			break;
		case 4:
			Media m = cart.fetchMedia(inputMediaTitle());
			if (m == null) {
				System.out.println("Item not found.");
				return;
			}
			if (m instanceof DigitalVideoDisc)
				((DigitalVideoDisc) m).play();
			else if (m instanceof CompactDisc)
				((CompactDisc) m).play();
			else {
				System.out.println("Cannot play this media.");
			}
			break;
		case 5:
			cart.placeOrder();
			break;
		default:
			System.out.println("Invalid choice.");
		}
		cartMenu();
	}

	public static void filterCartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by ID");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");

		switch (sc.nextInt()) {
		case 0:
			return;
		case 1:
			System.out.print("Enter ID: ");
			cart.searchById(sc.nextInt());
			break;
		case 2:
			cart.searchByTitle(inputMediaTitle());
			break;
		default:
			System.out.println("Invalid choice.");
		}
	}

	public static void sortCartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");

		switch (sc.nextInt()) {
		case 0:
			return;
		case 1:
			cart.sortByTitle();
			break;
		case 2:
			cart.sortByCost();
			break;
		default:
			System.out.println("Invalid choice.");
		}
	}
	
	public static void addMediaToCartMenu() {
		Media m = store.fetchMedia(inputMediaTitle());
		if (m == null) {
			System.out.println("Item not found.");
			return;
		}
		cart.addMedia(m);
	}
	
	public static void removeMediaFromCartMenu() {
		Media m = cart.fetchMedia(inputMediaTitle());
		if (m == null) {
			System.out.println("Item not found.");
			return;
		}
		cart.removeMedia(m);
	}
}

