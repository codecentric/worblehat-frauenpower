<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Show Borrowed Books - Worblehat Bookmanager</title>
</head>
<body>
	<h1>Borrowed Books</h1>

	<form:form commandName="showBorrowedFormData" method="POST">
            Email:<form:input id="emailAddress" path="emailAddress" />
		<form:errors path="emailAddress" />
		<br />
		<input type="submit" id="showBorrowed" value="Show borrowed books" />
		<hr />
		<table>
	<thead>  
		<tr>
			<th>Title</th>
			<th>ISBN</th>			
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${books}" var="book">
		<tr>
			<td>${book.title}</td>
			<td>${book.isbn}</td>			
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<hr />
		<a href="<spring:url value="/" htmlEscape="true" />">Back to Home</a>
	</form:form>


</body>
</html>