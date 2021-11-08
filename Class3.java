package Dev_TP2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Class3 {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		RandomAccessFile raf = new RandomAccessFile("empdirect.dat", "r");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Tappez num de employee");
		int em = sc.nextInt();
		
//		for (int i = 0; i < Empls.length; i++) {
//			if(em == Empls[i].number) {
//			raf.writeUTF("Name : "+Empls[i].name + "\n"+ Empls[i].address +"\n"+ Empls[i].SSN + "\n"+ Empls[i].number + "\n __________");
//			}
//			}
//		raf.close();

	}
}
