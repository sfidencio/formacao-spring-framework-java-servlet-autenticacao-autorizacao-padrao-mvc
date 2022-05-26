<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="link"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Empresa</title>
</head>
<body>

	<form action="${link}" method="post">
		<span>Empresa:</span> <input type="text" name="empresa" /> <span>CNPJ:</span>
		<input type="text" name="cnpj" />
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>