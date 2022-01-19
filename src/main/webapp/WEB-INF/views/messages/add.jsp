<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'ajout</title>
</head>
<body>
	<h1>Formulaire d'ajout</h1>
	<form method="post">
		<div>
			<label for="message">Message</label>
			<!-- message=mon message -->
			<input type="text" id="message" name="message">
			<!-- afficher message d'erreur si le champ est invalide -->
			<c:if test="${erreur != null}">
				<p>${erreur}</p>
			</c:if>
		</div>
		
		<div>
			<input type="submit" value="Créer message">
		</div>
		
	</form>
	
</body>
</html>