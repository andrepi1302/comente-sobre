<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Comentários relacionados ao tema: ${palavraChave }</title>
		<jsp:include page="/util/cabecalho.jsp"></jsp:include>
	</head>
	<body>
		<div class="divTabela">
			<label class="labelTabela">Apresentação de comentarios relacionados</label>
			<br/><br/>
			<table cellpadding="10px;" cellspacing="0px;">
				<thead>
					<tr>
						<th>
							Email Comentarista
						</th>
						<th>
							Tema Escolhido
						</th>
						<th>
							Comentário
						</th>
					</tr>
				</thead>
				<tbody>
					<core:forEach items="${comentarioList }" var="comentario" varStatus="status">
						<tr class="${status.count  % 2 eq 0 ? 'linha-normal' : 'linha-diferenciada'}" >
							<td>
								${comentario.visitante.email }
							</td>
							<td>
								<b>${comentario.palavraChave }</b>
							</td>
							<td>
								${comentario.comentario }
							</td>
						</tr>
					</core:forEach>
				</tbody>
			</table>
			<br/>
			<br/>
			<form action="<core:url value="/"/>">
				<input type="submit" class="botao-padrao botao-apresentacao" value="Comentar Novamente!"/>
			</form>
		</div>
	</body>
</html>