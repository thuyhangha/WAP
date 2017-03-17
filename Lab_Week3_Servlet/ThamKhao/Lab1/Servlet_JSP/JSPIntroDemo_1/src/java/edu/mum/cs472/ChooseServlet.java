package edu.mum.cs472;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class ChooseServlet extends HttpServlet {

    private List radioCheckList = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String isJSPCool = request.getParameter("radioJSPCool");
        String isJSFCool = request.getParameter("JSFwayCool");
        String isMoonCheese = request.getParameter("moonCheese");

        if (isJSPCool != null) {
            RadioState radioStateObj = null;
            if (isJSPCool.equals("1")) {
                radioCheckList.add(new RadioState("checked", ""));
            } else {
                radioCheckList.add(new RadioState("", "checked"));
            }
        } else {
            radioCheckList.add(null);
        }

        if (isJSFCool != null) {
            if (isJSFCool.equals("1")) {
                radioCheckList.add(new RadioState("checked", ""));
            } else {
                radioCheckList.add(new RadioState("", "checked"));
            }
        } else {
            radioCheckList.add(null);
        }

        if (isMoonCheese != null) {
            if (isMoonCheese.equals("1")) {
                radioCheckList.add(new RadioState("checked", ""));
            } else {
                radioCheckList.add(new RadioState("", "checked"));
            }
        }else{
            radioCheckList.add(null);
        }

        request.setAttribute("radioCheckList", radioCheckList);
        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }
}
