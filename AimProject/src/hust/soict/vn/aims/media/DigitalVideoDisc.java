package hust.soict.vn.aims.media;

import java.util.Scanner;
public class DigitalVideoDisc extends Disc implements Playable {
    
	public DigitalVideoDisc(String title) {
		super(title);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}

	public String getDetails() {
		return String.format("---DVD---\nTitle: %s\nCategory: %s\nDirector: %s\nLength: %dm.\nCost: %.2f $\n", title,
				category, director, length, cost).replaceAll(" null | 0 ", " Unknown ");
	}


	@Override
	public String toString() {
		return String.format("DVD - %s - %s - %s - %dm. : %.2f $", title, category, director, length, cost)
				.replaceAll(" null | 0 ", " Unknown ");
	}
	
	public void play() {
		if (length <= 0) {
			System.out.println("This DVD cannot be played.");
			return;
		}
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	public static DigitalVideoDisc createDVD() {
		System.out.println("---New DVD---");
		String title, category, director;
		int length;
		float cost;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter title: ");
		title = sc.nextLine();

		System.out.print("Enter category: ");
		category = sc.nextLine();

		System.out.print("Enter director: ");
		director = sc.nextLine();

		System.out.print("Enter length: ");
		length = sc.nextInt();

		System.out.print("Enter cost: ");
		cost = sc.nextFloat();

		return new DigitalVideoDisc(title, category, director, length, cost);
	}
}
