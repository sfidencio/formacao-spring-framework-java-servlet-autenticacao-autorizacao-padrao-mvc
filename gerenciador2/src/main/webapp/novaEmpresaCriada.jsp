
<%
String testeScriptlet = "Curso Alura";
String testeScriplet2 = "Java";
String empresa = (String)request.getAttribute("empresa"); //objeto recuperado via dispacher do servlet NovaEmpresaServlet.java
System.out.println(testeScriptlet + " - " + testeScriplet2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Empresa</title>
</head>
<body>
	
	<h3>Nova empresa cadastrada no form(formNovaEmpresa.html) => <%=empresa %> - usando scriptlet</h3>
	
	<h1>Nova empresa cadastrada no form(formNovaEmpresa.html) =>${empresa} - usando Expression Language (EL)</h1>
	
	
	<br>
	<br>
	<p>
		O <% out.println(testeScriptlet);%> e um dos melhores do brasil!
	</p>
	<br>
	<p>
	  <%=testeScriplet2 %> e uma das maiores plataforma de desenvolvimento do mundo!
	</p>
	</br>
	
	
	<p>Usando Expression Language:  ${2*5}</p>
	
	
</body>
</html>