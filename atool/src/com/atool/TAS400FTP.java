package com.atool.as400t;

import java.io.File;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400FTP;
//C:\Program Files (x86)\IBM\Client Access\jt400\lib\jt400.jar
public class TAS400FTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String systemString = "AS400MachineName";
		String userID = "AS400ID";
		String passWrd = "AS400PWD";
		
		String srcFtpPath="";
		String desLocalPath="";
		String[] sdir = null;
		
		try {
			
			//AS400
			AS400 as400 = new AS400(systemString, userID, passWrd);
			as400.connectService(AS400.PRINT);			
			AS400FTP ftp= new AS400FTP(as400);			
			
			String cdir = ftp.getCurrentDirectory();
			System.out.println(cdir);

			srcFtpPath = "/QSYS.LIB/MYLIB.LIB/A10646.FILE";   // A10646.FILE is Source file
			desLocalPath = "C:\\AS400src\\A10646";
			
			sdir = new String[] {"ABCDCLP.MBR","ABCPF.FILE"};  //WRKLNK to check the file extension
			ftp.setCurrentDirectory(srcFtpPath);
			for(String fileName: sdir) {
				ftp.get(fileName,desLocalPath + File.separator+fileName);	
				System.out.println(fileName);		
			}
			sdir = null;
			
			System.out.println("FTP job end");			
			as400.disconnectService(AS400.PRINT);			
			System.exit(0);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.exit(-1);
		}
	}

}
