package demo.session.management.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HttpSessionServlet
 */
@WebServlet("/httpsessionservlet")
public class HttpSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
		Optional<Object> name = Optional.of(session.getAttribute("uName"));
		
		if(name.isPresent()) {
			
			out.write("<!DOCTYPE><html> <head> <title> Http Session </title> "
					+ "<style> table,td,tr, th{border:1px solid;}</style>"
					+ "</head><body>"
					+ "<p> Hello... "+name.get()+", </p> <br/> Below are hard coded value which is used to "
					+ "display if session is exists. <br/>"
					+ "<table>"
					+ "<tr><th colspan=\"2\"> Hard coded values</th></tr>"
					+ "<tr><td>Name</td><td>"+name.get()+"</td></tr>"
					+ "<tr><td>Session type</td><td> Http Session </td></tr>"
					+ "</table>"
					+ "<br/><p> To back to index page <a href=\"./\">click here</a>"
					+ "</body></html>");
		} else {
			
			out.write(" <h5> Invalid request. </h5><br/> <a href=\"./\">Click here</a> to start the session.");
			
		}
		} catch(Exception ex) {
			
			out.write(" <h5> Invalid request. </h5><br/> <a href=\"./\">Click here</a> to start the session.");
		} finally {
			
			if(out != null) {
				out.close();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		session.setAttribute("uName", name);
		session.setMaxInactiveInterval(60);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<!DOCTYPE><html> <head> <title> Http Session </title> "
				+ "</head><body>"
				+ "<p> Hello... "+name+", To check details <a href=\"./httpsessionservlet\">click here </a> </p>"
				+ "</body></html>");
	}

}
