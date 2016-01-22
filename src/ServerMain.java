import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerMain {

	static String folderPath = "";
	static String filename ="";
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(5800);
			
			BufferedReader brFromRobot = new BufferedReader(new InputStreamReader(ss.accept().getInputStream()));
			FileWriter fwToFile = new FileWriter(new File(folderPath + filename));
			BufferedReader frFromFile;		
			BufferedWriter bwToRobot = new BufferedWriter(new OutputStreamWriter(ss.accept().getOutputStream()));
			
			String line = null;
			while((line = brFromRobot.readLine()) != null) { 
				if(line.equalsIgnoreCase("Run Auton")) {
					frFromFile = new BufferedReader(new FileReader(new File(brFromRobot.readLine())));
					while((line = frFromFile.readLine()) != null) {
						bwToRobot.write(line);
					}
					break;
				}
				fwToFile.write(line);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
