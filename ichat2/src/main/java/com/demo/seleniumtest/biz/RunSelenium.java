package com.demo.seleniumtest.biz;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class RunSelenium {

	WebDriver driver;

	public RunSelenium() {
		//System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.firefox.marionette", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
		this.driver = new FirefoxDriver();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunSelenium rs = new RunSelenium();

		//rs.testJS(rs.driver);		
		//rs.testBrowser(rs.driver);
		//
		rs.testHtmlUnit();

	}

	void testJS(WebDriver driver) {
		System.out.println("runing testJS();");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("alert('hello world')");
	}

	void testBrowser(WebDriver driver) {
		// 让浏览器访问 Baidu
		driver.get("http://www.baidu.com");
		// 用下面代码也可以实现
		// driver.navigate().to("http://www.baidu.com");
		// 获取 网页的 title
		System.out.println("1 Page title is: " + driver.getTitle());
		// 通过 id 找到 input 的 DOM
		WebElement element = driver.findElement(By.id("kw"));
		// 输入关键字
		element.sendKeys("zTree");
		// 提交 input 所在的 form
		element.submit();
		// 通过判断 title 内容等待搜索页面加载完毕，间隔10秒
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 显示搜索结果页面的 title
		System.out.println("2 Page title is: " + driver.getTitle());
		// 关闭浏览器
		driver.quit();
	}

	void testHtmlUnit(){
		System.out.println("-----------Testing for HtmlUnit-----------------------");
		WebDriver webdriver=new HtmlUnitDriver();
		webdriver.get("http://www.baidu.com");			
		System.out.println("页面标题："+webdriver.getTitle());  
        //根据id获取页面元素输入框  
        WebElement element=webdriver.findElement(By.id("kw"));  
        //在id=“kw”的输入框输入“selenium”  
        element.sendKeys("zTree");        
        element.submit();  
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        //打印当前页面标题  
        System.out.println("页面标题："+webdriver.getTitle());  
        //返回当前页面的url  
        System.out.println("页面url："+webdriver.getCurrentUrl());  
        //返回当前的浏览器的窗口句柄  
        System.out.println("窗口句柄："+webdriver.getWindowHandle());
        webdriver.get("http://fund.eastmoney.com/001781.html");	
        System.out.println("页面标题："+webdriver.getTitle());  
        webdriver.close();
	}
}
