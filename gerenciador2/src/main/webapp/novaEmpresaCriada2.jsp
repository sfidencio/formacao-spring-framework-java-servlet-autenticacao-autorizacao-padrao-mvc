<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Empresa</title>
</head>
<body>
	<c:if test="${ not empty empresa}">
		<h1>Empresa ${empresa} criada com sucesso! - Usando apenas EL - Usando tambem c:if e empressao not empty</h1>
	</c:if>
	<c:if test="${empty empresa}">
		<h1>Nenhuma empresa criada com sucesso! - Usando apenas EL</h1>
	</c:if>
</body>
</html>