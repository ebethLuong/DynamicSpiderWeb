<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editSpiderServlet" method="post">
name: <input type ="text" name = "name" value= "${spiderToEdit.name}">
Species: <input type = "text" name = "species" value= "${spiderToEdit.species}">
<input type = "hidden" name = "id" value="${spiderToEdit.id}">
<input type = "submit" value="Save">
</form>
</body>
</html>