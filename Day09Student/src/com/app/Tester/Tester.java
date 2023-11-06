package com.app.Tester;
import com.app.core.*;


import static utils.StudentCollectionUtils.*;
import custom_exception.StudentCollectionException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Tester
{
	public static void main (String[] args) 
	{
		try(Scanner sc=new Scanner(System.in))
		
		{
		boolean flag=false;
		List<Student> StudentList=populateList();
		Map<String, Student> StudentMap=populateMap(StudentList);
		
		
		
		while(!flag)	
		{
		System.out.println
				("\n1.Student Admission"
				+ "\n2. Display all student details"
				+ "\n3. Cancel Admission(i/p : RollNo)"
				+ "\n4. Find out specific student's details(i/p : RollNo)"
				+"\n5. Remove students for selected subjects"
				+"\n6. Write Map values into text file"
				+"\n7. Read Values from text file onto console"
				+"\n8.Write values from previous  text files into another text file"
				+"\n9. Write Map into Binary files"
				+"\n10. Read Data from binary files "
				+ "\n0. Exit");
		
		
		
		
		try {
			
			switch(sc.nextInt())
			{
			case 1:System.out.println("------Accept Student---------");
			//StudentMap.putIfAbsent("dac-010", )
			System.out.println("Enter rollno,name,DOB,subject,GPA");
			//Student NewST=new Student("dac-010", "Papa","Mike" ,"Java", 6.7);
				break;
			
			case 2:System.out.println("-----Display all student details------------");
			StudentMap.values().stream()
			.forEach(i->System.out.println(i));
				break;
				
			case 3:System.out.println("------Cancel Admission(As per roll num)-------");
			System.out.println("Enter roll num=");
			String roll=sc.next();
			Student RM=new Student(roll);
			Student Removed=StudentMap.remove(RM.getRollNo());
			System.out.println("The follwing student has been removed "+Removed);
			
				break;
			
			case 4:System.out.println("----------Show selected student(roll num)--------");
			System.out.println("Enter student roll num=");
			String rollnum=sc.next();
			StudentMap.values().stream()
			.filter(i->i.getRollNo().equals(rollnum))
			.forEach(i->System.out.println(i));
			
				break;
				
			case 5:System.out.println("--------Remove student as per subject name-----");
			System.out.println("Enter subject name=");
			String Sub=sc.next().toUpperCase();
			Subject temp=Subject.valueOf(Sub);
			
			/* ************************ **************** ************
			StudentMap.values().stream()
			.filter(h->h.getSubject().equals(temp))
			.forEach(i->StudentMap.remove(i.getRollNo()));
			break;
			+"\n6. Write Map values into text file"
				+"\n7. Read Values from text file onto console"
				+"\n8.Write values from previous  text files into another text file"
				+"\n9. Write Map into Binary files"
				+"\n10. Read Data from binary files "
			*/
			break;
			case 6:System.out.println("----Write Values into text file----");
			//Java App --> PW ---> FW --> dest text file
			System.out.println("Enter destination file name=");//textfile.txt
				
				try (PrintWriter PW=new PrintWriter(new FileWriter(sc.next())))
				{
					//PW.write(StudentMap.values().stream().toString());
					
					{
						//for(StudentMap.entry<
					}
					
				}
				/*
				 * Collection<String> dataCollection = // Your collection (e.g., ArrayList, HashSet, etc.)

try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
    for (String data : dataCollection) {
        writer.println(data); // Use print() if you want to write without a newline
    }
} catch (IOException e) {
    e.printStackTrace();
    // Handle the exception as needed
}

				 */
				catch (Exception PWex)
				{
					PWex.printStackTrace();
				}
				
				System.out.println("****Map contents has been copied into text file *******");
				
				break;
				
				
			case 8:System.out.println("--------Read data from text file on console------");
			
			System.out.println("Enter source file name=");
			
			try (BufferedReader BR=new BufferedReader(new FileReader(sc.next())))
			{	System.out.println("******Reading Data from Text file****");
				BR.lines().forEach(i->System.out.println(i));
				System.out.println("*******Reading done*****");
			}
			catch (Exception brEx)
			{
				brEx.printStackTrace();
			}		
				break;
				
				
			case 9:System.out.println("---------Write data from one text file to another-----");
				break;
				
			case 10:System.out.println("-----------Write data into binary file---------");
				break;
				
			case 11:System.out.println("-----------Read data into binary file---------");
				break;
				
				
			case 0:System.out.println("Exiting..!!");
				flag=true;
			
				break;
				
			}
		}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		
		
		
		}
	
	}
	
}
}