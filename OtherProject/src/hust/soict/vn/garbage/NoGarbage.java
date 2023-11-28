package hust.soict.vn.garbage;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class NoGarbage {

	public static void main(String[] args) throws IOException {
		String filename = "D:\\thuchanhoop\\732873.20231.215027.datnt\\OtherProject\\src\\hust\\soict\\vn\\garbage\\test.txt";
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		String outputString = "";
		for (byte b : inputBytes) {
			outputString += (char) b;
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

		startTime = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b : inputBytes) {
			outputStringBuilder.append((char) b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}