package hust.soict.vn.test.store;

import hust.soict.vn.aims.disc.DigitalVideoDisc;
import hust.soict.vn.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store(100);
		
		DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addDVD(dvd1);
		
		DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addDVD(dvd2);
		
		DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addDVD(dvd3);
		
		store.removeDVD(dvd3);
		store.removeDVD(dvd1);
		
	}

}
