package hust.soict.vn.test.cart;

import hust.soict.vn.aims.cart.Cart;
import hust.soict.vn.aims.disc.DigitalVideoDisc;

public class CartTest {
	
	public static void main(String[] args) {
		//20215111
		Cart cart = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);

		// Test for print
		cart.print();

		// Test for search
		cart.search(3);
		cart.search("The Lion King");
		cart.search(10);
		cart.search("Spider Man");
	}
}
