package hust.soict.vn.aims.media;
import java.util.ArrayList;
import java.util.Scanner;

public class Book extends Media {

	private ArrayList<String> authors = new ArrayList<String>();

	public Book() {
		super();
	}
    public Book(String title) {
		super(title);
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public boolean addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			return authors.add(authorName);
		}
		return false;
	}

	public boolean removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			return authors.remove(authorName);
		}
		return false;
	}
	public String getDetails() {
		return String.format("---Book---\nTitle: %s\nCategory: %s\nAuthor(s): %s\nCost: %.2f $\n", title,
				category, String.join(", ", authors), cost).replaceAll(" null | 0 ", " Unknown ");
	}
	public String toString() {
		return String
				.format("Book - %s - %s - %s : %.2f $", title, category,
						authors.isEmpty() ? "Unknown" : String.join(", ", authors), cost)
				.replaceAll(" null | 0 ", " Unknown ");
	}
	public static Book createBook() {
		System.out.println("---New Book---");
		String title, category;
		float cost;
		String[] authors;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter title: ");
		title = sc.nextLine();

		System.out.print("Enter category: ");
		category = sc.nextLine();

		System.out.print("Enter author name(s): ");
		authors = sc.nextLine().split(",\\s*");

		System.out.print("Enter cost: ");
		cost = sc.nextFloat();

		Book book = new Book(title, category, cost);
		for (String author : authors) {
			book.addAuthor(author);
		}

		return book;
	}
}

