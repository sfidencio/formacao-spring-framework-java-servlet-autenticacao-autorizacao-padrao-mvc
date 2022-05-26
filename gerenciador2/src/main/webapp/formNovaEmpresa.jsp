<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="java.util.*, br.com.alura.gerenciador.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Empresa</title>
</head>
<body>
	<form action="/gerenciador/novaEmpresa" method="post">
		<span>Empresa:</span> <input type="text" name="empresa" />
	    <span>CNPJ:</span>	<input type="text" name="cnpj" />
	    <span>Data de Abertura:</span>	<input type="date" name="dtAbertura" />
		<input type="submit" value="Enviar"/>
	</form>
	
		<br><br>
</body>
</html>