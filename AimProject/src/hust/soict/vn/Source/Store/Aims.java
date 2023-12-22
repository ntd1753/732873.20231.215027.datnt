package Store;

import java.util.Scanner;
import javax.swing.JOptionPane;

import Cart.Cart;
import Exception.DuplicatedItemException;
import Media.Book;
import Media.CompactDisc;
import Media.DigitalVideoDisc;
import Media.Media;
import Media.Track;
import Screen.CartScreen;
import Screen.StoreScreen;

public class Aims {

	private static Scanner sc;
	private static Store store;
	private static Cart cart;
	private static StoreScreen storeScreen;
	private static CartScreen cartScreen;

	public static void main(String[] args) {
		store = new Store();
		cart = new Cart();
		
	
		Media[] sampleMedia = new Media[] {
				new DigitalVideoDisc("Journey To The Stars", "Sci-fi", "William Parker", 120, 35.7f),
				new DigitalVideoDisc("Whispers Of Love", "Romance", "Eva Thompson", 105, 42.5f),
				new DigitalVideoDisc("Dark Secrets", "Horror", "Robert Smith", 88, 52.1f),
				new CompactDisc("Love Beats", "Pop", "Melissa Allen", "Brian Turner", 64.8f) {{
				    addTrack(new Track("Dreamy Nights", 6));
				    addTrack(new Track("Heartfelt Melodies", 4));
				}},
				new CompactDisc("Electric Dreamscape", "Electronic", "Catherine Simmons", "David Matthews", 78.5f) {{
				    addTrack(new Track("Synth Reverie", 5));
				    addTrack(new Track("Digital Escape", 3));
				}},
				new Book("Misty Mountains", "Mystery", 30.5f) {{
				    addAuthor("David Johnson");
				}},
				new Book("Eternal Romance", "Romance", 45.6f) {{
				    addAuthor("Olivia Miller");
				    addAuthor("Christopher Davis");
				}},
				new CompactDisc("Pop Sensations", "Pop", "STEREO", "Melody Group", 25.5f) {{
				    addTrack(new Track("Pop Anthem", 2));
				    addTrack(new Track("Summer Vibes", 4));
				}},
				new Book("Dreams Unveiled", "Oneshot", 59.99f) {{
				    addAuthor("Luna Taylor");
				}}
		};

		
		for (Media m : sampleMedia) {
			try {
				store.addMedia(m);
			} catch (DuplicatedItemException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		openStoreScreen();
	}

	public static Store getStore() {
		return store;
	}

	public static Cart getCart() {
		return cart;
	}

	public static StoreScreen getStoreScreen() {
		return storeScreen;
	}

	public static CartScreen getCartScreen() {
		return cartScreen;
	}
	
	public static void openStoreScreen() {
		storeScreen = new StoreScreen(store);
	}
	
	public static void closeStoreScreen() {
		storeScreen.setVisible(false);
		storeScreen = null;
	}
	
	public static void openCartScreen() {
		cartScreen = new CartScreen(cart);
	}
	
	public static void closeCartScreen() {
		cartScreen.setVisible(false);
		cartScreen = null;
	}
	
}
