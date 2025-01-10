<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-2 offset-md-3"></div>
			<div class="card mt-4 shadow">
				<div class="card-header text-center text-white bg-custom">
					<i class="fa fa-user-plus fa-3x " aria-hidden="true"></i>
					<h4>Login Page</h4>
				</div>


				<%
					String invalidMsg = (String) session.getAttribute("login-failed");

					if (invalidMsg != null) {
				%>
				<div class="alert alert-danger" role="alert"><%=invalidMsg%></div>



				<%
					session.removeAttribute("login-failed");

					}
				%>
				<%
					String withoutLogin = (String) session.getAttribute("login-error");
					if (withoutLogin != null) {
				%>

				<div class="alert alert-danger" role="alert"><%=withoutLogin%></div>



				<%
					session.removeAttribute("login-error");
					}
				%>

                 <%
                    String logoutMsg=(String)session.getAttribute("logoutMsg");
                    if(logoutMsg!=null)
                    {%>
                    	<div class="alert alert-success" role="alert"><%=logoutMsg%></div>
                    <%
                    session.removeAttribute("logoutMsg");
                    }
                 %>
				<div class="card-body">
					<form action="loginServlet" method="post">
						<div class="form-group">
							<label>Enter Email</label> <input type="email"
								class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="uemail">

						</div>
						<div class="form-group">
							<label for="exampleInputPassword1"> Enter Password</label> <input
								type="password" class="form-control" id="exampleInputPassword1"
								name="upassword">
						</div>

						<button type="submit" class="btn btn-primary badge-pill btn-block">Login</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid bg-dark mt-1">
<p class="text-center text-white">Note:Any Errors occur then contact Codewith Aswini. Designed and Developed By Aswini Swain</p>

<p class="text-center text-white">All Right Reserved @codewithAswini-2023-24</p>

</div>
</body>
</html>