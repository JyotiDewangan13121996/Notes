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

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl dao;

	public void init() throws ServletException {
		// dao inst
		try {
			dao = new UserDaoImpl();
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
				//create a cookie holding user dtls
				Cookie c1=new Cookie("user_dtls", u.toString());
				//add cookie in resp hdr
				response.addCookie(c1);
			//redirect clnt to the category page , in the NEXT request
				pw.print("success from 1st page...");
			//	pw.flush();
				response.sendRedirect("category");
				//resp pkt SC 302 / location="category" , cookie --nm , val , resp body EMPTY
				
			}
		} catch (Exception e) {
			throw new ServletException("err in do-get", e);
		}
	}

}
