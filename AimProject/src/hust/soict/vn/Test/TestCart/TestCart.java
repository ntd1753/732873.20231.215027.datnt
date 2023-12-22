
package TestCart;

import Cart.Cart;
import Exception.DuplicatedItemException;
import Media.Book;
import Media.CompactDisc;
import Media.DigitalVideoDisc;
import Media.Media;
import Media.Track;

import java.util.ArrayList;
import java.util.List;

import javax.naming.LimitExceededException;

public class TestCart {
    private static List<Track> tracks;

    public static void main(String[] args) throws LimitExceededException, DuplicatedItemException {
        // Create a new cart
        Cart anOrder = new Cart();

        // Create new Media objects and add them to the cart
        // Create an array to store Media information
        Media[] mediaList = new Media[3];

        // Create Media
        Media media1 = new DigitalVideoDisc("The Lion King", "Animation", "John Director",19.95f);
        Media media2 = new Book("Tấm cám", "Animation", 18.15f);
        Media media3 = new Book("Thạch sanh", "Animation", 10.1f);

        // Add Media to the array
        mediaList[0] = media1;
        mediaList[1] = media2;
        mediaList[2] = media3;

        anOrder.addMedia(media1);
        anOrder.addMedia(media2);
        anOrder.addMedia(media3);

        // Print information of each Media in the cart
        for (Media m : mediaList) {
            System.out.println(m.toString());
        }
    }
}
