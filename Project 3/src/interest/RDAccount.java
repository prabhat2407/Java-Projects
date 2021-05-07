package interest;
import java.util.Scanner;

public class RDAccount extends Account{
	public int age=0,amount=0,months=0;
	public double rateOfInterest =0;
	public double interest=0;
	Scanner s= new Scanner(System.in);
	
	public void rda() {
		calculateInterest();
		double I = (rateOfInterest * amount)/100;
		System.out.println("Interest Gained is "+Math.round(I));
		Main.display();
	}
	@Override
	double calculateInterest() {
		System.out.println("Enter the RD amount: ");
		amount = s.nextInt();
		if(amount < 0) {
			try {
				System.out.println("Invalid amount entered. Please enter non-negative amount.");
				System.out.println("Starting the calculator again......");
				calculateInterest();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Enter your age : ");
		age=s.nextInt();
		if(age < 0) {
			try {
				System.out.println("Invalid age entered. Please enter non-negative age.");
				System.out.println("Starting the calculator again......");
				calculateInterest();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Enter the number of months from(6,9,12,15,18,21)");
		months=s.nextInt();
		if(months < 0) {
			try {
				System.out.println("Invalid number of months entered. Please enter non-negative number of months from(6,9,12,15,18,21).");
				System.out.println("Starting the calculator again......");
				calculateInterest();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(age > 60) {
			if(months == 6) {
				rateOfInterest = 8.00;
			}
			else if(months == 9) {
				rateOfInterest = 8.25;
			}
			else if(months == 12) {
				rateOfInterest = 8.50;
			}
			else if(months == 15) {
				rateOfInterest = 8.75;
			}
			else if(months == 18) {
				rateOfInterest = 9.00;
			}
			else if(months == 21) {
				rateOfInterest = 9.25;
			}
			else {
				System.out.println("Invalid number of months entered.");
				System.out.println("Starting the calculator again......");
				calculateInterest();
			}
			return (rateOfInterest/100)/12;
		}
		else {
			if(months == 6) {
				rateOfInterest = 7.50;
			}
			else if(months == 9) {
				rateOfInterest = 7.75;
			}
			else if(months == 12) {
				rateOfInterest = 8.00;
			}
			else if(months == 15) {
				rateOfInterest = 8.25;
			}
			else if(months == 18) {
				rateOfInterest = 8.50;
			}
			else if(months == 21) {
				rateOfInterest = 8.75;
			}
			else {
				System.out.println("Invalid number of months entered.");
				System.out.println("Starting the calculator again......");
				calculateInterest();
			}
		}
		return (rateOfInterest/100)/365;
	}
}
