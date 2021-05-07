package Student;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.Scanner;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	public int uid, marks1 ,marks2;
	public String name;
	List<Student> list=new ArrayList<Student>();  
	
	Student it[]=new Student[10];
	int u,m1,m2,n;
	String snmae;
	public Student(){}
	public Student (int uid1, String name,int m1,int m2)
	{
		this.uid=uid1;
		this.name = name;
		this.marks1=m1;
		this.marks2=m2;
	}
	public int getuid ()
	{
		return this.uid;
		
	}
	public String getname ()
	{
		return this.name;
	}
	public int getmarks1 ()
	{
		return this.marks1;
	}
	public int getmarks2 ()
	{
		return this.marks2;
	}
	public String toString() {
        return uid +"\t"+name+"\t"+marks1+"\t"+marks2;
    }
	
	
	public void add()
	{
		System.out.println("Enter the Number of students you want to add");
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();
		int i =0;
		while(n-->0)		
		{
			System.out.println("Enter the student's uid");
			u=sc.nextInt();
			System.out.println("Enter the Student's name");
			snmae=sc.next();
			System.out.println("Enter the Student's marks in S1");
			m1=sc.nextInt();
			System.out.println("Enter the Student's marks in S2");
			m2=sc.nextInt();
			it [i]=new Student(u,snmae,m1,m2);
			list.add(it[i]);
			i++;
		}
		
	}
	public void listinventory()
	{
		Iterator<Student> itr = list.iterator();
		System.out.println("UID\tName\tMark1\tMark2");
        while (itr.hasNext())
            System.out.println(itr.next().toString());
        
	}
	public void search() {
		Scanner sc =  new Scanner(System.in);
		    int flag =0;
			System.out.println("Enter the uid of Student you want to search ");
			int choice =sc.nextInt();
				Iterator itr = list.iterator();
		        while (itr.hasNext())
		        {
		        	Student i = (Student)itr.next();
		        	//System.out.println(i.getname());
		            if(choice==i.getuid())
		            {
		            	flag =1;
		            	int total = i.getmarks1()+i.getmarks2();
		            	System.out.println("UID\tName\tTotal");
		            	System.out.println(i.getuid()+"\t"+ i.getname()+"\t"+total);
		            }
			}
		        if (flag ==0)
		        {
		        	System.out.println("Student does not exist");
		        }
		        else {
		        	System.out.println("");
		        }
		}
	void addtofile(String fileName)
	{
		if(fileName != null && !fileName.isEmpty()) {
			if(list.size()>0) {
				File mFile = new File (fileName);	
			try {
			FileOutputStream mFOS = new FileOutputStream(mFile);
			ObjectOutputStream mOOS = new ObjectOutputStream(mFOS);
			mOOS.writeObject(list);
			mOOS.close();
			System.out.println("Writing process completed successfully");
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			}
		}else {
			System.out.println("No records found to write");
		}	
	}
}