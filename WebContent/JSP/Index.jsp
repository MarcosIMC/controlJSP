<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	String base = (String)application.getAttribute("base");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Control Marcos</title>
</head>
<body>
	<a href="<%= base %>?peticion=ejercicio1">Ejercicio 1</button>
	<a href="<%= base %>?peticion=ejercicio2">Ejercicio 2</button>
</body>
</html>