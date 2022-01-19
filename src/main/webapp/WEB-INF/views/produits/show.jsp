<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/includes/header.jsp" />
<h1 class="jumbotron">${produit.nom}</h1>
<div class="row col-md-12">
	<div class="col-lg-4 col-md-4">
		<img alt="${produit.nom}"
			src="${contextPath}/images/produit/${produit.isbn}.jpeg" width="100"
			height="100">
	</div>
	<div class="col-lg-4 col-md-4">
		<div>ISBN : ${produit.isbn}</div>
		<div>nom : ${produit.nom}</div>
		<div>Designation : ${produit.designation}</div>
		<div>prix : <fmt:formatNumber value="${produit.prixHT * 1.20}" 
							type="currency"/></div>
		<div>stock : ${produit.stock}</div>
	</div>
	<div class="col-lg-4 col-md-2">
		<a class="btn btn-primary"
			href="${contextPath}/panier/add/${produit.id}"> ajouter au panier
		</a>
	</div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
	crossorigin="anonymous"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
	integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
	crossorigin="anonymous"></script>
</body>
</html>