package com.demo.seleniumtest.biz;

public class FundSeleniumFactory {
	//单例模式
	private static IFundSelenium fundSelenium;
	private final static String FIREFOX_BROWSER_NAME="FIREFOX";
	private final static String IE_BROWSER_NAME="IE";
	private final static String CHROME_BROWSER_NAME="CHROME";
	//define a private constructor function
	private FundSeleniumFactory(){}
	//define a public static function,and return a instance	
	public static IFundSelenium getInstance(String clsName){
		if(fundSelenium==null){
			synchronized(IFundSelenium.class){
				if(fundSelenium==null){
					switch (clsName.toUpperCase()){
					case FIREFOX_BROWSER_NAME: 
						return (new FireFoxSelenium());			
					case IE_BROWSER_NAME:
						return (new IexplorerSelenium());
					case CHROME_BROWSER_NAME:
						return (new ChromeSelenium());
					default:
						new Exception("Browser name is not existing! or incorrect");
					}
				}
			}
		}
		return fundSelenium;
	}

}
