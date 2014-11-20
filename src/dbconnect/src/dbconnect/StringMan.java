package dbconnect;

public class StringMan {

	public String[] breakApartString(String text, String space, int x){
		int End = 0;    	
	
		String[] sections = new String[x];
		
		for (int i = 0; i < x; i++){
			End = text.indexOf(space);
			
			if(End == 0){
				break;
			}

			sections[i] = text.substring(0,End);
			text = text.substring(End+1,text.length());
		}
		
		return sections;	
	}
	
	//Finds the Nth occurrence of a character in a string
	public int nthOccurrence(String str, char c, int n) {
	    int pos = str.indexOf(c, 0);
	    while (n-- > 0 && pos != -1)
	        pos = str.indexOf(c, pos+1);
	    return pos;
	}
	
	//Removes ".txt" from the end of a string
	public String removeTxt(String Input) {
		
		String Txt = Input.substring(Input.length()-3,Input.length());
		Txt = Txt.toLowerCase();

		if (Txt.equals("txt")){
			return Input.substring(0,Input.length()-4);
		}
		else{
			return Input;
		}
	}
	
	public String removeDb(String Input) {
		
		String db = Input.substring(Input.length()-2,Input.length());
		db = db.toLowerCase();

		if (db.equals("db")){
			return Input.substring(0,Input.length()-3);
		}
		else{
			return Input;
		}
	}
	
	public int addUpString(String items[], String delim){
		int length = items.length;
		int total = 0;
		
		for(int i = 0; i < length; i++){
			if(items[i] == null){
				break;
			}
			int end = items[i].indexOf(delim);
			String stringAmount = items[i].substring(0,end);
			total += Integer.parseInt(stringAmount);
		}
		return total;	
	}
	
	public String stackDoubles(String s, char Delimiter){
		String multi[] = new String[s.length()];
		String middle = "";
		String middle2 = "";
		String total = "";
		int duplicates = 0;
		int Flag = 0;
		int stringLength = s.length();
		
		for(int i=0; i < stringLength; i++){
			Flag = 0;
			int start = nthOccurrence(s,Delimiter,i);
			int end = nthOccurrence(s,Delimiter,i+1);
			
			if(end == stringLength+1 || end == -1){
				break;
			}
			
			middle = s.substring(start,end);
			
				for(int j = 0; j < stringLength; j++){
					int start2 = nthOccurrence(s,Delimiter,j);
					int end2 = nthOccurrence(s,Delimiter,j+1);
					
					if(end2 == s.length()+1 || end2 == -1){
						break;
					}
					
					middle2 = s.substring(start2,end2);
					
					if(middle.equalsIgnoreCase(middle2)){
						duplicates ++;
					}
					
				}
				
				if(duplicates > 0){
					multi[i] = middle;
					
					for(int k=0; k < i; k++){
						if(multi[k].equalsIgnoreCase(middle)){
							Flag = 1;
						}	
					}
					
					middle = middle + "  :  x " + duplicates;
					
					if (Flag == 0){
						total += middle;
					}
				}
				
				duplicates = 0;		
		}
		
		return total + Delimiter;
	}
	
	
	
	public String soundex(String s) { 
        char[] x = s.toUpperCase().toCharArray();
        char firstLetter = x[0];
        int xLength = x.length;
        
        // convert letters to numeric code
        for (int i = 0; i < xLength; i++) {
            switch (x[i]) {
                case 'B':
                case 'F':
                case 'P':
                case 'V': { x[i] = '1'; break; }

                case 'C':
                case 'G':
                case 'J':
                case 'K':
                case 'Q':
                case 'S':
                case 'X':
                case 'Z': { x[i] = '2'; break; }

                case 'D':
                case 'T': { x[i] = '3'; break; }

                case 'L': { x[i] = '4'; break; }

                case 'M':
                case 'N': { x[i] = '5'; break; }

                case 'R': { x[i] = '6'; break; }

                default:  { x[i] = '0'; break; }
            }
        }

        // remove duplicates
        String output = "" + firstLetter;
        for (int i = 1; i < xLength; i++)
            if (x[i] != x[i-1] && x[i] != '0')
                output += x[i];

        // pad with 0's or truncate
        output = output + "0000";
        return output.substring(0, 4);
    }
}
