<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title> Add Todo Page</title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
	
	</head>
<body>
	<div class="container">
	    <h2>Enter Todo Details:</h2>
	    <hr>
	    <form:form method="post" modelAttribute="todo">
	    		<form:input path="id" type="hidden" name="id" />
				Description: <form:input path="description" type="text" name="description" required="required"/>
				<form:errors path="description" cssClass="text-warning"/> <br>
				Date: <form:input path ="targetDate" type="date" name="date" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning"/> <br>
				<input type="submit" class="btn btn-success">
				
	    		<form:input path="done" type="hidden" name="done" />
			</form:form>
    </div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

</body>
</html>