package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl dao;
	private BookDaoImpl dao2;

	public void init() throws ServletException {
		// dao inst
		try {
			dao = new UserDaoImpl();
			dao2=new BookDaoImpl();
		} catch (Exception e) {
			// centralized err handling in servlets
			throw new ServletException("err in init", e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			dao.cleanUp();
			dao2.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("err in destroy", e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//set cont type
		response.setContentType("text/html");
		//PW --for sending response to clnt 
		try(PrintWriter pw=response.getWriter())
		{
			//read req params
			String email=request.getParameter("em");
			String pwd=request.getParameter("pass");
			//invoke DAO's method for validation
			User u=dao.authenticateUser(email, pwd);
			if(u == null)
			{
				pw.print("<h4>Invalid Login, Pls <a href=login.html>Retry</a></h4>");
			}
			else {
				//get HS from WC
				HttpSession hs=request.getSession();
				System.out.println("from 1st page "+hs.isNew());
				System.out.println("session ID "+hs.getId());
				//save validated user dtls under session scope
				hs.setAttribute("cust_dtls", u);
				//save daos under sesison scope
				hs.setAttribute("user_dao", dao);
				hs.setAttribute("book_dao", dao2);
				response.sendRedirect("category");
				//resp pkt SC 302 / location="category" , cookie --nm(JSESSIONID) , val(ABC1234)  -1 , resp body EMPTY
				
			}
		} catch (Exception e) {
			throw new ServletException("err in do-get", e);
		}
	}

}
