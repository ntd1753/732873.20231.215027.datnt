
package TestStore;

import Media.Media;
import Exception.DuplicatedItemException;
import Media.DigitalVideoDisc;
import Store.Store;

public class StoreTest {
    public static void main(String[] args) throws DuplicatedItemException {
        Store store = new Store();

        // Create some media to add to the store
        Media media1 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 19.99f);
        Media media2 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 15.99f);
        Media media3 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 22.99f);
    
        // Add media to the store
        store.addMedia(media1);
        store.addMedia(media2);
        store.addMedia(media3);

        // Display the current state of the store
        store.displayItems();

        // Remove media from the store
        store.removeMedia(media2);

        // Display the updated store
        store.displayItems();
     
    }
}
