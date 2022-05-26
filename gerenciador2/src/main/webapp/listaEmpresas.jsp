<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="java.util.*, br.com.alura.gerenciador.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de Empresas - Usando Scriplet</title>



</head>
<body>

	<form>

		<h1>Lista de Empresas usando TagLIB aliado com EL</h1>
		<c:forEach items="${empresas}" var="e">
			<li><span>${e.id} ou ${e.getId()}</span></li>
		</c:forEach>


		<br /> <br />

		<h1>Lista de Empresas usando Scriptlet- For aninhado
			completamente no Scriplet</h1>
		<lu> <%
 List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");
 for (Empresa item : lista) {
 	out.println("<li>");
 	out.println("<span>" + item.getId() + " - " + item.getEmpresa() + "</span><br>");
 	out.println("</li>");
 }
 %> </lu>

		<br /> <br />
		<h1>Lista de Empresas usando Scriptlet - Utilizando o '=' ao
			inves de 'out'</h1>
		<%
		List<Empresa> lista2 = (List<Empresa>) request.getAttribute("empresas");
		for (Empresa item : lista2) {
		%>
		<li><span><%=item.getId() + " - " + item.getEmpresa()%> </span></li>
		<%
		}
		%>

		<br> <br>
		<h1>Lista de Empresas usando TagLIB aliado com EL - Formatacao
			Datas</h1>
		<c:forEach items="${empresas}" var="e">
			<lu>
			<li><span>${e.id} --- ${e.empresa} --- <fmt:formatDate
						value="${e.dataAbertura}" pattern="dd/MM/yyyy" /></span> --- 
						<a href="/gerenciador/excluiEmpresaServlet?id=${e.id}">Excluir</a>
						<a href="/gerenciador/mostraEmpresaServlet?id=${e.id}">Editar</a>
			</li>

			</lu>
		</c:forEach>

		<a href="/gerenciador/formNovaEmpresa5.jsp">Nova Empresa</a>

	</form>
</body>
</html>