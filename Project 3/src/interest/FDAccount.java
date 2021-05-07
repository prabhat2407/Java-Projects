package interest;
import java.util.Scanner;

public class FDAccount extends Account{
	public int age=0,amount=0,days=0;
	public double rateOfInterest =0;
	public double interest=0;
	Scanner s= new Scanner(System.in);
	public void fda() {
		calculateInterest();
		double I = (amount * rateOfInterest)/100;
		System.out.println("Interest Gained is "+Math.round(I));
		Main.display();
	}
	@Override
	double calculateInterest() {
		System.out.println("Enter the FD amount:");
		amount  = s.nextInt();
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
		System.out.println("Enter number of days:");
		days = s.nextInt();
		if(days < 0) {
			try {
				System.out.println("Invalid number of days entered. Please enter non-negative number of days.");
				System.out.println("Starting the calculator again......");
				calculateInterest();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Enter your age:");
		age = s.nextInt();
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
		if(amount < 10000000) {
			if(age>60) {
				if(days>=7 && days<=14) {
					rateOfInterest = 5.00;
				}
				else if(days>=15 && days<=29) {
					rateOfInterest = 5.25;
				}
				else if(days>=30 && days<=45) {
					rateOfInterest = 6.00;
				}
				else if(days>=46 && days<=60) {
					rateOfInterest = 7.25;
				}
				else if(days>=61 && days<=184) {
					rateOfInterest = 8.00;
				}
				else if(days>=184 && days<=365) {
					rateOfInterest = 8.50;
				}
				else {
					System.out.println("Invalid number of days.");
				}
			}
			else {
				if(days>=7 && days<=14) {
					rateOfInterest = 4.50;
				}
				else if(days>=15 && days<=29) {
					rateOfInterest = 4.75;
				}
				else if(days>=30 && days<=45) {
					rateOfInterest = 5.50;
				}
				else if(days>=46 && days<=60) {
					rateOfInterest = 7.00;
				}
				else if(days>=61 && days<=184) {
					rateOfInterest = 7.50;
				}
				else if(days>=184 && days<=365) {
					rateOfInterest = 8.00;
				}
				else {
					System.out.println("Invalid number of days.");
				}
			}
			return (rateOfInterest/100)/365;
		}
		else {
			System.out.println("Enter the no. of days:");
			days = s.nextInt();
			if(days>=7 && days<=14) {
				rateOfInterest = 6.50;
			}
			else if(days>=15 && days<=29) {
				rateOfInterest = 6.75;
			}
			else if(days>=30 && days<=45) {
				rateOfInterest = 6.75;
			}
			else if(days>=46 && days<=60) {
				rateOfInterest = 8.00;
			}
			else if(days>=61 && days<=184) {
				rateOfInterest = 8.50;
			}
			else if(days>=184 && days<=365) {
				rateOfInterest = 10.00;
			}
			else {
				System.out.println("Invalid number of days.");
			}
			return (rateOfInterest/100)/365;
		}
	}

}
