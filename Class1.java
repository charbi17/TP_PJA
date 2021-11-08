package Dev_TP2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Class1 {

	public static void main(String [] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Tappez le Nombre des Employees :");

		int nmbrEmp = sc.nextInt();
		Employee [] Empls = new Employee[nmbrEmp];
		
		for (int i = 0; i<nmbrEmp; i++) {
			int j = i+1;
			Empls[i]= new Employee();
			
			System.out.println("Employee Numero " + j + "\nTappez le nom :");
			Empls[i].name = sc.next();
			
			System.out.println("Tappez l`address :");
			Empls[i].address = sc.next();
			
			System.out.println("Tappez l`SSN :");
			Empls[i].SSN = sc.nextInt();
			
			System.out.println("Tappez le number :");
			Empls[i].number = sc.nextInt();
		}
		sc.close();
		
		// Serialization
		
		FileOutputStream fileOut = new FileOutputStream("emp.dat");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(Empls);
		out.close();
		fileOut.close();
		
		System.out.println("DOne");
	}
}
