package com.smeshop.demo;

import java.util.Iterator;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class HtmlUnitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HtmlUnitFundSearch();
		// HtmlUnitBaiduAdvanceSearch();

	}

	public static void HtmlUnitBaiduAdvanceSearch() {
		try {
			// 得到浏览器对象，直接New一个就能得到，现在就好比说你得到了一个浏览器了
			WebClient webclient = new WebClient();

			// 这里是配置一下不加载css和javaScript,配置起来很简单，是不是
			webclient.getOptions().setCssEnabled(false);
			webclient.getOptions().setJavaScriptEnabled(false);

			// 做的第一件事，去拿到这个网页，只需要调用getPage这个方法即可
			HtmlPage htmlpage = webclient.getPage("http://news.baidu.com/advanced_news.html");

			// 根据名字得到一个表单，查看上面这个网页的源代码可以发现表单的名字叫“f”
			final HtmlForm form = htmlpage.getFormByName("f");
			System.out.println(form);
			// 同样道理，获取”百度一下“这个按钮
			final HtmlSubmitInput button = form.getInputByValue("百度一下");
			System.out.println(button);
			// 得到搜索框
			final HtmlTextInput textField = form.getInputByName("q1");

			System.out.println(textField);

			// 最近周星驰比较火呀，我这里设置一下在搜索框内填入”周星驰“
			textField.setValueAttribute("周星驰");
			// 输入好了，我们点一下这个按钮
			final HtmlPage nextPage = button.click();
			// 我把结果转成String
			System.out.println(nextPage);

			String result = nextPage.asXml();
			System.out.println(result);

			HtmlDivision div = (HtmlDivision) htmlpage.getByXPath("//div").get(0);
			// System.out.println(" div.getTextContent()");
			// System.out.println(div.getTextContent());
			System.out.println(" div.asText()");
			System.out.println(div.asText());

			webclient.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void HtmlUnitFundSearch() {
		try {
			// 得到浏览器对象，直接New一个就能得到，现在就好比说你得到了一个浏览器了
//			WebClient webclient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
			WebClient webclient = new WebClient();
			// 这里是配置一下不加载css和javaScript,配置起来很简单，是不是
			webclient.getOptions().setCssEnabled(false);
			webclient.getOptions().setJavaScriptEnabled(false);
			// 做的第一件事，去拿到这个网页，只需要调用getPage这个方法即可
			HtmlPage htmlpage = webclient.getPage("http://fund.eastmoney.com/f10/jdzf_710301.html");

			String result = htmlpage.asXml();
			System.out.println(result);
			Thread.sleep(100);
			// 资产规模：/html/body/div[1]/div[8]/div[3]/div[1]/div[2]/p/label[5]/span
			DomNodeList<DomNode> list = htmlpage.querySelectorAll(".bs_gl").get(0).querySelectorAll("span");
			
			int j=1;
			System.out.println("=================== "+list.size() +" ==============================");
			for(DomNode i: list){
				//DomNode P = i.querySelector("label");
				System.out.print(j);
				System.out.println(" " + i.asText());
				
				j++;
			}
			System.out.print("========================= * End * ==========================");

			//阶段涨幅明细:
			// (List)htmlpage.getByXPath("/html/body/div[1]/div[8]/div[3]/div[2]/div[3]/div/div/div[4]/div/div[2]/div/ul[2]/li[7]/p");
			
			List listRate = (List) htmlpage	.getByXPath("html/body/div[1]/div[8]/div[3]/div[2]/div[3]/div/div/div[4]/div/div[2]/div");
			if (null != listRate) {
				System.out.println(listRate.size());
				HtmlDivision div = (HtmlDivision) listRate.get(0);
				System.out.println(div.asXml());
			}

			webclient.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private static Object elementList(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
