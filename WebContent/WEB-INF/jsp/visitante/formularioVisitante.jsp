<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Bem vindo!</title>
		<jsp:include page="/util/cabecalho.jsp"></jsp:include>
	</head>
	<body>
		<form id="formPrincipal"  method="post" action="<core:url value="/"/>" 
			  class="formulario-padrao formulario-visitante">
			<div>
				<label>Caro comentarista, precisamos do seu email:</label>
				<br/><br/>
				<input name="visitante.email" id="email" type="text" value="${visitante.email }" 
					   class="input-visitante" onblur="toUpperCase();"/>
				<br/><br/>
				<label>Me diga, o que deseja comentar?</label>
				<br/><br/>
				<input name="comentario.palavraChave" id="palavraChave" type="text" 
				       value="${comentario.palavraChave }" class="input-visitante"/>
				<br/><br/>
				<input value="Enviar" type="submit" class="botao-padrao botao-visitante"/>
			</div>
		</form>
		<div id="div_erros" class="erros erros-visitante">
			<jsp:include page="/util/erros.jsp"></jsp:include>
		</div>
	</body>
</html>