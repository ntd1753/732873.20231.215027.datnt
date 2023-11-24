package hust.soict.vn.aims;
import hust.soict.vn.aims.cart.Cart;
import hust.soict.vn.aims.disc.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		//create a new cart
        Cart user_01_cart = new Cart();
        
        //Create new dvd objects and add them to the cart 
        DigitalVideoDisc dvd_01 = new DigitalVideoDisc("The lion king", "Animation", "Roger Aller", 87, 19.95f);
        DigitalVideoDisc dvd_02 = new DigitalVideoDisc("Star war", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd_03 = new DigitalVideoDisc("Only title");
        DigitalVideoDisc dvd_04 = new DigitalVideoDisc("Aladin", "Animation", 12.5f);
        DigitalVideoDisc dvd_05 = new DigitalVideoDisc("Aladin", "Animation", "Davis", 18.99f);
        
        user_01_cart.addDigitalVideoDisc(dvd_01);
        user_01_cart.addDigitalVideoDisc(dvd_02);
        user_01_cart.addDigitalVideoDisc(dvd_03);
        user_01_cart.addDigitalVideoDisc(dvd_04);
        //System.out.println("Total cost is : " + user_01_cart.totalCost() + "$");
        user_01_cart.print();

	}

}