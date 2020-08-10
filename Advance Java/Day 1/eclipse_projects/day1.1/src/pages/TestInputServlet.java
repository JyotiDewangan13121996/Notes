package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestInputServlet
 */
@WebServlet("/test_input")
public class TestInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//print details 
		//set cont type
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h4> Hello , "+request.getParameter("f1")+"</h4>");
			pw.print("<h4> Colors :   "+Arrays.toString(request.getParameterValues("clr"))+"</h4>");
			pw.print("<h4> Browser  :   "+request.getParameter("browser")+"</h4>");
			pw.print("<h4> Selected Value   :   "+request.getParameter("myselect")+"</h4>");
			
		}
	}

}
