package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.PostDao;
import com.Db.DBConnect;

@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String Title = request.getParameter("title");
			String Content = request.getParameter("content");
			Integer noteid=Integer.parseInt(request.getParameter("noteid"));
			
			PostDao dao = new PostDao(DBConnect.getCOnn());
			boolean f = dao.PostUpdate(Title, Content,noteid);
			if(f)
			{
				System.out.println("data update successfully");
				HttpSession session = request.getSession();
				session.setAttribute("updateMsg", "Notes Update Succesfully");
				response.sendRedirect("showNotes.jsp");

			}
			else
			{
				System.out.println("data update not successfully");
			}

		} catch (Exception e) 
		{
          e.printStackTrace();
		}
			
	}

}
