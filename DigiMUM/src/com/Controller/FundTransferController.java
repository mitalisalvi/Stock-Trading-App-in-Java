package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Bank;
import com.Bean.Customer;
import com.Bean.TradeAccount;
import com.Service.FundTransferService;


public class FundTransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FundTransferController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	       String bankName= request.getParameter("bankName");
	       double dd = Double.parseDouble(request.getParameter("cashBalance"));
	       
	       HttpSession hs = request.getSession(false);
	       Customer cst= (Customer)hs.getAttribute("customer");
	      
	      
	       FundTransferService fts= new FundTransferService();
	       Bank bank = new Bank();
	       TradeAccount tra = new TradeAccount();
	       
	      
		   tra.setUserId(cst.getUserId());
		   tra.setCashBalance(dd);
		
	       bank = fts.callBank(bankName);
	      
	       tra.setBankId(bank.getBankId());
	      
	       
	       boolean flag = fts.callFundTransfer(tra,dd);
	      
	       
	       request.getRequestDispatcher("jsp/fundTransfer.jsp").forward(request,response);
	}
}