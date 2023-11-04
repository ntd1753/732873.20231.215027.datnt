
//Create the Cart class to work with DigitalVideoDisc 
public class Cart {
   public static final int MAX_NUMBERS_ORDERED = 20;
   private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];  
   private int qtyOrdered = 0;
   
   //Method to add an item to the list
   public void addDigitalVideoDisc(DigitalVideoDisc disc) {
	   if(qtyOrdered <= MAX_NUMBERS_ORDERED) {
		   itemsOrdered[qtyOrdered] = disc;
		   qtyOrdered++;
		   System.out.println("The disc with name "+disc.getTitle()+" has been added!");
		   
	   }
	   else {
		   System.out.println("The cart is almost full");
	   }
   }
   
   //Method which loops through the values of the array and sums the costs of the individual DigitalVideoDiscs
   public float totalCost(){
       float sum = 0;
       for (int i = 0 ; i < qtyOrdered ; i++){
           sum += itemsOrdered[i].getCost();
       }
       return sum;
   }
   
   //Method to remove the item
   public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean found = false;
		for (int i=0; i<qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				found = true;
				for (int j=i; j<qtyOrdered-1; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				qtyOrdered--;
				itemsOrdered[qtyOrdered] = null;
				System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
			}
		}
		
		if (!found) {
			System.out.println("Couldn't find the specified disc.");
		}
	}
}
