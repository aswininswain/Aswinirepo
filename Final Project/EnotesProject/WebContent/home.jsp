<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%
	UserDetails user2 = (UserDetails) session.getAttribute("userD");

	if (user2 == null) {
		response.sendRedirect("login.jsp");
		session.setAttribute("login-error", "please login...");
	}
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>
<div class="container-fluid p-0">
<%@include file="all_component/navbar.jsp" %>
<div class="card py-5">
<div class="card-body text-center">
<img alt="" src="img/notepad-3297994_640.jpg" class="img-fluid mx-auto" style="max-width: 490px;">
<h1>START TAKING YOUR NOTES</h1>
<a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
</div>
</div>
</div>
<div class="container-fluid bg-dark mt-1">
<p class="text-center text-white">Note:Any Errors occur then contact Codewith Aswini. Designed and Developed By Aswini Swain</p>

<p class="text-center text-white">All Right Reserved @codewithAswini-2023-24</p>

</div>
</body>
</html>