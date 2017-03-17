package edu.mum.cs472;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ChooseServlet extends HttpServlet {

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
        
        String jspRadioYes = "checked";
        String jspRadioNo = "checked";
        if (isJSPCool != null) {
            if(isJSPCool.equals("1")){
                request.setAttribute("jspRadioYes", jspRadioYes);
                jspRadioNo = "";
                request.setAttribute("jspRadioNo", jspRadioNo);
                
            }else{
                request.setAttribute("jspRadioNo", jspRadioNo);
                jspRadioYes = "";
                request.setAttribute("jspRadioYes", jspRadioYes);
                
            }
        }
        
        String jsfRadioYes = "checked";
        String jsfRadioNo = "checked";
        if (isJSFCool != null) {
            if(isJSFCool.equals("1")){
                request.setAttribute("jsfRadioYes", jsfRadioYes);
                jsfRadioNo = "";
                request.setAttribute("jsfRadioNo", jsfRadioNo);
                
            }else{
                request.setAttribute("jsfRadioNo", jsfRadioNo);
                jsfRadioYes = "";
                request.setAttribute("jsfRadioYes", jsfRadioYes);
                
            }
        }
        
        String moonRadioYes = "checked";
        String moonRadioNo = "checked";
        if (isMoonCheese != null) {
            if(isMoonCheese.equals("1")){
                request.setAttribute("moonRadioYes", moonRadioYes);
                moonRadioNo = "";
                request.setAttribute("moonRadioNo", moonRadioNo);
                
            }else{
                request.setAttribute("moonRadioNo", moonRadioNo);
                moonRadioYes = "";
                request.setAttribute("moonRadioYes", moonRadioYes);
                
            }
        }

        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }
}
