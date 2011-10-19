<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Adicione um Comentário</title>
		<jsp:include page="/util/cabecalho.jsp"></jsp:include>
	</head>
	<body>
		<form action="<core:url value="/${comentario.palavraChave}/apresentacao"/> " method="post" 
			  id="formComentario" class="formulario-padrao formulario-comentario">
			
			<div>
				<input name="comentario.visitante.numeroId"  type="hidden" 
				       value="${comentario.visitante.numeroId}" />
				<input name="comentario.palavraChave" type="hidden" 
					   value="${comentario.palavraChave}"/>
					   
				<label>Tema a ser comentado: </label>
				<label id="palavraChave_comentario">
					${comentario.palavraChave}
				</label>
				<br/>
				<br/>
				<textarea id="textoComentario" name="comentario.comentario" class="textarea">
					${comentario.comentario}
				</textarea>
				<br/>
				<br/>
				<input type="submit" value="Enviar Comentário" class="botao-padrao botao-comentario"/>
			</div>
		</form>
		<div id="div_erros" class="erros erros-comentario">
			<jsp:include page="/util/erros.jsp"></jsp:include>
		</div>
	</body>
</html>