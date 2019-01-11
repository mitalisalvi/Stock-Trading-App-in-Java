package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Customer;
import com.Service.ChangePasswordService;

public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ChangePasswordController() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 HttpSession hs = request.getSession(false);
		 Customer cst = (Customer)hs.getAttribute("customer");
		 
		 String oldPassword = request.getParameter("oldPassword");
		 String newPassword = request.getParameter("newPassword");
		 
		 ChangePasswordService cpsvc = new ChangePasswordService();
		 
		 if(cpsvc.replacePassword(cst, oldPassword, newPassword))
		 {
			hs.setAttribute("passStatus",1);
			request.getRequestDispatcher("jsp/changePass.jsp").forward(request,response);

		 }
		 else 
		 {
			 hs.setAttribute("passStatus",0);
			 request.getRequestDispatcher("jsp/changePass.jsp").forward(request, response); 	
		 }
	}

}