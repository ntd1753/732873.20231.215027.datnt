package hust.soict.vn.test.media;
import java.util.*;
import hust.soict.vn.aims.media.*;

public class TestMedia {
   public static void main(String[] args) {
	   List<Media> mediae = new ArrayList<Media>();
	   Book books = new Book ("Nha gia kim", "Literature", 29.90f);
	   Media cd = new CompactDisc("Christmas","Music", "Leroy Sane","ABC",20.4f);
	   Media dvd = new DigitalVideoDisc("The lord","Animation","Tom MN",50, 21.5f);
	   mediae.add(dvd);
	   mediae.add(cd);
	   mediae.add(books);
	   
	   Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
	   for(Media m: mediae) {
		   System.out.println(m.toString());
	   }
	   
	   System.out.println();
	   System.out.println();
	   
	   Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
	   for(Media m: mediae) {
		   System.out.println(m.toString());
	   }
   }
}
