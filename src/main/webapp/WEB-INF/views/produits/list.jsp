<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/includes/header.jsp" />
<c:if test="${!(param.search == null || param.search == '')}">
	<p>Résultats pour "<c:out value='${param.search}'/>":</p>
	<p>Résultats pour "${param.search}":</p>
</c:if>
<h1>Liste des produits</h1>

<table class="table table-stripped">
<thead>
	<tr>
		<th>ISBN</th>
		<th>Nom</th>
		<th>Description</th>
		<th>stock</th>
		<th>prix</th>
		<th>Action</th>
	</tr>
</thead>
	<tbody>
		<c:forEach var="produit" items="${produits}">
			<tr>
				<td>${produit.isbn} </.td>
				<td>${produit.nom}</td>
				<td>${produit.designation} </td>
				<td>${produit.stock}</td>
				<td>
					<fmt:formatNumber value="${produit.prixHT * 1.20}" 
							type="currency"/>
				</td>
				<td>
					<div class="btn-group">
						<a class="btn btn-primary" href="${contextPath}/produit/show/${produit.id}">Afficher</a>
						<a class="btn btn-warning"  href="${contextPath}/admin/produit/update?id=${produit.id}">Mettre à jour</a>
						<button class="btn btn-danger deleteBtn" data-id="${produit.id}">Supprimer</button>
					</div>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
	<script type="text/javascript" src="${contextPath}/js/main.js"></script>
</body>
</html>