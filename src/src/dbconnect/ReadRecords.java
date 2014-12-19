package dbconnect;

import java.io.*;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadRecords {
	static SysMan sysMan = new SysMan();
	
	private String[] listData;
	private Scanner input;

	//Reads in a file based on user input
	   public String[] readRecords(String fileName){
			int count = 0;
			int length = 0;
			
		     String listDir = System.getProperty("user.dir"); //Grabs directory of program + lists\
		   //Reads in a file Line by Line.
	      try{     
	         FileInputStream fstream = new FileInputStream( listDir + "\\" +fileName);
	         DataInputStream in = new DataInputStream(fstream);
			 BufferedReader br = new BufferedReader(new InputStreamReader(in));
			 String StrLine;
			 //Reads in Line by Line and adds contents to a Array for later processing
	         while ( (StrLine = br.readLine()) != null ){
	 
	        	 if (count == 0){
	        		 try{	
	        			 length = Integer.parseInt(StrLine);
	        		 }
	        		 catch(Exception e){ 
	        			 System.out.println("The first line of the file should be a number!");
	        			 fstream.close();
	        	         br.close();
	        			 return listData;
	        		 }
	        		 listData = new String[length];
	        		 count++;
	        	 }
	        	 else{
	        		listData[count-1] = StrLine;
	        		count ++;
	        	 }
	         }
	         fstream.close();
	         br.close();
	         return listData;
	         
	      } 
	      //Catching possible exceptions
	      catch ( NoSuchElementException elementException ){;
	    	 System.out.println("Bad Format");
	         input.close();
	      } 
	      catch ( IllegalStateException stateException ){
	    	 System.out.println("Possible file permission issue?");
	      }
	      catch ( FileNotFoundException fileNotFoundException ){
	    	 System.out.println("ERROR: File Cannot Be Found!");
	      }
	      catch(Exception e){
	    	   	 System.out.println("ERROR: Unknown error.");
	      }
	      finally{
	         if ( input != null )
	            input.close();
	      }
	      return listData;
	   }
	   
	}
	   

