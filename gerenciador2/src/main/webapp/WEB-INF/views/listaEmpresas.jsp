<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="java.util.*,br.com.alura.gerenciador.servlet.mvc.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntradaServlet" />
<!-- usando c:url ele ja obtem o conexto automatico  /gerenciador2/ e concatena com /entrada -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de Empresas</title>
</head>
<body>
	<form>
	    
	    <h1>Lista de Empresas usando TagLIB aliado com EL - Formatacao	Datas</h1>
		
		<!-- 
		<h3>Usuario logado: ${usuarioLogado.login} - <a href="${linkEntradaServlet}?acao=Logout">Logout</a></h3>
		<br>
		-->
		
		<c:import url="formLogoutParcial.jsp"/>
	
		<table border="1">
		<tr>
		 <th>ID</th>
		 <th>Empresa</th>
		 <th>Data</th>
		  <th colspan="2">Ação</th>
		   <th></th>
		</tr>
		<c:forEach items="${empresas}" var="e">
		<tr>
				<td>${e.id.toString()}</td>
				<td>${e.empresa}</td>
					<td><fmt:formatDate value="${e.dataAbertura}" pattern="dd/MM/yyyy" /></td>
				<td><a href="${linkEntradaServlet}?acao=ExcluiEmpresa&id=${e.id}">Excluir</a></td>
				<td><a href="${linkEntradaServlet}?acao=MostraEmpresa&id=${e.id}">Editar</a></td>
			<!-- 
			<lu>
			<li><span>${e.id} --- ${e.empresa} --- <fmt:formatDate
						value="${e.dataAbertura}" pattern="dd/MM/yyyy" /></span> --- 
						<a href="/gerenciador2/entrada?acao=exclui&id=${e.id}">Excluir</a>
						<a href="/gerenciador2/entrada?acao=mostra&id=${e.id}">Editar</a>
			</li>
			</lu>
			 -->
			 </tr>
			</c:forEach>
		</table>
		<a href="/gerenciador2/entrada?acao=NovoFormEmpresa">Nova Empresa</a>
	</form>
</body>
</html>