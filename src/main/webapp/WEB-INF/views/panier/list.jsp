<jsp:include page="/WEB-INF/views/includes/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Mon Panier ( ${panierCount} )</h1>
<table class="table table-stripped">
<thead>
	<tr>
		<th>ISBN</th>
		<th>Nom</th>
		<th>prix</th>
	</tr>
</thead>
	<tbody>
		<c:forEach var="produit" items="${produits}">
			<c:set var="prixTTC" value="${produit.prixHT * 1.20}"></c:set>
			<tr>
				<td>${produit.isbn} </td>
				<td>${produit.nom} </td>
				<td>
					<fmt:formatNumber value="${prixTTC}" type="currency"/>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/user/order" class="btn btn-primary pull-right">Passer Commande</a>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
	<script type="text/javascript" src="${contextPath}/js/main.js"></script>
</body>
</html>