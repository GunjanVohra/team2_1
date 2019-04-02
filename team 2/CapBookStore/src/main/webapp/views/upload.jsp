<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<body>

<h1>Spring Boot file upload example</h1>

<form method="POST" action="/upload" enctype="multipart/form-data" >
    <input type="file" name="file" accept=".jpg, .jpeg, .png"/><br/><br/>
    <input type="text" name="emailId">
    <input type="submit" value="Submit" />
</form>

</body>
</html>