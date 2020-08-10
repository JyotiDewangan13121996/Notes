package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
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

			// retrieve user details from cookie
			// get cookie from request hdr
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies)
					if (c.getName().equals("user_dtls")) {
						pw.print("<h4> User Details " + c.getValue() + "</h4>");
						// set max age of cookie 0
						c.setMaxAge(0);// server side changed cookie state
						// add cookie to resp hdr
						response.addCookie(c);// comment this line n observe

					}
			} else
				pw.print("<h4> Session Tracking failed : No Cookies</h4>");
			pw.print("<h4> Logged out successfully....</h4>");

			// log out link
			pw.print("<h4> <a href='login.html'>Visit Again</a></h4>");

		}
	}

}
