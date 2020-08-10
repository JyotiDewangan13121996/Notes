package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import pojos.Book;
import pojos.User;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category_dtls")
public class CategoryDetailsServlet extends HttpServlet {
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
			// get category from request param
			String category = request.getParameter("cat");
			// get HS from WC
			HttpSession hs = request.getSession();
			// retrieve user details from HS
			User u = (User) hs.getAttribute("cust_dtls");
			if (u != null) {
				// hello user name
				pw.print("<h4> Hello , " + u.getName() + "</h4>");
				// get book dao instance from HS
				BookDaoImpl dao = (BookDaoImpl) hs.getAttribute("book_dao");
				// invoke dao's method to get bks under a selected category
				List<Book> booksByCategory = dao.getBooksByCategory(category);
				pw.print("<h4>Books Under Category " + category+"</h4>");
				// dyn form generation
				pw.print("<form action='add_to_cart'>");
				
				for(Book b : booksByCategory)
					pw.print("<input type='checkbox' name='bk' value="+b.getId()+">"+b+"<br>");
				pw.print("<input type='submit' value='Add To cart'>");
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
