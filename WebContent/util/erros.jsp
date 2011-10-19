<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

<ul>
	<core:forEach items="${errors}" var="error">
		<li>- ${error.message } </li>	
	</core:forEach>
</ul>