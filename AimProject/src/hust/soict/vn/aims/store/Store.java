package hust.soict.vn.aims.store;


import java.util.ArrayList;

import hust.soict.vn.aims.disc.DigitalVideoDisc;
import hust.soict.vn.aims.media.Media;



public class Store {

	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media media) {
		if (itemsInStore.contains(media)) {
			System.out.println("Item already in store.");
		} else {
			itemsInStore.add(media);
			System.out.println("Added " + media.toString() + " to store.");
		}
	}

	public void removeMedia(Media media) {
		if (itemsInStore.remove(media)) {
			System.out.println("Removed " + media.toString() + " from store.");
		} else {
			System.out.println("Couldn't find this item.");
		}
	}
	
	public void displayItems() {
		System.out.println("\n***********************STORE***********************");
		for (Media m: itemsInStore) {
			System.out.println(m.toString());
		}
		System.out.println("***************************************************");
	}
	public Media fetchMedia(String title) {
		for (Media m : itemsInStore) {
			if (m.isMatch(title))
				return m;
		}
		return null;
	}


}
