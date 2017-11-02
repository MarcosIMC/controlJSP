<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ejercicio 1</title>
</head>
<body>
	<p>Lista de enlaces a diferentes Webs</p>
	
	<ol>
	
		<%
			String[] direcciones = (String[]) request.getAttribute("links");
		
			for(int i = 0; i < direcciones.length; i++){
				%>
				
				<li href=<%= direcciones[i] %>><%= direcciones[i] %></li>
			<%	
			}
		%>
	
	</ol>
</body>
</html>