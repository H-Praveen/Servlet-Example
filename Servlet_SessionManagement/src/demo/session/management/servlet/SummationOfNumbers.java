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
 * Servlet implementation class SummationOfNumbers
 */
@WebServlet("/addnumbers")
public class SummationOfNumbers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummationOfNumbers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookeiArray = request.getCookies();
		boolean isSessionAvailable = Boolean.FALSE;
		if(cookeiArray.length > 0) {
			for (Cookie cookie : cookeiArray) {
				if(cookie.getValue().equals("cookie1")) {
					isSessionAvailable = Boolean.TRUE;
					break;
				}
			}
			if(isSessionAvailable) {
				Integer firstNum = Integer.parseInt(request.getParameter("firstnum"));
				Integer secondNum = Integer.parseInt(request.getParameter("secondnum"));
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.write("<h4> Hello, <i>"+cookeiArray[0].getValue()+"</i> </h4> <br/> The Sum of Number "+firstNum
						+" and "+secondNum+" is <strong>"+(firstNum+secondNum)+".</strong>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.write(" <h5> Invalid request. <br/> <a href=\"./\">Click here</a> to start session.");
				out.close();
			}
			
		} else {
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.write(" <h5> Invalid request. <br/> <a href=\"./>Click here</a> to start session.");
			out.close();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
