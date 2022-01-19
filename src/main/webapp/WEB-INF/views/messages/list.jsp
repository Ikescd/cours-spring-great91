<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Liste des messages</title>
</head>
<body>
	<h1>Liste des messages</h1>
	<c:forEach var="m" items="${messages}">
		<p>${m}</p>
	</c:forEach>
</body>
</html>