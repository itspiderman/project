package com.demo;
// Testing url 
// http://localhost:8080/demo/calculate.jsp
public class Calculator {
	double first;
	String operater;
	double second;
	double result;
	public double getFirst() {
		return first;
	}
	public void setFirst(double first) {
		this.first = first;
	}
	public String getOperater() {
		return operater;
	}
	public void setOperater(String operater) {
		this.operater = operater;
	}
	public double getSecond() {
		return second;
	}
	public void setSecond(double second) {
		this.second = second;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public double calculate(){
		
		System.out.println(operater);
		
		if(operater.equals("add"))
			result=first+second;
		else if(operater.equals("subs"))
			result=first-second;
		else if(operater.equals("mul"))
			result=first*second;
		else
			result=first/second;
		return result;
	}

}
