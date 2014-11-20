package dbconnect;

import java.io.IOException;
import java.util.Formatter;

public class writedb {

	public static void main(String[] args) {
		

	}
	private Formatter output;
	//Location we are going to write the file too. 
	
	//Opens the file that we are going to rite stuff out too.
	public void openFile(String FileName){
		try{
			output = new Formatter(FileName +".txt");	
		}
		catch(IOException exception){
			System.out.println("ERROR");
		}
	}
	
	//Closes the file we've written too once were done with it
	public void closeFile(){
		if(output !=null){
			output.close();
		}
	}
	
	//Adds stuff to the file we've opened 
	public void writeDb(String content){
		output.format("---------------------------------------------------------------------------------------\r\n");
		output.format("%s",content);
		output.format("---------------------------------------------------------------------------------------\r\n");
	
		
	}
}
