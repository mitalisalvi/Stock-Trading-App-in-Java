package com.Controller;

import com.DAO.ForgotPasswordDAO;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgotPasswordController() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String newPassword = request.getParameter("confirmPassword");
		String secretAnswer = request.getParameter("secretAnswer");
		RequestDispatcher rd = null;
		String s = "";
		ForgotPasswordDAO f = new ForgotPasswordDAO();

		if (f.checkUserName(userName)) {
			if (f.checkSecretAnswer(userName, secretAnswer)) {
				if (f.changePassword(userName, newPassword)) {
					s = "jsp/login.jsp";
				}

			} else {
				//request.setAttribute("secretAnswerFlag", false);
				s = "jsp/forgotPassword.jsp";

			}

		} else {
			//request.setAttribute("userFlag", false);
			s = "jsp/forgotPassword.jsp";

		}

		rd = request.getRequestDispatcher(s);
		rd.forward(request, response);

	}

}
