package wap.w3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calculatorServlet
 */
@WebServlet("/Calculator")
public class calculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public calculatorServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num1 = request.getParameter("number1");
		String num2 = request.getParameter("number2");
		String num3 = request.getParameter("number3");
		String num4 = request.getParameter("number4");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		StringBuffer sb = new StringBuffer();
		sb.append("<html><head><title>Insert title here</title></head><body>");
		sb.append("<form action='Calculator' method='post'>");
		try{
			int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
			sb.append("<input type='text' name='number1' value='" + num1 + "'/>");
			sb.append(" + ");
			sb.append("<input type='text' name='number2' value='" + num2 + "'/>");
			sb.append(" = ");
			sb.append("<input type='text' name='sum' value='" + sum + "'/>");
			sb.append("<br />");
		
			int multiply = Integer.parseInt(num3) * Integer.parseInt(num4);
			sb.append("<input type='text' name='number3' value='" + num3 + "'/>");
			sb.append(" * ");
			sb.append("<input type='text' name='number4' value='" + num4 + "'/>");
			sb.append(" = ");
			sb.append("<input type='text' name='multiply' value='" + multiply + "'/>");
			sb.append("<br />");
		}catch (NumberFormatException e) {
			response.sendRedirect("index.html");
		}
		sb.append("<input type='submit' value='Submit' />");
		sb.append("</form></body></html>");
		out.println(sb.toString());
		//out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String num1 = request.getParameter("number1");
		String num2 = request.getParameter("number2");
		String num3 = request.getParameter("number3");
		String num4 = request.getParameter("number4");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try{
			int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
			out.println(num1 + " + " + num2 + " = " + sum);
			out.println("<br />");
		
			int multiply = Integer.parseInt(num3) * Integer.parseInt(num4);
			out.println(num3 + " * " + num4 + " = " + multiply);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			response.sendRedirect("index.html");
		}
		out.flush();
	}

}
