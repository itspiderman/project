package com.acent;

//This is struts2 demo
public class LoginAction {
	String userName;
	String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		if (userName.equals("kv")) {
			return "WELCOME";
		} else {
			return "SUCCESS";
		}
	}

}
