package com.demo.seleniumtest.biz;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class HtmlUnitSeleniumTest {
	static HtmlUnitSelenium hu;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hu=new HtmlUnitSelenium();
	}

	@Test
	public void test() {
		try {
			//assertEquals("HtmlUnit", hu.homepage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
