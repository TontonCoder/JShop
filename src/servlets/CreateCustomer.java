package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCustomer extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher("/WEB-INF/createcustomer.jsp").forward( request, reponse );
	}
}
