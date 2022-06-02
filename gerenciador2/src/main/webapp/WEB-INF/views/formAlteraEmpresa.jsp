<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="java.util.*,br.com.alura.gerenciador.servlet.mvc.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntradaServlet" />

<!-- usando c:url ele ja obtem o conexto automatico  /gerenciador2/ -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Empresa</title>
</head>
<body>
	<c:import url="formLogoutParcial.jsp"/>
	<form action="${linkEntradaServlet}" method="post">
		<span>Empresa:</span> <input type="text" name="empresa"  value="${empresa.empresa}"/>
	    <span>CNPJ:</span>	<input type="text" name="cnpj" value="${empresa.cnpj}" />
	    <span>Data de Abertura:</span>	<input type="text" name="dtAbertura" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
		<input type="submit" value="Alterar"/>
				<input type="hidden" name="id" value="${empresa.id.toString()}" >
				<input type="hidden" name="acao" value="AlteraEmpresa">
		<!--<h1>Aqui resolvemos o problema de repetir o cadastrar toda vez que apertamos F5, pois aqui usamos o response.sendRedirect, ao inves de foward, conforme exemplo do formNovaEmpresa4.jsp ou formNovaEmpresa.jsp. Apos listar as empresas, pressione f5, e veja se o cadastro e realizado novamente. O codigo de redirecionamento e 301/302, basta analisar o GoogleChormeDevTools ou F12, veja a requisição no network.</h1>-->
	</form>
</body>
</html>