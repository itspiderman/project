package com.demo.seleniumtest.biz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import com.services.pojo.fund.Fund;
import com.services.pojo.fund.FundRateRpt;

public class HtmlUnitSpring extends AFundSeleniumSpring {
	private WebClient webClient;
	private HtmlPage page ;//= webClient.getPage("http://fund.eastmoney.com/f10/jdzf_000041.html");

	public HtmlUnitSpring() {
		this.setBrowserName("HtmlUnit");
		// System.setProperty("webdriver.firefox.marionette", "C:\\Program
		// Files\\Mozilla Firefox\\geckodriver.exe");
		super.setDriver(new HtmlUnitDriver());
	}

	@Override
	public void insertFundRateRpt() {
		try {
			webClient = new WebClient();
			webClient.getOptions().setJavaScriptEnabled(false);
			webClient.getOptions().setCssEnabled(false);

			int thCount = 0;
			int xpathRow = 7;
			String quartileRanking = "\u56db\u5206\u4f4d\u6392\u540d"; // 四分位排名
			String theSixthValue = "";
			List<Fund> flist = fundService.queryFundList();
			Iterator<Fund> fit = flist.iterator();
			Fund fund = null;
			// get the rate
			FundRateRpt frRpt = new FundRateRpt();
			String sFundAmt;
			float fundAmt;
			String lst1wRate;
			String lst1mRate;
			String lst3mRate;
			String lst6mRate;
			String curyearRate;
			String lst1yRate;
			String lst2yRate;
			String lst3yRate;
			String lst5yRate;
			String sinceFoundRate;
			// percentage
			String lst1wPct;
			String lst1mPct;
			String lst3mPct;
			String lst6mPct;
			String curyearPct;
			String lst1yPct;
			String lst2yPct;
			String lst3yPct;
			String lst5yPct;
			String sinceFoundPct;
			Date lstUpdDate;

			// HtmlLi li=new HtmlLi();

			System.out.println("Start fetch each fund");

			while (fit.hasNext()) {
				fund = (Fund) fit.next();
				System.out.println("driver.get(fund.getFundUrl());");
				page.cleanUp();
				page = webClient.getPage(fund.getFundUrl());
				//
				sFundAmt = ((HtmlSpan) page.getByXPath("//label[5]/span").get(0)).asText();
				sFundAmt = sFundAmt.substring(0, sFundAmt.indexOf("元") + 1);
				System.out.print("资产规模：" + sFundAmt);
				if (sFundAmt.equals("") || sFundAmt.indexOf(".") < 1) {
					fundAmt = 0;
				} else {
					fundAmt = Float.parseFloat(sFundAmt.substring(0, sFundAmt.indexOf("元") - 1));
				}
				System.out.println(",float 资产规模：" + fundAmt);
				//
				lst1wRate = driver.findElement(By.xpath("//div/ul[2]/li[" + xpathRow + "]")).getText();
				System.out.println("lst1wRate is " + lst1wRate);
				lst1mRate = driver.findElement(By.xpath("//div/ul[3]/li[" + xpathRow + "]")).getText();
				System.out.println("lst1mRate is " + lst1mRate);
				lst3mRate = driver.findElement(By.xpath("//div/ul[4]/li[" + xpathRow + "]")).getText();
				System.out.println("lst3mRate is " + lst3mRate);
				lst6mRate = driver.findElement(By.xpath("//div/ul[5]/li[" + xpathRow + "]")).getText();
				System.out.println("lst6mRate is " + lst6mRate);
				curyearRate = driver.findElement(By.xpath("//div/ul[6]/li[" + xpathRow + "]")).getText();
				System.out.println("curyearRate is " + curyearRate);
				lst1yRate = driver.findElement(By.xpath("//div/ul[7]/li[" + xpathRow + "]")).getText();
				System.out.println("lst1yRate is " + lst1yRate);
				lst2yRate = driver.findElement(By.xpath("//div/ul[8]/li[" + xpathRow + "]")).getText();
				System.out.println("lst2yRate is " + lst2yRate);
				lst3yRate = driver.findElement(By.xpath("//div/ul[9]/li[" + xpathRow + "]")).getText();
				System.out.println("lst3yRate is " + lst3yRate);
				lst5yRate = driver.findElement(By.xpath("//div/ul[10]/li[" + xpathRow + "]")).getText();
				System.out.println("lst5yRate is " + lst5yRate);
				sinceFoundRate = driver.findElement(By.xpath("//div/ul[11]/li[" + xpathRow + "]")).getText();
				System.out.println("sinceFoundRate is " + sinceFoundRate);
				// percentage
				lst1wPct = driver.findElement(By.xpath("//div/ul[2]/li[2]")).getText();
				System.out.println("lst1wPct is " + lst1wPct);
				lst1mPct = driver.findElement(By.xpath("//div/ul[3]/li[2]")).getText();
				System.out.println("lst1mPct is " + lst1mPct);
				lst3mPct = driver.findElement(By.xpath("//div/ul[4]/li[2]")).getText();
				System.out.println("lst3mPct is " + lst3mPct);
				lst6mPct = driver.findElement(By.xpath("//div/ul[5]/li[2]")).getText();
				System.out.println("lst6mPct is " + lst6mPct);
				curyearPct = driver.findElement(By.xpath("//div/ul[6]/li[2]")).getText();
				System.out.println("curyearPct is " + curyearPct);
				lst1yPct = driver.findElement(By.xpath("//div/ul[7]/li[2]")).getText();
				System.out.println("lst1yPct is " + lst1yPct);
				lst2yPct = driver.findElement(By.xpath("//div/ul[8]/li[2]")).getText();
				System.out.println("lst2yPct is " + lst2yPct);
				lst3yPct = driver.findElement(By.xpath("//div/ul[9]/li[2]")).getText();
				System.out.println("lst3yPct is " + lst3yPct);
				lst5yPct = driver.findElement(By.xpath("//div/ul[10]/li[2]")).getText();
				System.out.println("lst5yPct is " + lst5yPct);
				sinceFoundPct = driver.findElement(By.xpath("//div/ul[11]/li[2]")).getText();
				System.out.println("sinceFoundPct is " + sinceFoundPct);

				String lstUpdDateStr = driver.findElement(By.xpath("//div/div[3]/font[1]")).getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					lstUpdDate = sdf.parse(lstUpdDateStr.substring(6));
					System.out.println("sinceFoundPct is " + lstUpdDateStr);
					frRpt.setLstUpdDate(lstUpdDate);
				} catch (ParseException ex) {
					System.out.println("data parse error. " + ex.getMessage());
					throw ex;
				}
				frRpt.setFundCode(fund.getFundCode());
				frRpt.setsFundAmt(sFundAmt);
				frRpt.setFundAmt(fundAmt);
				frRpt.setLst1wRate(lst1wRate);
				frRpt.setLst1mRate(lst1mRate);
				frRpt.setLst3mRate(lst3mRate);
				frRpt.setLst6mRate(lst6mRate);
				frRpt.setCuryearRate(curyearRate);
				frRpt.setLst1yRate(lst1yRate);
				frRpt.setLst2yRate(lst2yRate);
				frRpt.setLst3yRate(lst3yRate);
				frRpt.setLst5yRate(lst5yRate);
				frRpt.setSinceFoundRate(sinceFoundRate);
				// percentage
				frRpt.setLst1wPct(lst1wPct);
				frRpt.setLst1mPct(lst1mPct);
				frRpt.setLst3mPct(lst3mPct);
				frRpt.setLst6mPct(lst6mPct);
				frRpt.setCuryearPct(curyearPct);
				frRpt.setLst1yPct(lst1yPct);
				frRpt.setLst2yPct(lst2yPct);
				frRpt.setLst3yPct(lst3yPct);
				frRpt.setLst5yPct(lst5yPct);
				frRpt.setSinceFoundPct(sinceFoundPct);
				// start a new thread
				thCount++;
				// insertFundRateRpt(frRpt);
				fundRateRptService.insertFundRateRptThread(frRpt);
				// once thread count growth every 20, sleep 3 seconds
				if ((thCount % 20) == 0) {
					try {
						System.out.println("growth every 20, sleep 3 seconds ......");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				xpathRow = 6;
				if (thCount >= 5)
					break; // for debug

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			webClient.close();
		}

	} // end insert

}// end class
