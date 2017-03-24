package com.demo.seleniumtest.biz;

public class FundSeleniumFactory {
	
	private static IFundSelenium fundSelenium;
	private final static String FIREFOX_BROWSER_NAME="FIREFOX";
	private final static String IE_BROWSER_NAME="IE";
	private final static String CHROME_BROWSER_NAME="CHROME";
	
	public static IFundSelenium createFundSelenium(String clsName) throws Exception{
		
		switch (clsName.toUpperCase()){
		case FIREFOX_BROWSER_NAME: 
			return (new FireFoxFundSelenium());			
		case IE_BROWSER_NAME:
			return (new IexplorerFundSelenium());
		case CHROME_BROWSER_NAME:
			return (new ChromeFundSelenium());
		default:
			new Exception("Browser name is not existing! or incorrect");
		}		
		return fundSelenium;
	}
	
	

}
