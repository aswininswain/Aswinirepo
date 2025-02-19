package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.Db.DBConnect;
import com.User.UserDetails;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");
		
		UserDetails user = new UserDetails();
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao dao = new UserDao(DBConnect.getCOnn());
		UserDetails us=dao.loginUser(user);
		
		if(us!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("userD", us);
			
			response.sendRedirect("home.jsp");
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("login-failed","Invalid UserName and Password");
			response.sendRedirect("login.jsp");
		}
		

	}

}
