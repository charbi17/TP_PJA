/** by Charbi Abdellah Mohcen | Grp 3 de TP **/

import java.io.*;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			// Starting socket of the client
			Socket soc = new Socket("localhost",50725);
			System.out.println("Client is started !");
			
			
			while(true) {
				// Getting data from user
				BufferedReader userInpt = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter a cmd : ");
				String cmd = userInpt.readLine();
				
				
				// Sending data to server
				PrintWriter out = new PrintWriter(soc.getOutputStream(), true); // true is for "auto-flushing"
				out.println(cmd);
				
				// checking if it is the end
				if(cmd.equalsIgnoreCase("quit")) {
					System.out.println("\"Session Terminated !\"");
					soc.close();
					break;
				}
				
				// Reading data the server has send 
				BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				// printing that data
				String s = in.readLine();
//				while((s = in.readLine()) != null) {
//				}
				
				System.out.println(s.replace('|', (char)10));
					
				// to make sure that the program had reached this line ^^
//				System.out.println("_+_+_+_+_+_+");
			} // end while
			
			
		}catch(Exception e) {System.out.println(e);}
	}
}
/** by Charbi Abdellah Mohcen | Grp 3 de TP **/
