package com.acent;

import org.junit.Test;

import junit.framework.TestCase;

public class LoginActionTest extends TestCase {
	LoginAction la;

	@Override
	public void setUp() throws Exception {
		la=new LoginAction();
	}

	@Test
	public void testGetUserName() {
		la.setUserName("kevin");
		assertEquals("kevin",la.getUserName());
	}

	@Test
	public void testSetUserName() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPassword() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetPassword() {
		//fail("Not yet implemented");
	}

	@Test
	public void testExecute() throws Exception {
		la.setUserName("kevin");
		assertEquals("SUCCESS",la.execute());
	}

}
