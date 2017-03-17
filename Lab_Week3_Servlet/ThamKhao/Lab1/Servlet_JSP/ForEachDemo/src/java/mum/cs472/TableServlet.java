package mum.cs472;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SOKLY
 */
public class TableServlet extends HttpServlet {

    static final long serialVersionUID = 0;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Student[] table = new Student[]{
            new Student("bob", 23),
            new Student("jill", 33),
            new Student("kim", 18)
        };

        request.setAttribute("students", table);

        RequestDispatcher dispatcher = request.getRequestDispatcher("tableMyForEach.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("tableMyForEach.jsp");
        dispatcher.forward(request, response);
    }
}
