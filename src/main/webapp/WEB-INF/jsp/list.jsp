<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://pt.link.libraries/linktables" prefix="linktable"%>

<!DOCTYPE html>
<html>

<body>

	<%-- <spring:url value="/list.html" var="urlExemplo">
	</spring:url> 

	<linktable:table id="citizenCard" tableObject="${citizenCard}" currentUrl="${urlExemplo}">
	</linktable:table> --%>
	<div class="container">

		<h1>Citizen Card Info</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Country</th>
					<th>Name</th>
					<th>Sex</th>
					<th>Card Number</th>
					<th>Certificate</th>
				</tr>
			</thead>

			<c:forEach var="cc" items="${citizenCard}">
			    <tr>
				<td>${cc.country}</td>
				<td>${cc.name}</td>
				<td>${cc.sex}</td>
				<td>${cc.cardNumber}</td>
				<td>${cc.certs}</td>
			    </tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>