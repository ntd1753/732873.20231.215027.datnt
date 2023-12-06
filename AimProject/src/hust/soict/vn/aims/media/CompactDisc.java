package hust.soict.vn.aims.media;

import java.util.ArrayList;
import java.util.Scanner;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc(String title) {
		super(title);
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public CompactDisc(String title, String category, String artist, float cost) {
		this(title, category, cost);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, String artist, String director, float cost) {
		this(title, category, artist, cost);
		this.director = director;
	}

	public String getArtist() {
		return artist;
	}

	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Track already exists.");
		} else {
			tracks.add(track);
			System.out.println("Added track " + track.getTitle() + " to CD.");
		}
	}

	public void removeTrack(Track track) {
		if (tracks.remove(track)) {
			System.out.println("Removed track " + track.getTitle() + " from CD.");
		} else {
			System.out.println("Track doesn't exists.");
		}
	}
     
	public String getDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("---CD---\nTitle: %s\nCategory: %s\nArtist: %s\nLength: %dm.\nCost: %.2f $\n", title,
				category, artist, getLength(), cost).replaceAll(" null | 0 ", " Unknown "));
		for (int i = 0; i < tracks.size(); i++)
			sb.append("\nTrack no. " + (i + 1) + "\n" + tracks.get(i).getDetails());
		return sb.toString();
	}
	public int getLength() {
		int length = 0;
		for (Track t : tracks) {
			length += t.getLength();
		}
		this.length = length;
		return length;
	}
	
	public void play() {
		if (getLength() <= 0) {
			System.out.println("This CD cannot be played.");
			return;
		}
		System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
		System.out.println("CD total length: " + this.getLength());
		for (Track t : tracks) {
			t.play();
		}
	}
	public String toString() {
		return String.format("CD - %s - %s - %s - %dm. : %.2f $", title, category, artist, getLength(), cost)
				.replaceAll(" null | 0 ", " Unknown ");
	}
	
	public static CompactDisc createCD() {
		System.out.println("---New CD---");
		String title, category, artist, director;
		float cost;
		int nbTracks;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter title: ");
		title = sc.nextLine();

		System.out.print("Enter category: ");
		category = sc.nextLine();

		System.out.print("Enter artist: ");
		artist = sc.nextLine();

		System.out.print("Enter director: ");
		director = sc.nextLine();

		System.out.print("Enter cost: ");
		cost = sc.nextFloat();

		CompactDisc cd = new CompactDisc(title, category, artist, director, cost);

		System.out.print("Enter number of tracks: ");
		nbTracks = sc.nextInt();

		for (int i = 0; i < nbTracks; i++) {
			System.out.println("\nTrack no. " + (i + 1));
			cd.addTrack(Track.createTrack());
		}

		return cd;
	}

}
