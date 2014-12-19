package dbconnect;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class SysMan {

    public String[] analyzePath( String path ){
	      

	   	  int count = 0;
	   	  String[] shutCompilerUp = new String[1];
	   	  
	      File name = new File( path );

	         if ( name.isDirectory() ){
	            String directory[] = name.list();
	  	   	    String[] contents = new String[directory.length];
	            
	            for ( String directoryName : directory ){
	            		contents[count] = directoryName;
	            		count++;
	            }
	            return contents;
	         } 
	         
	      else{
	    	 JOptionPane.showMessageDialog(null, path,"ERROR: Path Does Not Exist!", JOptionPane.ERROR_MESSAGE);
	    	 System.exit(0);
	         return shutCompilerUp;
	      } 
	   } 

    public String getOperatingSystem(){
    	String OS = System.getProperty("os.name").toLowerCase();
    	
    	if(OS.indexOf("win") >= 0){
    		return "Windows";
    	}
    	if(OS.indexOf("mac") >= 0){
    		return "Mac";
    	}
    	if(OS.indexOf("nix") >= 0 ||OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ){
    		return "Linux";
    	}
    	if(OS.indexOf("sunos") >= 0){
    		return "Solaris";
    	}
    	else{
    		return "Unknown";
    	}

    }
    public void printCurDir(String loc){
    	int i=1;
    	File f = new File(loc); 

		File[] files = f.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.print("Option " + i + ": ");
			} else {
				System.out.print("     file:");
			}
			try {
				System.out.println(file.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			i++;
		}

    }
}
