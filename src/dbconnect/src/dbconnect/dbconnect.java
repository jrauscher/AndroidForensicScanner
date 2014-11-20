
package dbconnect;

import java.sql.*;
import java.util.Scanner;

import org.sqlite.SQLite;
import java.io.*;

@SuppressWarnings("unused")
public class dbconnect {
	static SysMan sysMan = new SysMan();
	static ReadRecords read = new ReadRecords();
	static writedb file = new writedb();
	static StringMan string = new StringMan();
	
	 public static void main(String args[]) {
		String curDir = System.getProperty("user.dir");
		sysMan.printCurDir(curDir+"\\database\\");
		 
	    System.out.print("\nName of phone/database directory:");
	    @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
	    String userDir = input.next();
	    
		String outDir = curDir + "\\output\\" + userDir + "\\";
		String dbDir = curDir + "\\database\\" + userDir + "\\";

		String sqlite = "jdbc:sqlite:";
	    String query = "select * from";
	    String fullQuery = "";
	    
	    String fileName = "";
	    String content = "";

	    String dbNames[] = sysMan.analyzePath(dbDir);
	    String url = sqlite + dbDir;
	    
	    String dbs[] = null;
	    String output[] = null;
	    dbs = new String[dbNames.length];
	    output = new String[dbNames.length];
	    
	    String keywords[] = read.readRecords("keywords.txt");
	    String Files = "";
	   
	    for(int i=0;i<dbNames.length;i++){
	    	if(i > 0){
	    		Files += "\r\n---------------------------------------------------------------------------------------";
	    	}
	    	
	    	Files += "\r\nDatabase:" + dbNames[i] + "\r\n";
	    	dbs[i] = url + dbNames[i];
	    	output[i] = outDir + dbNames[i];
	    	System.out.println("\nOpening database("+ (i+1) + "/" + dbNames.length +"): " + dbs[i]);
	    	String[] tableNames = getTableNames(dbs[i]);
		    
	    	fileName = string.removeDb(output[i]);
	    	
	    	File dir = new File(outDir + string.removeDb(dbNames[i])+ "\\");
	    	dir.mkdirs();
		    for(int k=0;k<tableNames.length;k++){ 	
		    	System.out.println("Creating file("+ (k+1) +"/"+ tableNames.length+"): " + fileName + "\\" + tableNames[k] +".txt");
		    	
		    	file.openFile(fileName + "\\" + tableNames[k]); 	
		    		fullQuery = query + " " + tableNames[k];
		    		content = dbCon(dbs[i],fullQuery,tableNames[k]);
		    		
		    		int flag = 0;
		    		for(int j=0;j<keywords.length;j++){
		    			if(content.contains(keywords[j])){
		    				String tempTableName = tableNames[k] + ".txt";
		    				if(flag == 0){
		    					Files += String.format("\r\nFile: %-30s Contains: %s",tempTableName,keywords[j]);
		    					flag = 1;
		    				}else{
		    					Files += ", " + keywords[j];
		    				}
		    			}
		    		}
				file.writeDb(content);
			    file.closeFile();
		    } 
		   
	    }
	    Files += "\r\n";
	    file.openFile(outDir + "\\foundWords"); 
	    file.writeDb(Files);
	    file.closeFile();
} 
	 
public static String[] getTableNames(String url){  	 
	Connection con = null;
	String[] names = null;
	int size = 0;
	int count = 0;
	
	  try {
		  	con = DriverManager.getConnection(url, "myLogin", "myPassword");
            DatabaseMetaData dbmd = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables(null, null, "%", types);
            while (rs.next()) {
            	size ++;
            }
        	names = new String[size];
            ResultSet rs1 = dbmd.getTables(null, null, "%", types);
            while (rs1.next()) {
                names[count] = rs1.getString("TABLE_NAME");
            	count ++;
            }
		  	System.out.println("Database opened successfully!\n");
        } 
            catch (SQLException e) {
            e.printStackTrace();
        }	
	  
	  return names;
}
 	 
public static String dbCon(String url, String query, String table){  
		String data = "";
		Statement stmt = null;
		Connection con = null;	    
		
	    try {
	        Class.forName("org.sqlite.JDBC");
	  
	    } catch(Exception e) {
	      System.err.print("ClassNotFoundException: "); 
	      System.err.println(e.getMessage());
	    }

	    try {
	      con = DriverManager.getConnection(url, "myLogin", "myPassword");
	  
	      stmt = con.createStatement();              
	  
	      ResultSet rs = stmt.executeQuery(query);
	      ResultSetMetaData rsmd = rs.getMetaData();
	  
	      PrintColumnTypes.printColTypes(rsmd);
	      data += "\r";
	  
	      int numberOfColumns = rsmd.getColumnCount();

	      data += "Database: " + url;
	      data += "\r\nTable Name: " + table;
	      data += "\r\nQuery: " + query;
	      data += "\r\n\r\nColumns:\r\n";
	      
	      for (int i = 1; i <= numberOfColumns; i++) {
	        if (i > 1) data+="  ";
	        String columnName = rsmd.getColumnName(i);
	        data += String.format("| %-15s ",columnName);
	      }
	      
	      data += "\r\n\r\nData\r\n";

	      while (rs.next()) {
	        for (int i = 1; i <= numberOfColumns; i++) {
	          if (i > 1) data+="  ";
	          String columnValue = rs.getString(i);
	          data += String.format("| %-15s ",columnValue);
	        }
	        data += "\r\n"; 
	      }
	  
	      stmt.close();
	      con.close();
	    } catch(SQLException ex) {
	      System.err.print("SQLException: ");
	      System.err.println(ex.getMessage());
	    }
	    return data;
	}
}

class PrintColumnTypes  {

	public static void printColTypes(ResultSetMetaData rsmd) throws SQLException {
		int columns = rsmd.getColumnCount();
		for (int i = 1; i <= columns; i++) {
			@SuppressWarnings("unused")
			int jdbcType = rsmd.getColumnType(i);
		    @SuppressWarnings("unused")
			String name = rsmd.getColumnTypeName(i);
		}
	}
}