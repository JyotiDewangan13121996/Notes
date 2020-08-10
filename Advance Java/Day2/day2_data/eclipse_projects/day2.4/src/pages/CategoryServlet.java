package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		// PW --for sending response to clnt
		try (PrintWriter pw = response.getWriter()) {
			pw.print("Login Successful ");

			// get HS from WC
			HttpSession hs = request.getSession();
			// retrieve user details from HS
			User u = (User) hs.getAttribute("cust_dtls");
			if (u != null) {
				// hello user name
				pw.print("<h4> Hello , " + u.getName() + "</h4>");
				// get book dao instance from HS
				BookDaoImpl dao = (BookDaoImpl) hs.getAttribute("book_dao");
				// invoke dao's method to get list of categories
				List<String> categories = dao.getAllCategories();
				// dyn form generation
				pw.print("<form action='category_dtls'>");
				pw.print("Choose Category ");
				pw.print("<select name='cat'>");
				for(String s : categories)
					pw.print("<option value="+s+">"+s+"</option>");
				pw.print("</select><br>");
				pw.print("<input type='submit' value='Choose'>");
				pw.print("</form>");

			} else
				pw.print("<h4> Session Tracking failed : No Cookies</h4>");
			// log out link
			pw.print("<h4> <a href='logout'>Log Me Out </a></h4>");

		} catch (Exception e) {
			throw new ServletException("err in do-get of " + getClass().getName(), e);
		}
	}

}
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import pojos.User;
