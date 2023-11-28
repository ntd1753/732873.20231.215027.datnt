package hust.soict.vn.garbage;

public class GarbageCreator {
	public static void main(String[]args){
		for (int i=1; i<=1000000; i++) {
			String s = new String("String"+i);
		}
	}
}
