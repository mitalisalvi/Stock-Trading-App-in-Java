package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Customer;
import com.Bean.Stock;
import com.Bean.TradeAccount;
import com.Service.TransactionService;
import com.Service.ViewUpdateTransService;

public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public TransactionController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		///call view update trans service
		HttpSession hs=request.getSession(false);
		Customer cst=(Customer)hs.getAttribute("customer");
		ViewUpdateTransService vuts=new ViewUpdateTransService();
		TradeAccount tr=vuts.viewProfile(cst);
		TransactionService ts=new TransactionService();
		int quantity=(Integer.parseInt(request.getParameter("quantity")));
		String buysell=request.getParameter("buySell");
		boolean flag=false;

		String symbolreceived=request.getParameter("stockId");
		
		int id=Integer.parseInt(symbolreceived);
		Stock st=ts.getStock(id);
		
		if(buysell.equalsIgnoreCase("buy"))
		{
			flag=ts.isValidTransaction(tr, st, quantity, buysell);	
		}
		boolean g=false;
		if(flag==true)
		{
			g=ts.doTransaction(cst, st, quantity, buysell);
			
		}
		String s="";
		if(g==true)
		{
			s="jsp/tradeConfirmation.jsp";
			request.getRequestDispatcher(s).forward(request, response);
			
		}
		
		
		
		

	}

}
