package com.Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.Bean.Customer;
import com.Bean.Login;
import com.DAO.LoginDAO;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		HttpSession hs = request.getSession();
		
		Customer customer = new Customer();
		Login login = new Login();
		login.setUserName(userName);
		login.setPassword(password);
		LoginDAO ld = new LoginDAO();
		if (ld.checkUser(login)) {
			customer = ld.getCustomer(login);
			hs.setAttribute("customer", customer);
			hs.setAttribute("passStatus",5);
			hs.setAttribute("updateStatus",5);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);
			
		}

		else {
			 response.sendRedirect("jsp/login.jsp?msg=wrong input");
		}

	}

}
