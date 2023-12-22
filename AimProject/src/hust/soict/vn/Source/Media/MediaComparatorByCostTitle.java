
package Media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		return Float.floatToIntBits(o2.getCost()) - Float.floatToIntBits(o1.getCost());
	}

}