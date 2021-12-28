/** by Charbi Abdellah Mohcen | Grp 3 de TP **/

import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File serverStorage = new File("C:\\Users\\AbduLLAH\\Desktop");
		int port = 50725;
		try {
			// creating server socket object
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Waiting for clients ..");
			
			// establishing connection with user
			System.out.println("Server Listening on Port " + port);
			Socket sok = ss.accept();
			System.out.println("\nConnected successfully to Client");
			
			PrintWriter out = new PrintWriter(sok.getOutputStream(), true);
			
			// Reading message form client
			BufferedReader in = new BufferedReader(new InputStreamReader(sok.getInputStream()));
			
			// to keep server running
			while(true) {
				File folder = null;
				BufferedReader fileRdr = null;
				
				String cmd = in.readLine();
	
				// Processing case of Folder
				if(cmd.startsWith("List ")  || cmd.startsWith("list ")) {
					// searching for folder
					for (String f : serverStorage.list()) {
						if(f.startsWith(cmd.substring(5))) {
//							out.println("Server says : file found +++");
							folder = new File("C:\\Users\\AbduLLAH\\Desktop\\"+cmd.substring(5)); 
							
							//listing folder files
							String listFiles = "";
							for (String o : folder.list()) {
//								System.out.println(o);
								listFiles += o.toString()+"|";
							}
							out.println(listFiles);
							break;
						}
					} // End for
					if(folder == null) {out.println("ERROR : directory does not exist");}
				} // End if
				// in case of List command 
				else if(cmd.startsWith("Get ")  || cmd.startsWith("get "))  {
					
					// searching for file
					for (String f : serverStorage.list()) {
						if(f.contains(cmd.substring(4))) {
//							out.println("file found");
							fileRdr = new BufferedReader(new FileReader("C:\\Users\\AbduLLAH\\Desktop\\"+cmd.substring(4)));
							String fileContent="", s;
							while((s = fileRdr.readLine()) != null) {
								fileContent += s.toString()+"|";
							}
							out.println(fileContent);
							break;
						}
					}
					if(fileRdr == null) {out.println("ERROR : File does not exist");}
				}
				else if(cmd.equalsIgnoreCase("quit")) {
					sok.close();
					break;
				} else {
					out.println("Unkonwn Command, Please Try Again (List, Get or Quit)");
				}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

/** by Charbi Abdellah Mohcen | Grp 3 de TP **/
