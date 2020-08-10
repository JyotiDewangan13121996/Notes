package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(urlPatterns="/s1",loadOnStartup=2)
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init()
	{
		System.out.println("in init of "+getClass().getName());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-get of "+getClass().getName());
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("resp from "+getClass().getName()+new Date());
		}
	}

}
