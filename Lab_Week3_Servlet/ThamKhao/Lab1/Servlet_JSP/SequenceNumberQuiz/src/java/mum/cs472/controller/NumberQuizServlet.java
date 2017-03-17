package mum.cs472.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mum.cs472.model.Quiz;

/**
 *
 * @author SOKLY
 */
public class NumberQuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);        
        showHomePage(request, response, session);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession s = request.getSession();
        if(s.isNew()){
            s.setAttribute("quiz", new Quiz());  
        }
        Quiz sessQuiz = (Quiz) s.getAttribute("quiz");
        if (request.getParameter("btnNext") != null) {
            if (sessQuiz.getNumCorrect() == sessQuiz.getNumQuestions() - 1) {
                genQuizOverPage(out);
            } else {
                String answer = request.getParameter("txtAnswer");
                boolean error = true;
                if ((answer != null) && sessQuiz.isCorrect(answer)) {
                    error = false;
                    sessQuiz.scoreAnswer();
                }
                String currQuest = sessQuiz.getCurrentQuestion();
                genQuizPage(sessQuiz, out, currQuest, error, answer);
            }
        } else if (request.getParameter("btnRestart") != null) {
              response.sendRedirect("http://localhost:8080/SequenceNumberQuiz/SequenceNumberQuiz");
        }

    }

    private void genQuizPage(Quiz sessQuiz, PrintWriter out, String currQuest, boolean error, String answer) {

        out.print("<html>");
        out.print("<head>");
        out.print("	<title>NumberQuiz</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("	<form method='post'>");
        out.print("		<h3>Have fun with NumberQuiz!</h3>");
        out.print("<p>Your current score is: ");
        out.print(sessQuiz.getNumCorrect() + "</br></br>");
        out.print("<p>Guess the next number in the sequence! ");
        out.print(currQuest + "</p>");

        out.print("<p>Your answer:<input type='text' name='txtAnswer' value='' /></p> ");

        /* if incorrect, then print out error message */
        if (error && (answer != null)) {  //REFACTOR?-- assumes answer null only when first open page
            out.print("<p style='color:red'>Your last answer was not correct! Please try again</p> ");
        }
        out.print("<p><input type='submit' name='btnNext' value='Next' />");
        out.print("<input type='submit' name='btnRestart' value='Restart!' /></p> ");
        out.print("</form>");
        out.print("</body></html>");
    }

    private void genQuizOverPage(PrintWriter out) {
        out.print("<html> ");
        out.print("<head >");
        out.print("<title>NumberQuiz is over</title> ");
        out.print("</head> ");
        out.print("<body> ");
        out.print("<p style='color:red'>The number quiz is over!</p>");
        out.print("	<form method='post'>");
        out.print("<p><input type='submit' name='btnRestart' value='Restart!' /></p> ");
        out.print("</form></body></html> ");
    }

    public void showHomePage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if(!session.isNew()) session.invalidate();
        session = request.getSession();
        session.setAttribute("quiz", new Quiz());
        Quiz sessQuiz = (Quiz) session.getAttribute("quiz");
        String currQuest = sessQuiz.getCurrentQuestion();
        System.out.println("Number correct: "+sessQuiz.getNumCorrect());
        genQuizPage(sessQuiz, out, currQuest, false, null);
    }
}
