package cust_tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.jasper.el.JspELException;

public class LogoutHandler extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("in do-tag");
		// how to access session from custom tag
		PageContext ctx = (PageContext) getJspContext();
		HttpSession hs = ctx.getSession();
		hs.invalidate();
		HttpServletRequest request = 
				(HttpServletRequest) ctx.getRequest();
		String path = request.getContextPath() + "/";
		HttpServletResponse resp =
				(HttpServletResponse) ctx.getResponse();
		resp.setHeader("refresh", "5;URL='" + path + "'");
	}

}
