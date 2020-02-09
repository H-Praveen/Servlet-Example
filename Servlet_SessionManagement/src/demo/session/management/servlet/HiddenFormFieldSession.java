package demo.session.management.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenFormFieldSession
 */
@WebServlet("/hiddeformfieldsession")
public class HiddenFormFieldSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiddenFormFieldSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name") == null ? "": request.getParameter("name");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<form action=\"./hiddeformfieldsession\" method=\"post\">" + 
				"	<table>" + 
				"	<tr>" + 
				"		<th colspan=\"2\"> Mathematical operations</th>" + 
				"	</tr>" + 
				"	<tr>" + 
				"		<td><label>First Number</label> </td>" + 
				"		<td> <input type=\"number\" id=\"fn\" name=\"fn\"/></td>" + 
				"	</tr>" + 
				"	<tr>" + 
				"		<td><label>Second Number</label> </td>" + 
				"		<td> <input type=\"number\" id=\"sn\" name=\"sn\"/></td>" + 
				"	</tr>" + 
				"	<tr>" + 
				"		<td colspan=\"2\" align=\"center\"> <button> Check </button></td>" + 
				"	</tr>" + 
				"	</table>" +
				"<input type=\"text\" value=\""+name+"\" id=\"hdfield\" name=\"hdfield\" hidden/>"+
				"</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hdField = request.getParameter("hdfield");
		if(hdField.isEmpty()) {
	
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.write(" <h5> Invalid request. </h5><br/> <a href=\"./\">Click here</a> to start the session.");
			out.close();
		} else {
			
			int firstNumber = Integer.parseInt(request.getParameter("fn"));
			int secondNumber = Integer.parseInt(request.getParameter("sn"));
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.write(" <h5> Result of Addition, Substraction and Multiplication </h5> <br/>"
					+ "Addition of "+firstNumber+"  and "+secondNumber+" is <b>"+(firstNumber+secondNumber)+".</b> <br/>"
					+ "Substrction of "+firstNumber+"  and "+secondNumber+" is <b>"+(firstNumber-secondNumber)+".</b> <br/>"
					+ "Multiplication of "+firstNumber+"  and "+secondNumber+" is <b>"+(firstNumber*secondNumber)+".</b> <br/>");
			out.close();
		}
	}

}
