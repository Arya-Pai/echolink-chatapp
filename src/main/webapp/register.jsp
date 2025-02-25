<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
    <form action="RegistrationPage" method="post">
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required>
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" required>
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required >
        <input type="submit" value="Register">
    </form>
    <%String fail=(String)session.getAttribute("failureRegistrationMessage");
    	if(fail!=null){
    %>
    <script>
    	alert("<%=fail%>");
    </script>
    <%session.removeAttribute("failureRegistrationMessage") ;
    	}
    %>
</body>
</html>