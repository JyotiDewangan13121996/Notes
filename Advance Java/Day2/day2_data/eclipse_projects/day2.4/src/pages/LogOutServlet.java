package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;

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

			// get HS from WC
			HttpSession hs = request.getSession();
			System.out.println("from logout page " + hs.isNew());
			System.out.println("session ID " + hs.getId());
			// retrieve user details from HS
			User u = (User) hs.getAttribute("cust_dtls");
			if (u != null) {
				// hello user name --to confirm session tracking
				pw.print("<h4> Hello , " + u.getName() + "</h4>");
				//discard HS
				hs.invalidate();

			} else
				pw.print("<h4> Session Tracking failed : No Cookies</h4>");
			pw.print("<h4> Logged out successfully....</h4>");

			// log out link
			pw.print("<h4> <a href='login.html'>Visit Again</a></h4>");

		}
	}

}
