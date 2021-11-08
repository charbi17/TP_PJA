package Dev_TP2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;

public class Class2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Employee [] Empls = null;
		FileInputStream fileIn = new FileInputStream("C:\\Users\\AbduLLAH\\eclipse-workspace\\Dev_TP2\\emp.dat");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		Empls = (Employee []) in.readObject();
		in.close();
		fileIn.close();
		
		
		RandomAccessFile raf = new RandomAccessFile("empdirect.dat", "rw");
		
		for (int i = 0; i < Empls.length; i++) {
			raf.writeUTF("Name : "+Empls[i].name + "\n"+ Empls[i].address +"\n"+ Empls[i].SSN + "\n"+ Empls[i].number + "\n __________");
//			raf.writeUTF("Name : "+Empls[i].name);
//			raf.writeUTF(Empls[i].address);
//			raf.write(Empls[i].SSN);
//			raf.write(Empls[i].number);
			}
		
		raf.seek(0);
		while (raf.getFilePointer() < raf.length()) {
			System.out.println(raf.readUTF());
			}
		raf.close();
		
	}

}
