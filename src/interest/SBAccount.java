package interest;
import java.util.Scanner;

public class SBAccount extends Account{
	Scanner s = new Scanner(System.in);
	public int amount = 0;
	public double rateOfInterest = 0, interest = 0;
	public int choice = 0;
	
	public void sda() {
		System.out.println("Enter the average amount in your account:");
		amount = s.nextInt();
		if(amount < 0) {
			System.out.println("Invalid amount entered. Please enter non-negative amount.");
			sda();
		}
		calculateInterest();
		interest = amount*rateOfInterest;
		System.out.println("Interest gained is "+Math.round(interest)/100);
		Main.display();
	}

	@Override
	double calculateInterest() {
		System.out.println("Enter your account type:");
		System.out.println("1. Normal");
		System.out.println("2. NRI");
		System.out.println("Enter your choice");
		choice = s.nextInt();
		switch(choice) {
		case 1: rateOfInterest = 4;
		break;
		case 2: rateOfInterest = 6;
		break;
		default:
			System.out.println("Enter a valid type.");
			calculateInterest();
		}
		return rateOfInterest;
	}
}
