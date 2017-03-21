<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="calculator" class="com.demo.Calculator" scope="request">
    <jsp:setProperty name="calculator" property="*" />
    </jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculate</title>
</head>
<body>
<h1>This is JavaBean Demo</h1>
<br/>
Result is :
<%
try{
	calculator.calculate();
	out.println(calculator.getFirst()+calculator.getOperater()+calculator.getSecond()+"="+calculator.getResult());
}catch(Exception ex){
	out.println(ex.getMessage());
}

%>

<form name="calculateForm" action="calculate.jsp" method="post">
First:<input type="text" name="first" value="2"/><br/>
Operater:<select name="operater">
<option value="add">+</option>
<option value="subs">-</option>
<option value="mul">*</option>
<option value="div">/</option>
</select>
Second:<input type="text" name="second" value="1"/><br/>
result:<input type="text" name="result"/><br/>
<input type="submit" value="Submit" />

</form>

</body>
</html>