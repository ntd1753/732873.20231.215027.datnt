package hust.soict.vn.aims.media;

import java.util.Comparator;

public class MediaComparatorByCost implements Comparator<Media>{
	public int compare(Media o1, Media o2) {
		if (Float.floatToIntBits(o1.getCost()) > Float.floatToIntBits(o2.getCost()))
			return -1;
		if (Float.floatToIntBits(o1.getCost()) == Float.floatToIntBits(o2.getCost()))
			return 0;
		return 1;
    }
}
