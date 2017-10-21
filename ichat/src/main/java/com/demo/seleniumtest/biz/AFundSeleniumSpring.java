package com.demo.seleniumtest.biz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.services.IFundRateRptService;
import com.services.IFundRateService;
import com.services.IFundService;
import com.services.pojo.fund.Fund;
import com.services.pojo.fund.FundRateRpt;

public abstract class AFundSeleniumSpring implements IFundSelenium {

	private String browserName;
	private boolean isVisiable;// browser is visable or not

	public boolean isVisiable() {
		return isVisiable;
	}

	public void setVisiable(boolean isVisiable) {
		this.isVisiable = isVisiable;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	// Sub class to set its webdriver as the browser
	WebDriver driver;

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void insertFundRateRpt() {
		// TODO Auto-generated method stub
		
	}
	// @Override
	// public void insertFundRateRpt() {
	// try {
	// int thCount = 0;
	//// int xpathRow = 7;
	//// String quartileRanking = "\u56db\u5206\u4f4d\u6392\u540d"; // 四分位排名
	//// String theSixthValue = "";
	// List<Fund> flist = fundService.queryFundList();
	// Iterator<Fund> fit = flist.iterator();
	// Fund fund = null;
	// // get the rate
	// FundRateRpt frRpt = new FundRateRpt();
	// String sFundAmt;
	// float fundAmt;
	// String lst1wRate;
	// String lst1mRate;
	// String lst3mRate;
	// String lst6mRate;
	// String curyearRate;
	// String lst1yRate;
	// String lst2yRate;
	// String lst3yRate;
	// String lst5yRate;
	// String sinceFoundRate;
	// // percentage
	// String lst1wPct;
	// String lst1mPct;
	// String lst3mPct;
	// String lst6mPct;
	// String curyearPct;
	// String lst1yPct;
	// String lst2yPct;
	// String lst3yPct;
	// String lst5yPct;
	// String sinceFoundPct;
	// Date lstUpdDate;
	//
	// //int fm = flist.size();
	//
	// System.out.println("Start fetch each fund");
	//
	// while (fit.hasNext()) {
	// fund = (Fund) fit.next();
	// System.out.println(fund.getFundCode()+","+fund.getFundName()+","+fund.getFundUrl());
	// driver.get(fund.getFundUrl());
	//
	// try {
	// sFundAmt = driver.findElement(By.xpath("//label[5]/span")).getText();
	// sFundAmt = sFundAmt.substring(0, sFundAmt.indexOf("元") +
	// 1).replace(",","");
	//
	// if (sFundAmt.equals("") || sFundAmt.indexOf(".") < 1) {
	// fundAmt = 0;
	// } else {
	// fundAmt = Float.parseFloat(sFundAmt.substring(0, sFundAmt.indexOf("元") -
	// 1));
	// }
	// curyearRate =
	// driver.findElement(By.xpath("//div/ul[2]/li[7]")).getText();
	// //Debug
	// //System.out.print("资产规模：" + sFundAmt);
	// //System.out.println(",float 资产规模：" + fundAmt);
	// //System.out.println("curyearRate is " + curyearRate);
	//
	// lst1wRate = driver.findElement(By.xpath("//div/ul[3]/li[7]")).getText();
	// //System.out.println("lst1wRate is " + lst1wRate);
	// lst1mRate = driver.findElement(By.xpath("//div/ul[4]/li[7]")).getText();
	// //System.out.println("lst1mRate is " + lst1mRate);
	// lst3mRate = driver.findElement(By.xpath("//div/ul[5]/li[7]")).getText();
	// //System.out.println("lst3mRate is " + lst3mRate);
	// lst6mRate = driver.findElement(By.xpath("//div/ul[6]/li[7]")).getText();
	// //System.out.println("lst6mRate is " + lst6mRate);
	//
	// lst1yRate = driver.findElement(By.xpath("//div/ul[7]/li[7]")).getText();
	// //System.out.println("lst1yRate is " + lst1yRate);
	// lst2yRate = driver.findElement(By.xpath("//div/ul[8]/li[7]")).getText();
	// //System.out.println("lst2yRate is " + lst2yRate);
	// lst3yRate = driver.findElement(By.xpath("//div/ul[9]/li[7]")).getText();
	// //System.out.println("lst3yRate is " + lst3yRate);
	// lst5yRate = driver.findElement(By.xpath("//div/ul[10]/li[7]")).getText();
	// //System.out.println("lst5yRate is " + lst5yRate);
	// sinceFoundRate =
	// driver.findElement(By.xpath("//div/ul[11]/li[7]")).getText();
	// //System.out.println("sinceFoundRate is " + sinceFoundRate);
	// // percentage
	// curyearPct = driver.findElement(By.xpath("//div/ul[2]/li[2]")).getText();
	// //System.out.println("curyearPct is " + curyearPct);
	// lst1wPct = driver.findElement(By.xpath("//div/ul[3]/li[2]")).getText();
	// //System.out.println("lst1wPct is " + lst1wPct);
	// lst1mPct = driver.findElement(By.xpath("//div/ul[4]/li[2]")).getText();
	// //System.out.println("lst1mPct is " + lst1mPct);
	// lst3mPct = driver.findElement(By.xpath("//div/ul[5]/li[2]")).getText();
	// //System.out.println("lst3mPct is " + lst3mPct);
	// lst6mPct = driver.findElement(By.xpath("//div/ul[6]/li[2]")).getText();
	// //System.out.println("lst6mPct is " + lst6mPct);
	// lst1yPct = driver.findElement(By.xpath("//div/ul[7]/li[2]")).getText();
	// //System.out.println("lst1yPct is " + lst1yPct);
	// lst2yPct = driver.findElement(By.xpath("//div/ul[8]/li[2]")).getText();
	// //System.out.println("lst2yPct is " + lst2yPct);
	// lst3yPct = driver.findElement(By.xpath("//div/ul[9]/li[2]")).getText();
	// //System.out.println("lst3yPct is " + lst3yPct);
	// lst5yPct = driver.findElement(By.xpath("//div/ul[10]/li[2]")).getText();
	// //System.out.println("lst5yPct is " + lst5yPct);
	// sinceFoundPct =
	// driver.findElement(By.xpath("//div/ul[11]/li[2]")).getText();
	// //System.out.println("sinceFoundPct is " + sinceFoundPct);
	//
	// String lstUpdDateStr =
	// driver.findElement(By.xpath("//div/div[3]/font[1]")).getText();
	// if (lst1wRate.trim().equals("---") || lstUpdDateStr.trim().equals("")) {
	// //System.out.println("lstUpdDateStr is " + lstUpdDateStr + " ,continue");
	// continue;
	// }
	// try {
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// lstUpdDate = sdf.parse(lstUpdDateStr.substring(6));
	// //System.out.println("sinceFoundPct is " + lstUpdDateStr);
	// frRpt.setLstUpdDate(lstUpdDate);
	// } catch (ParseException ex) {
	// System.out.println("data parse error. " + ex.getMessage());
	// continue;
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// Thread.sleep(2000);
	// continue;
	// }
	//
	// frRpt.setFundCode(fund.getFundCode());
	// frRpt.setsFundAmt(sFundAmt);
	// frRpt.setFundAmt(fundAmt);
	// frRpt.setLst1wRate(lst1wRate);
	// frRpt.setLst1mRate(lst1mRate);
	// frRpt.setLst3mRate(lst3mRate);
	// frRpt.setLst6mRate(lst6mRate);
	// frRpt.setCuryearRate(curyearRate);
	// frRpt.setLst1yRate(lst1yRate);
	// frRpt.setLst2yRate(lst2yRate);
	// frRpt.setLst3yRate(lst3yRate);
	// frRpt.setLst5yRate(lst5yRate);
	// frRpt.setSinceFoundRate(sinceFoundRate);
	// // percentage
	// frRpt.setLst1wPct(lst1wPct);
	// frRpt.setLst1mPct(lst1mPct);
	// frRpt.setLst3mPct(lst3mPct);
	// frRpt.setLst6mPct(lst6mPct);
	// frRpt.setCuryearPct(curyearPct);
	// frRpt.setLst1yPct(lst1yPct);
	// frRpt.setLst2yPct(lst2yPct);
	// frRpt.setLst3yPct(lst3yPct);
	// frRpt.setLst5yPct(lst5yPct);
	// frRpt.setSinceFoundPct(sinceFoundPct);
	// // start a new thread
	// thCount++;
	// // insertFundRateRpt(frRpt);
	// fundRateRptService.insertFundRateRptThread(frRpt);
	// // once thread count growth every 20, sleep 3 seconds
	// if ((thCount % 20) == 0) {
	// try {
	// System.out.println("growth every 20, sleep 3 seconds ......");
	// Thread.sleep(5000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// // xpathRow = 6;
	// if (thCount >= 5) break; // for debug
	// }
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// } finally {
	// // close driver
	// driver.quit();
	// }
	// }

	public void insertFundRateRpt(String sCycleDate) {
		Fund fund = null;
		try {
			int thCount = 0;
			List<Fund> flist = fundService.queryFundList(sCycleDate);
			Iterator<Fund> fit = flist.iterator();
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
			String lstUpdDateStr;
			System.out.println("Start fetch each fund");
			while (fit.hasNext()) {
				fund = (Fund) fit.next();
				driver.get(fund.getFundUrl());
				try {
					sFundAmt = driver.findElement(By.xpath("//label[5]/span")).getText();
					sFundAmt = sFundAmt.substring(0, sFundAmt.indexOf("元") + 1).replace(",", "").trim();
					//System.out.println("资产规模：" + sFundAmt);
					if (sFundAmt.equals("") || sFundAmt.indexOf(".") < 1) {
						fundAmt = 0;
					} else {
						fundAmt = Float.parseFloat(sFundAmt.substring(0, sFundAmt.indexOf("元") - 1));
					}
					curyearRate = driver.findElement(By.xpath("//div/ul[2]/li[7]")).getText();
					
					lst1wRate = driver.findElement(By.xpath("//div/ul[3]/li[7]")).getText();
					// System.out.println("lst1wRate is " + lst1wRate);
					lst1mRate = driver.findElement(By.xpath("//div/ul[4]/li[7]")).getText();
					// System.out.println("lst1mRate is " + lst1mRate);
					lst3mRate = driver.findElement(By.xpath("//div/ul[5]/li[7]")).getText();
					// System.out.println("lst3mRate is " + lst3mRate);
					lst6mRate = driver.findElement(By.xpath("//div/ul[6]/li[7]")).getText();
					// System.out.println("lst6mRate is " + lst6mRate);

					lst1yRate = driver.findElement(By.xpath("//div/ul[7]/li[7]")).getText();
					// System.out.println("lst1yRate is " + lst1yRate);
					lst2yRate = driver.findElement(By.xpath("//div/ul[8]/li[7]")).getText();
					// System.out.println("lst2yRate is " + lst2yRate);
					lst3yRate = driver.findElement(By.xpath("//div/ul[9]/li[7]")).getText();
					// System.out.println("lst3yRate is " + lst3yRate);
					lst5yRate = driver.findElement(By.xpath("//div/ul[10]/li[7]")).getText();
					// System.out.println("lst5yRate is " + lst5yRate);
					sinceFoundRate = driver.findElement(By.xpath("//div/ul[11]/li[7]")).getText();
					// System.out.println("sinceFoundRate is " +
					// sinceFoundRate);
					// percentage
					curyearPct = driver.findElement(By.xpath("//div/ul[2]/li[2]")).getText();
					// System.out.println("curyearPct is " + curyearPct);
					lst1wPct = driver.findElement(By.xpath("//div/ul[3]/li[2]")).getText();
					// System.out.println("lst1wPct is " + lst1wPct);
					lst1mPct = driver.findElement(By.xpath("//div/ul[4]/li[2]")).getText();
					// System.out.println("lst1mPct is " + lst1mPct);
					lst3mPct = driver.findElement(By.xpath("//div/ul[5]/li[2]")).getText();
					// System.out.println("lst3mPct is " + lst3mPct);
					lst6mPct = driver.findElement(By.xpath("//div/ul[6]/li[2]")).getText();
					// System.out.println("lst6mPct is " + lst6mPct);
					lst1yPct = driver.findElement(By.xpath("//div/ul[7]/li[2]")).getText();
					// System.out.println("lst1yPct is " + lst1yPct);
					lst2yPct = driver.findElement(By.xpath("//div/ul[8]/li[2]")).getText();
					// System.out.println("lst2yPct is " + lst2yPct);
					lst3yPct = driver.findElement(By.xpath("//div/ul[9]/li[2]")).getText();
					// System.out.println("lst3yPct is " + lst3yPct);
					lst5yPct = driver.findElement(By.xpath("//div/ul[10]/li[2]")).getText();
					// System.out.println("lst5yPct is " + lst5yPct);
					sinceFoundPct = driver.findElement(By.xpath("//div/ul[11]/li[2]")).getText();
					// System.out.println("sinceFoundPct is " + sinceFoundPct);

					lstUpdDateStr = driver.findElement(By.xpath("//div/div[3]/font[1]")).getText().trim();
					//index start with 0
					if (lstUpdDateStr.length()>6) {
						try {							
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							lstUpdDate = sdf.parse(lstUpdDateStr.substring(6));						
							frRpt.setLstUpdDate(lstUpdDate);
						} catch (ParseException ex) {
							throw ex;
						}
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
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
//					if (thCount >= 5) break; // for debug
				} catch (Exception e) {
					System.out.println(fund.getFundCode() + "," + fund.getFundName() + "," + fund.getFundUrl());
					e.printStackTrace();
					continue;
				}
			}
		} catch (Exception ex) {
			System.out.println(fund.getFundCode() + "," + fund.getFundName() + "," + fund.getFundUrl());
			ex.printStackTrace();
		} finally {
			// close driver
			driver.quit();
		}
	}

	// injection
	IFundService fundService;
	IFundRateService fundRateService;
	IFundRateRptService fundRateRptService;

	public void setFundService(IFundService fundService) {
		this.fundService = fundService;
	}

	public void setfundRateService(IFundRateService fundRateService) {
		this.fundRateService = fundRateService;
	}

	public void setFundRateRptService(IFundRateRptService fundRateRptService) {
		this.fundRateRptService = fundRateRptService;
	}
}