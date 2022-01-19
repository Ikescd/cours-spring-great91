<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="fr_FR" scope="session"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="session"/><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${titrePage ? titrePage : "Projet Spring"}</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
<meta id="_csrf" name="_csrf" data-token="${_csrf.token}">
<meta id="contextPath" name="contextPath" data-path="${contextPath}">
</head>
<body class="fluid-container">
<header class="row">
<!-- le champ de recherche -->
<div class="col-md-4 col-md-offset-4">
	<form action="${contextPath}/produit/list" method="get">
		<input type="search" name="search"/>
		<button type="submit" class="btn btn-success">Rechercher</button>
	</form>
</div>
</header>