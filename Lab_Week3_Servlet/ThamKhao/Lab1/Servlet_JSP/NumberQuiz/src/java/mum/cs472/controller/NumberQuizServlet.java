package mum.cs472.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
//        if (!session.isNew()) {
//            session.invalidate();
//        }
        session = request.getSession();
        session.setAttribute("quiz", new Quiz());
        Quiz sessQuiz = (Quiz) session.getAttribute("quiz");
        request.setAttribute("currentQuiz", sessQuiz.getCurrentQuestion());
        request.setAttribute("currentScore", sessQuiz.getNumCorrect());
        RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
        dispatch.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession s = request.getSession();
        Quiz sessQuiz = (Quiz) s.getAttribute("quiz");

        if (request.getParameter("btnNext") != null) {
            String answer = request.getParameter("txtAnswer");
            boolean error = true;
            if ((answer != null) && sessQuiz.isCorrect(answer)) {
                error = false;
                sessQuiz.scoreAnswer();
                if (sessQuiz.isQuizOver()) {
                    dispatchRequest(request, response, "quizOver.jsp");
                }
            }
            request.setAttribute("currentQuiz", sessQuiz.getCurrentQuestion());
            request.setAttribute("currentScore", sessQuiz.getNumCorrect());
            if (error && (answer != null)) {
                if (sessQuiz.getCountNumAttempt() > 3) {
                    sessQuiz.setCountNumAttempt(0);
                    sessQuiz.increaseNumCorrect();
                } else if (sessQuiz.getCountNumAttempt() < 3) {
                    request.setAttribute("errorMessage", sessQuiz.getErrorMessage());
                } else {
                    request.setAttribute("errorMessage", "No more attempt! Correct answer is " + sessQuiz.getQuizAnswer());
                }
            }
            dispatchRequest(request, response, "index.jsp");
        } else if (request.getParameter("btnRestart") != null) {
            request.getSession().invalidate();
            response.sendRedirect("http://localhost:8080/NumberQuiz/NumberQuiz");
        }

    }

    public void dispatchRequest(HttpServletRequest request, HttpServletResponse response, String pageName)
            throws ServletException, IOException {
        RequestDispatcher dispatch = request.getRequestDispatcher(pageName);
        dispatch.forward(request, response);
    }
}
