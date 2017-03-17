package mum.cs472.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mum.cs472.model.BeerExpert;

/**
 *
 * @author SOKLY
 */
public class BeerAdvisorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String c = request.getParameter("color");
        BeerExpert be = new BeerExpert();
        List results = be.getBrands(c);
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("Beer Selection Advice<br>");
//        
//        Iterator it = results.iterator();        
//        while(it.hasNext()){
//            out.print("<br>try: "+it.next());
//        }

        request.setAttribute("styles", results);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
        
    }

}
