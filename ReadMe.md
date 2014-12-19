#AndroidForensicScanner
###Version:
1.0

###System Overview:

###Copyright information:
AndroidForensicScanner is copyrighted by Jordan Rauscher and Tyler Filkins (2014).<br/>

###License information:
The AndroidForensicScanner documentation is licensed under CC BY-SA 3.0 US (https://creativecommons.org/licenses/by-sa/3.0/us/)<br/>
The source code of AndroidForensicScanner is licensed under Apache 2.0 (http://www.apache.org/licenses/LICENSE-2.0)<br/>

-----------------------------------------------------------------------

###Installation information:
####Pre-installation:
1. Java JDK must be installed.<br/>
Link: http://www.oracle.com/technetwork/articles/javase/index-jsp-138363.html <br/>
2. Allow for the execution of power-shell scripts.<br/>
Run power-shell as administrator and run: Set-ExecutionPolicy Unrestricted<br/>
Then hit "Y" for yes.<br/>
3. Android device must be rooted.<br/>
		
#### Use:
1. Plug in Android device via USB.<br/>
2. Set device to USB debug mode. <br/>
3. Run Device_File_Puller.bat<br/>
This will grab all the files off of the device and save them to: phoneData\"Directory Provided"\ <br/>
4. Run Get_Main_Files.ps1<br/>
This will move all the target files (in targets.csv) to the 5. Run Analyse_Data.bat<br/>
This will export all of the database information to text files. Along with searching for keywords in the files. <br/>Location: output\"Directory Provided"\
<br/>
-----------------------------------------------------------------------

###Code contribution management:
Source code changes are committed to the GitHub repository at https://github.com/jrauscher/AndroidForensicScanner<br/>
Users may submit bugs/issues to the GitHub issue tracker at https://github.com/jrauscher/AndroidForensicScanner/issues<br/>

###Communication:
GitHub: https://github.com/jrauscher/AndroidForensicScanner<br/>

-----------------------------------------------------------------------

###Technical Specification:
#### Software:
Operating system: Windows <br/>