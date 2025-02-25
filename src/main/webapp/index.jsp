<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	    <%
	    String username=(String)session.getAttribute("username");
	   		String id=(String)session.getAttribute("id");
    	if(username!=null){
    %>
 	<h3>Username:<%=username %></h3>
 	<h3>id:<%=id %></h3>
 	
    <%}else{
    		response.sendRedirect("login.jsp");
    	}
    %>
</body>
</html>