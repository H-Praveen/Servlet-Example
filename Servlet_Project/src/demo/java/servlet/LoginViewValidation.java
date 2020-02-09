package demo.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.java.servlet.service.LoginValidationService;

/**
 * Servlet implementation class DisplayView
 */
@WebServlet("/login")
public class LoginViewValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginViewValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		response.sendRedirect("./login.jsp");
		//out.close();
	}

	/**
	 * <p> This method is invoked when user sents POST request for login </p>
	 * 
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // reading request parameter from request
		String username = request.getParameter("un");
		String password = request.getParameter("pw");
		if(username.isEmpty() && password.isEmpty()) {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.write(errorResponse("Username/Password can't be empty or null. "));
			out.close();
		} else {
			
			LoginValidationService loginService = new LoginValidationService();
			boolean isValid = loginService.loginValidation(username, password);
			if(isValid) {
				response.sendRedirect("./home.jsp");
			} else {
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.write(errorResponse("Invalid login details. "));
				out.close();
				
			}
		}
		
		
	}
	
	/**
	 * <p> This method is to write error page content </p>
	 * @param errMsg: Error message which is required to display
	 * @return String: Error page content to requester
	 */
	private String errorResponse(String errMsg) {
		
		String errorPage = "<!DOCTYPE><head><title>Error Page</title></head><body> <h5> Error: "+errMsg
				+ "</h5> <br/> Click the link for re-attempt <a href=\"./login\">click to login</a></body>";
		return errorPage;
	}
}
