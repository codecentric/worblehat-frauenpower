<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Delete book - Worblehat Bookmanager</title>
</head>
<body>
	<h1>Delete Book</h1>

	<form:form commandName="deleteBookFormData" method="POST">
            ISBN:<form:input id="isbn" path="isbn" />
		<form:errors path="isbn" />
		<br />
		<input type="submit" id="deleteBook" value="Delete Book" />
		<hr />
		<a href="<spring:url value="/" htmlEscape="true" />">Back to Home</a>
	</form:form>


</body>
</html>