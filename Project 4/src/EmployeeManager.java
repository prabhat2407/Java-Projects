import java.util.*;
import java.io.*;

public class EmployeeManager {
    int choice=0;
    Scanner s= new Scanner(System.in);
    List<Employee> EmployeeList= new LinkedList<Employee>();
    public static void main(String[] args) {
          EmployeeManager obj= new EmployeeManager();
          obj.displayMenu();
          while(obj.choice!=5) {
               obj.displayMenu();
          }
    }

    void displayMenu() {
    	  System.out.println("-----------------------------------------------------");
          System.out.println("--------------------Main Menu--------------------");
          System.out.println("1.Add an employee");
          System.out.println("2.Display All");
          System.out.println("3.Write all the entered employees to file");
          System.out.println("4.Read all the employees from the file");
          System.out.println("5.Exit");
          System.out.println("Choose an option from the above menu:");

          choice=s.nextInt();
          try {
               switch(choice) {
               case 1:
                    getEmployeeInformation();
                    break;
               case 2:
                    displayFromList(EmployeeList);
                    System.out.println("Displayed List of Employees.");
                    break;
               case 3:
                    System.out.println("Write the file name you want to write to: ");
                    writeEmployeesToFile(s.next());
                    break;
               case 4:
                    System.out.println("Write the file name you want to read from: ");
                    readEmployeesFromFile(s.next());
                    break;
               case 5:
                    System.out.println("Exiting the program....");
                    System.out.println("System exited successfully.");
                    System.exit(0);
               default:
                    	System.out.println("Invalid option, please enter a valid option.");
                    	displayMenu();
               }
          }
          catch(InputMismatchException e) {
               System.out.println("Exception is----->"+e);
          }
    }
    
    void writeEmployeesToFile(String fileName) {
          File fileObject= new File(fileName);
          FileOutputStream fileStreamObject;
          try {
               fileStreamObject = new FileOutputStream(fileObject);
               System.out.println("Writing Employee details to '"+fileName+"'.");
               System.out.println("Employee details added to the file '"+fileName+"'.");
               ObjectOutputStream objectWriterToFile= new ObjectOutputStream(fileStreamObject);
               System.out.println();
               objectWriterToFile.writeObject(EmployeeList);
          } 
          catch (FileNotFoundException e) {
               e.printStackTrace();
          }
          catch (IOException e) {
               e.printStackTrace();
          }
    }
    
    String readEmployeesFromFile(String fileName) {
          String status = null;
          File fileobject= new File(fileName);
          System.out.println("Reading from the file '"+fileName+"'.");
          System.out.println("File read successfully.");
          System.out.println("Displaying Employee deatils....");
          if(!fileobject.exists()) {
               status="unable to create the file";
               return status;
          }
          FileInputStream fileStreamObject;
          try {
               fileStreamObject = new FileInputStream(fileobject);
               ObjectInputStream objectReaderFromFile= new ObjectInputStream(fileStreamObject);
               EmployeeList.clear();
               EmployeeList=(List<Employee>) objectReaderFromFile.readObject();
               status=displayFromList(EmployeeList);
               if(status.equalsIgnoreCase("Displayed Successfully")) {
                    status="Files read from file successfully";
               }
               else {
                    status="";
               }
          } 
          catch (FileNotFoundException e) {
               e.printStackTrace();
          } 
          catch (IOException e) {
               e.printStackTrace();
          } 
          catch (ClassNotFoundException e) {
               e.printStackTrace();
          }
          finally {
               
          }
       return status;
    }
    
    void getEmployeeInformation() {
          System.out.println ("Enter Employee ID:");
          try {
          int id=s.nextInt();
          System.out.println ("Enter Employee Name:");
          String name=s.next();
          System.out.println ("Enter Employee Age:");
          int age=s.nextInt();
          System.out.println ("Enter Employee Salary:");
          double salary= s.nextDouble();
          System.out.println("Employee information added successfully.");
          EmployeeList.add(new Employee(id, name, salary, age));
          }
          catch(InputMismatchException e) {
               System.out.println(""+e);
          }
    }

    String displayFromList(List<Employee> objectList) {
          String status="";
          try {
          Iterator objectIterator= objectList.iterator();
          while(objectIterator.hasNext()) {
               System.out.println (""+objectIterator.next());
          }
          status="Displayed Successfully";
          return status;
          }
          catch(Exception e) {
               status="Failure";
               return status;
          }
    }

}