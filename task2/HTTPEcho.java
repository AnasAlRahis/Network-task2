import java.net.*;
import java.io.*;

public class HTTPEcho {
    public static void main( String[] args) throws IOException {
        // Your code here
		
		ServerSocket testsocket = new ServerSocket(Integer.parseInt(args[0]));
		
		String teststring = " ";
		
		try {
		while(true) { 
			StringBuilder input_string = new StringBuilder();
			Socket testconnection = testsocket.accept();
			input_string.append("HTTP/1.1 200 OK\r\n");
			input_string.append("\r\n");
			
			BufferedReader bufferinput = new BufferedReader(new InputStreamReader(testconnection.getInputStream()));
			teststring = bufferinput.readLine();
				System.out.print(teststring);
			
			//testconnection.getOutputStream().write(input_string.toString().getBytes());
			bufferinput.close();
			testconnection.close();
			
		}	
		} 
		catch(IOException ex){ 
			
			System.err.println(ex);
		}
			
	}
}

