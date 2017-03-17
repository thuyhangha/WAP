package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Quiz;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int indexQuestion = 0;		
		int score = 0;
		String currentQuestion = "";		
		int attempt = 0;
		String displayError = "";
		
		Quiz quiz = (Quiz) session.getAttribute("quiz");
		if(quiz == null){
			quiz = new Quiz();		
			session.setAttribute("quiz", quiz);
			
			resetQuiz(session, quiz);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("indexQuiz.jsp");
			dispatch.forward(request, response);
		} else {
			indexQuestion = Integer.parseInt(session.getAttribute("indexQuestion").toString());
			if(request.getParameter("btnNext") != null) {
				//update value from session for each request			
				score = Integer.parseInt(session.getAttribute("score").toString());
				attempt = Integer.parseInt(session.getAttribute("attempt").toString());
				displayError = session.getAttribute("displayError").toString();
				session.setAttribute("correctAnswer", "");
				
				if(indexQuestion < quiz.getAnswers().length){
					int answer = 0;
					//if(request.getParameter("answer")!=null)
					if(isValidInput(request.getParameter("answer").toString())){
						answer = Integer.parseInt(request.getParameter("answer"));
						if(quiz.getAnswers()[indexQuestion] == answer){
							session.setAttribute("displayError", "");
							
							session.setAttribute("score", ++score);						
							session.setAttribute("attempt", 0);
							currentQuestion = quiz.getQuestions()[++indexQuestion];
							session.setAttribute("currentQuestion", currentQuestion);
						} else {
							session.setAttribute("attempt", ++attempt);
							session.setAttribute("displayError", "Your last answer was not correct! Please try again");
							if(attempt == 3){													
								//displayError = "visible";
								session.setAttribute("correctAnswer", quiz.getAnswers()[indexQuestion]);
								//session.setAttribute("disabled", "disabled");
							}
						}
					} else {
						session.setAttribute("displayError", "You should also validate that the number is between 4 and 100.");
					}
					session.setAttribute("indexQuestion", indexQuestion);
				
				}else {
					request.getSession().invalidate();
		            response.sendRedirect("http://localhost:8080/NumberQuiz/NumberQuiz");
				}
				
			} else if(request.getParameter("btnRestart") != null) {
				resetQuiz(session, quiz);
				
			} else if(request.getParameter("btnHint") != null) {
				session.setAttribute("hintInfo", quiz.getHints()[indexQuestion]);
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher("indexQuiz.jsp");
			dispatch.forward(request, response);
		}	
		//generateUI(response, session, indexQuestion, score, quiz);
	}

	public void resetQuiz(HttpSession session, Quiz quiz) {
		session.setAttribute("indexQuestion", 0);
		session.setAttribute("currentQuestion", quiz.getQuestions()[0]);
		session.setAttribute("score", 0);
		session.setAttribute("attempt", 0);
		session.setAttribute("displayError", "");
		session.setAttribute("correctAnswer", "");
		session.setAttribute("disabled", "");
	}

	boolean isValidInput(String input){
		try{
			int inputVal = Integer.parseInt(input);
			if(inputVal >= 4 && inputVal <=100)
				return true;
			return false;
		}catch (NumberFormatException e) {
			// TODO: handle exception
			return false;
		}
	}
}
