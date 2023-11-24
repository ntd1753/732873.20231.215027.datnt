package hust.soict.vn.aims.store;

import hust.soict.vn.aims.disc.DigitalVideoDisc;

public class Store {
	private int capacity ;
	private DigitalVideoDisc itemsInStore[];
	private int nbDVD=0;
	
	public Store(int ca) {
		this.capacity=ca;
		itemsInStore = new DigitalVideoDisc[ca];
	}
	
	public void addDVD(DigitalVideoDisc dvd) {
		if (nbDVD<this.capacity) {
			this.itemsInStore[nbDVD]=dvd;
			nbDVD+=1;
			System.out.println("The disc has been added");
		}else {
			System.out.println("The store is full");
		}
	}
	public void removeDVD(DigitalVideoDisc dvd) {
		for (int i=0;i<nbDVD;i++){
			if (itemsInStore[i].equals(dvd)){
				for (int j=i;j<nbDVD-1;j++) {
					itemsInStore[j]=itemsInStore[j+1];
				}
			}
		}
		nbDVD-=1;
		System.out.println("The disc has been removed");
	}
}
