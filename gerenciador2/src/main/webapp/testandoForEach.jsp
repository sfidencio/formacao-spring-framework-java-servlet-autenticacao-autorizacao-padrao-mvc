<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="java.util.*, br.com.alura.gerenciador.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de Empresas - Usando Scriplet</title>
</head>
<body>
	<lu>
	  <c:forEach begin="1" end="1200" var="i" step="1">
	  	 <li>Posicao: ${i}</li>
	  </c:forEach>
	</lu>
</body>
</html>