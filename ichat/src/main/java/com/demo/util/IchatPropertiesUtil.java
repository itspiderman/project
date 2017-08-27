package com.demo.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IchatPropertiesUtil {
	private static Properties pps;
	private Properties loadProperties(){		
		if (pps==null){
			pps=new Properties();			
			try {
				//final File file=new File(this.getClass().getResource("ichat.properties").getPath());
				final File file=new File("ichat.properties");
				System.out.println("File path is "+file.getAbsolutePath());				
				final InputStream in=new BufferedInputStream(new FileInputStream(file));
				pps.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return pps;
	}
	
	public static String getProperty(String strKey ){		
		IchatPropertiesUtil pu=new IchatPropertiesUtil();		
		pps=pu.loadProperties();
		String strValue=pps.getProperty(strKey);
		return strValue;
	}
	public static void main(String args[]){		 
		System.out.println(getProperty("fundDataPath"));
	}
}
