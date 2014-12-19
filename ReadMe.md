#AndroidForensicScanner
###Version:
1.0

###System Overview:
The Android Forensics project is a Windows-based application that will copy all of the data on your Android mobile device, to your system. Then the application will scan that information and return any data that it believes should be reviewed further. The scan provides information on call history, browser history, text messages, emails and much more. The motive behind creating this application is due to the rapid advancements in mobile device technology - particularly with how much data is now stored within them. The amount of information stored on a person’s phone is immense and manually parsing through all of that data is simply too inefficient for effective, thorough forensic analysis.

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
This will move all the target files (in targets.csv) to the database directory.<br/>
5. Run Analyse_Data.bat<br/>
This will export all of the database information to text files. Along with searching for keywords in the files. <br/>Location: output\"Directory Provided"\
<br/>

#### Keywords:
Keywords can be added to the keywords.txt file in order to find additional words.The total number of words in the file needs to be provided at the top of the file.	

#### Targets:
Targets can be added to the targets.csv file in order to add additional databases to the analyse program. 

#### Interesting Files:
~\output\YOURDEVICENAME\browser\searches.txt<br/>
~\output\YOURDEVICENAME\contacts2\contacts.txt<br/>
~\output\YOURDEVICENAME\EmailProvider\HostAuth.txt<br/>
~\output\YOURDEVICENAME\EmailProvider\Message.txt<br/>
~\output\YOURDEVICENAME\EmailProviderBody\Body.txt<br/>
~\output\YOURDEVICENAME\CachedGeoposition\CachedGeoposition.txt<br/>
~\output\YOURDEVICENAME\fb\mailbox_messages.txt<br/>
~\output\YOURDEVICENAME\fb\friends_data.txt<br/>
~\output\YOURDEVICENAME\fb\mailbox_messages.txt<br/>
~\output\YOURDEVICENAME\item_cache\event.txt<br/>
~\output\YOURDEVICENAME\mmssms\sms.txt<br/>
~\output\YOURDEVICENAME\mmssms\threads.txt<br/>

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