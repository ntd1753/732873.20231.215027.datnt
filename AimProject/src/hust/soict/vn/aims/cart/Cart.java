package hust.soict.vn.aims.cart;

import hust.soict.vn.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int qtyOrdered = 0;

    // -----------------------------------------------------------------------

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is already full!");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added!");
    }

    // -----------------------------------------------------------------------
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;

                System.out.println("The disc has been removed!");
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }

                qtyOrdered--;
                break;
            }
        }
        if (!found) {
            System.out.println("Error 404! The disc is not found!");
        }
    }
    // -----------------------------------------------------------------------

    public float totalCost() {
        float total = 0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
//20215111
    public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items: ");
		for (int i=0;i<qtyOrdered;i++) {
			System.out.println(itemsOrdered[i].toString());
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
	public void search(int id) {
		int count=0;
		for (int i=0;i<qtyOrdered;i++) {
			if (itemsOrdered[i].isMatch(id)){
				System.out.println(itemsOrdered[i].toString());
				count+=1;
			}
		}
		if (count==0) {
			System.out.println("No match is found");
		}
	}
	public void search(String title) {
		int count=0;
		for (int i=0;i<qtyOrdered;i++) {
			if (itemsOrdered[i].isMatch(title)){
				System.out.println(itemsOrdered[i].toString());
				count+=1;
			}
		}
		if (count==0) {
			System.out.println("No match is found");
		}
	}
    
    
}