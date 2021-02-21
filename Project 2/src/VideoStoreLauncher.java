/*Design and implement a simple inventory control system for a small video rental store
 * This class contains VideoStoreLauncher*/

import java.util.Scanner;

public class VideoStoreLauncher {
	public static void main(String[] args) {
		VideoStore vs = new VideoStore();
		int ch, ch1, ch2;
		String title, choice;
		do {
			System.out.println("=========Menu========");
			System.out.println("1. Login as User");
			System.out.println("2. Login as Admin");
			System.out.println("Enter your choice");
			Scanner s = new Scanner(System.in);
			ch = s.nextInt();
			do {
				switch(ch) {
				case 1:
					System.out.println("1.  List  Inventory");
					System.out.println("2. Rent Video");
					System.out.println("3. Enter the rating of video");
					System.out.println("4. Return Video");
					ch1 =  s.nextInt();
					if(ch1==1) {
						vs.listInventory();
					}
					else if(ch1==2){
						vs.listInventory();
						System.out.println("Enter the video name you want");
						title = s.next();
						vs.checkOut(title);
					}
					else if(ch1==3) {
						vs.listInventory();
						System.out.println("Enter the video name you want to give rating to");
						title = s.next();
						vs.receiveRating(title);
					}
					else if(ch1==4) {
						vs.listInventory();
						System.out.println("Enter the video you want to return");
						title = s.next();
						vs.returnVideo(title);
						System.out.println("Video returned successfully.");
					}
					else {
						System.out.println("No such option is available.");
					}break;
				case 2:
					System.out.println("1. List Inventory");
					System.out.println("2. Add Video");
					ch2 = s.nextInt();
					if(ch2==1) {
						vs.listInventory();
					}
					if(ch2==2) {
						System.out.println("Enter the name of the video");
						title = s.next();
						vs.addVideo(title);
					}break;
					default:
						System.out.println("Sorry wrong choice.");
				}
				System.out.println("Do you want to repeat yes/no");
				choice = s.next();
			}
			while(choice.equalsIgnoreCase("yes"));
			System.out.println("Want to return to main menu yes/no");
			choice = s.next();
		}while(choice.equalsIgnoreCase("yes"));
	}
}
