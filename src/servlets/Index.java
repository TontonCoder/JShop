package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends HttpServlet {

	public void doGet (HttpServletRequest request, HttpServletResponse reponse) 
			throws IOException , ServletException   {
		this.getServletContext().getRequestDispatcher("index.jsp").forward(request,reponse);
	}
}
