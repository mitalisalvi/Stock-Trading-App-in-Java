package com.Controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.Bean.AccountStatement;
import com.Bean.Customer;
import com.Service.AccountStatementService;

public class AccountStatementController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
    public AccountStatementController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String fDate=request.getParameter("fDate");
		String tDate=request.getParameter("tDate");
		
		 HttpSession hs = request.getSession(false);
		 Customer cst = (Customer)hs.getAttribute("customer");
		 AccountStatementService asvc = new AccountStatementService(fDate,tDate);
		 AccountStatement acst = asvc.getAccountStatement(cst);
		 hs.setAttribute("accountStatement",acst);
		 request.getRequestDispatcher("jsp/accountStatement.jsp").forward(request,response);
	}
}