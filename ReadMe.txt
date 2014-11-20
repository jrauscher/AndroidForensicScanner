
Dependencies:
	1. Java JDK must be installed.
		Link: http://www.oracle.com/technetwork/articles/javase/index-jsp-138363.html

	2. Allow for the execution of power-shell scripts. 
		Run power-shell as administrator and run: Set-ExecutionPolicy Unrestricted
		Then hit "Y" for yes.
	3. Android device must be rooted.
		
Use:
	Step 1: Plug in Android device via USB.
	Step 2: Set device to USB debug mode. 
	Step 3: Run Device_File_Puller.bat
		This will grab all the files off of the device and save them to: phoneData\"Directory Provided"\
	Step 4: Run Get_Main_Files.ps1
			This will move all the target files (in targets.csv) to the database directory.
	Step 5: Run Analyse_Data.bat
			This will export all of the database information to text files. Along with
			searching for keywords in the files.
			Location: output\"Directory Provided"\

Keywords:
	Keywords can be added to the keywords.txt file in order to find additional words.
	The total number of words in the file needs to be provided at the top of the file.	

Targets:
	Targets can be added to the targets.csv file in order to add additional databases to the 
	analyse program. 


Interesting Files:
	~\output\YOURDEVICENAME\browser\searches.txt
	~\output\YOURDEVICENAME\contacts2\contacts.txt
	~\output\YOURDEVICENAME\EmailProvider\HostAuth.txt
	~\output\YOURDEVICENAME\EmailProvider\Message.txt
	~\output\YOURDEVICENAME\EmailProviderBody\Body.txt
	~\output\YOURDEVICENAME\CachedGeoposition\CachedGeoposition.txt
	~\output\YOURDEVICENAME\fb\mailbox_messages.txt
	~\output\YOURDEVICENAME\fb\friends_data.txt
	~\output\YOURDEVICENAME\fb\mailbox_messages.txt
	~\output\YOURDEVICENAME\item_cache\event.txt
	~\output\YOURDEVICENAME\mmssms\sms.txt
	~\output\YOURDEVICENAME\mmssms\threads.txt