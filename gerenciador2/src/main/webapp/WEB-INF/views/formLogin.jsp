<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="java.util.*,br.com.alura.gerenciador.servlet.mvc.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Manutenção de Empresas - Login</h2>
	<div>
	<c:if test="${not empty erro}">
			<p style="background-color: red;color: white;">${erro}</p>
	</c:if>
	</div>
	<form action="${linkEntradaServlet}" method="post">
		<span>Login:</span> <input type="text" name="login" />
	    <span>Senha:</span>	<input type="password" name="senha" />
	   	<input type="submit" value="Enviar"/>
		<input type="hidden" name="acao" value="EfetuaLogin"/>
    
 <!--    	<h1>Aqui resolvemos o problema de repetir o cadastrar toda vez que apertamos F5, pois aqui usamos o response.sendRedirect, ao inves de foward, conforme exemplo do formNovaEmpresa4.jsp ou formNovaEmpresa.jsp. Apos listar as empresas, pressione f5, e veja se o cadastro e realizado novamente. O codigo de redirecionamento e 301/302, basta analisar o GoogleChormeDevTools ou F12, veja a requisição no network.</h1> -->
	</form>
</body>
</html>