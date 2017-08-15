package com.demo.seleniumtest.biz;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;



//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//public class HtmlUnitSelenium extends AFundSelenium  {
public class HtmlUnitDemo {
	
//	HtmlUnitSelenium(){
//		this.setBrowserName("HtmlUnit");
//		super.setDriver(new HtmlUnitDriver());
//		//without injection,need call initial function
//		initial();
//	}
	
	public static void main(String[] args){
		HtmlUnitDemo hu=new HtmlUnitDemo();
		try {
			hu.homepage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void homepage() throws Exception{
		try(final WebClient webClient=new WebClient()){
			webClient.getOptions().setJavaScriptEnabled(false); //com.gargoylesoftware.htmlunit.ScriptException: Exception invoking getOffsetHeight
			webClient.getOptions().setCssEnabled(false);
			
			System.out.println("create webclient successfully!");	
			HtmlPage page=webClient.getPage("http://fund.eastmoney.com/f10/jdzf_000041.html");
			System.out.println(page.getTitleText());
			
//			junit.framework.TestCase.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());
			///html/body/div[1]/div[8]/div[3]/div[1]/div[2]/p/label[5]/span
			HtmlSpan sp =(HtmlSpan) page.getByXPath("//label[5]/span").get(0);
			String  inputs =  sp.asText();
			System.out.println(inputs);	
			float fundAmt;
			inputs=inputs.substring(0, inputs.indexOf("元")-1);
			System.out.println(inputs);	
			
			page=webClient.getPage("http://fund.eastmoney.com/f10/jdzf_000042.html");
			System.out.println(page.getTitleText());
			sp =(HtmlSpan) page.getByXPath("//label[5]/span").get(0);
			inputs =  sp.asText();
			System.out.println(inputs);	
			
			HtmlListItem li=(HtmlListItem) page.getByXPath("//div/ul[2]/li[7]").get(0);
			 inputs =  li.asText();
			System.out.println("Li value " +inputs);	
			

			webClient.close();
			


		}
	}
}