package Student;

import java.util.Scanner;

public class StudentInfo {
	
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		int choice;
		Student st = new Student();
		boolean in = true;
		System.out.println("Main Menu \n=========");
		while(in) {
		    System.out.println("1. Add Student Details :");
			System.out.println("2. Display Students:");
			System.out.println("3. Search And Print Students");
			System.out.println("4. Add details to file");
			System.out.println("5. Exit");
		choice= s.nextInt();
		switch (choice) {
		case 1:
		    st.add();
			break;
		case 2:
		    st.listinventory();
		    break;
		case 3:
			st.search();
			break;
		case 4:
			String fileName = "Details.ser";
			st.addtofile(fileName);
			System.exit(0);
			break;
		case 5:
			System.exit(0);
		}
	}
	}
}