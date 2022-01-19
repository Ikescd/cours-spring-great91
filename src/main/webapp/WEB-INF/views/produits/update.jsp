<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/includes/header.jsp" />

<h1>Mettre à jour un produit</h1>
<form:form method="post" modelAttribute="produit">
	<form:hidden path="id" />
	<form:input path="isbn" placeholder="ISBN" cssErrorClass="error"
		readonly="true" />
	<form:errors path="isbn" />
	<form:input path="nom" placeholder="nom produit" cssErrorClass="error" />
	<form:errors path="nom" />
	<form:input path="designation" placeholder="designation"
		cssErrorClass="error" />
	<form:input type="number" path="stock" placeholder="stock"
		cssErrorClass="error" />
	<form:errors path="stock" />
	<form:input path="prixHT" placeholder="prix HT" step=".01"
		cssErrorClass="error" />
	<form:errors path="prixHT" />
	<form:select path="categorie" cssErrorClass="error">
		<form:option selected="true" value="${produit.categorie.id}">${produit.categorie.libelle}</form:option>
		<form:options items="${categories}" itemLabel="libelle" itemValue="id" />
	</form:select>
	<form:errors path="categorie" />
	<input type="submit" value="Mettre à jour produit" />
</form:form>
</body>
</html>