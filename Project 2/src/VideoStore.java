/*Design and implement a simple inventory control system for a small video rental store
 * This class contains VideoStore class which extends Video class*/

import java.util.Scanner;

public class VideoStore extends Video{
	Video v[] = new Video[100];
	static int i = 0;
	
	void addVideo(String title) {
		v[i] = new Video();
		this.title = title;
		v[i].title = title;
		i++;
		System.out.println("Video Added Successfully.");
	}
	
	void checkOut(String title) {
		for(int k=0; k<i; k++) {
			if(v[k].title.equalsIgnoreCase(title)) {
				if(v[k].checked()) {
					v[k].rent();
					System.out.println("Video is rented.");
				}
				else {
					System.out.println("Sorry, video is not available.");
				}
			}
		}
	}
	void returnVideo(String title) {
		if(i==0) {
			System.out.println("You have no video to return.");
		}
		for(int k=0; k<i; k++) {
			if(v[k].title.equalsIgnoreCase(title)) {
				v[k].checked = true;
			}
		}
	}
	public void receiveRating(String title) {
		if(i==0) {
			System.out.println("No video inventory available.");
		}
		else {
			for(int k=0; k<i; k++) {
				System.out.println("Enter the rating for the video "+v[k].title);
				Scanner s = new Scanner(System.in);
				v[k].avgrating = s.nextInt();
			}
		}
	}
	public void listInventory() {
		if(i==0) {
			System.out.println("No video in inventory.");
		}
		else {
			for(int k=0; k<i; k++) {
				System.out.println(k+1 +". "+v[k].title+" "+" Rating "+v[k].avgrating+" Availability "+v[k].checked());
			}
		}
	}
}
