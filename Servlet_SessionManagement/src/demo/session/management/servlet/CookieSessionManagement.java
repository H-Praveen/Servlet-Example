package demo.session.management.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieSessionManagement
 */
@WebServlet("/cookiesessionmanagement")
public class CookieSessionManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CookieSessionManagement() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name"); // read request parameter
		if(name.isEmpty()) {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.write(errorResponse("Name can't be empty or null. "));
			out.close();
		} else {
			
			Cookie cookie = new Cookie("cookie", "cookie1"); // create cookie 
			cookie.setMaxAge(60); // setting the life time of cookie
			response.addCookie(cookie); // adding cookie to response
			response.sendRedirect("./sum.jsp");
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	/**
	 * <p> This method is to write error page content </p>
	 * @param errMsg: Error message which is required to display
	 * @return String: Error page content to requester
	 */
	private String errorResponse(String errMsg) {
		
		String errorPage = "<!DOCTYPE><head><title>Error Page</title></head><body> <h5> Error: "+errMsg
				+ "</h5> <br/> Click the link for re-attempt <a href=\"./cookiesessionmanagement\">click to login</a></body>";
		return errorPage;
	}

}
