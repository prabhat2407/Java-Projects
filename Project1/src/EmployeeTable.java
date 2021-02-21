/* Create an application to save the employee information using arrays having following fields:- 
 * empid[],depName[],empDes,empName[],dateJoin[],basic[],hra[],it[], DesCodes[]. 
Tasks:-
(a) Salary should be calculated as (Basic+HRA+DA-IT)      
(b)Printing designation and da according to employee designation.*/

//This is the same program like Employee.java but in this I have created a table using swing which shows the details in
//clean way.

import java.util.Scanner;
import javax.swing.*;
public class EmployeeTable {
	JFrame f;
	EmployeeTable(String empid, String empName, String depName, String desg, String sal){
		f = new JFrame();
		String data[][] = {{empid,empName,depName,desg,sal}};
		String column[] = {"Emp no.","Employee Name","Department","Designation","Salary"};
		JTable jt=new JTable(data,column);
	    jt.setBounds(30,40,200,300);          
	    JScrollPane sp=new JScrollPane(jt);    
	    f.add(sp);          
	    f.setSize(300,400);    
	    f.setVisible(true);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String empid[] = {"1001","1002","1003","1004","1004","1005","1006","1007"};
		String depName[] = {"R&D","PM","Acct","Front Desk","Engg","Manufacturing","PM"};
		String empName[] = {"Ashish","Sushma","Rahul","Chahat","Ranjan","Suman","Tanmay"};
		String dateJoin[] = {"01/04/2009","24/08/2012","12/11/2008","29/01/2013","16/07/2005","01/01/2000","12/06/2006"};
		int basic[] = {20000,30000,10000,12000,50000,23000,29000};
		int hra[] = {8000,12000,8000,6000,20000,9000,12000};
		int it[] = {3000,9000,1000,2000,20000,4400,10000};
		String desg = null;
		char DesCodes[] = {'e','c','k','r','m','e','c'};
		int pos = -1;
		System.out.println("Enter the Employee Id between "+empid[0]+" and "+empid[7]);
		String id = s.nextLine();
		for(int i=0;i<(empid.length);i++) {
			if(id.equals(empid[i])) {
				pos = i;
			}
		}
		if(pos==-1) {
			System.out.println("Employee Id does not exist");
			return;
		}
		int da = 0;
		char empDes = DesCodes[pos];
		switch(empDes) {
		case 'e':
			desg = "Engineer";
			da = 20000;
			break;
		case 'c':
			desg = "Consulants";
			da = 32000;
			break;
		case 'k':
			desg = "Clerk";
			da = 12000;
			break;
		case 'r':
			desg = "Receptionist";
			da = 15000;
			break;
		case 'm':
			desg = "Manager";
			da = 40000;
			break;
		}
		int salary = basic[pos]+hra[pos]+da-it[pos];
		String sal = String.valueOf(salary);
		new EmployeeTable(empid[pos],empName[pos],depName[pos],desg,sal);
//		System.out.println("Emp no.\t\tEmployee Name\t\tDepartment\t\tDesignation\t\tSalary");
//		System.out.println(empid[pos]+"\t\t"+empName[pos]+"\t\t\t"+depName[pos]+"\t\t\t"+desg+"\t\t\t"+salary);
	}
}