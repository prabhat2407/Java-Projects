package interest;
import java.util.Scanner;

public class Main {
	public static void display() {
		Scanner s = new Scanner(System.in);
		System.out.println("---------------Main menu--------------");
		System.out.println("------------------------------------------");
		System.out.println("1. Interest Calculator -> SB");
		System.out.println("2. Interest Calculator -> FD");
		System.out.println("3. Interest Calculator -> RD");
		System.out.println("4. Exit");
		System.out.println("Enter your option from above");
		int option = s.nextInt();
		switch(option) {
		case 1: SBAccount sb = new SBAccount();
		sb.sda();
		break;
		case 2: FDAccount fd = new FDAccount();
		fd.fda();
		break;
		case 3: RDAccount rd = new RDAccount();
		rd.rda();
		break;
		case 4: System.exit(0);
		break;
		default:
			System.out.println("Enter a valid option.");
		}
	}
	public static void main(String[] args) {
		display();
	}
}