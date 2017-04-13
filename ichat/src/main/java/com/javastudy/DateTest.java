package com.javastudy;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date date=new java.util.Date();
		System.out.println(date);
		System.out.println("----- sql date time -----");
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		System.out.println(sqlDate);
		java.sql.Time sqlTime=new java.sql.Time(date.getTime());
		System.out.println(sqlTime);
		java.sql.Timestamp sqlTimestamp=new java.sql.Timestamp(date.getTime());
		System.out.println(sqlTimestamp);
	}

}
