package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Customer;
import com.Bean.JoinOPLAccountHistory;
import com.Service.CashBalanceService;
import com.Service.OpenPLService;
import com.Service.OpenPositionAccountHistoryService;


public class CashBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CashBalanceController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession hs = request.getSession(false);
	      Customer cst= (Customer) hs.getAttribute("customer");
	      
	      //callingforcashbalance
	      CashBalanceService cbs = new CashBalanceService();
	      Double cashbalance = cbs.callgetCashBalance(cst);
	      System.out.println(cashbalance);
	      
	      
	      
	      //callingforopenprofitloss
	      OpenPLService ops = new OpenPLService();
		     Double totalop =  ops.callshowOpenPL(cst);
		     System.out.println(totalop);
		     
		     //callingforaccountevaluation
		     
		     Double accval =  ops.callshowAccountEvaluation(cst, totalop);
		     System.out.println(accval);
		     
		     //pltable
		     
		     OpenPositionAccountHistoryService ophs = new  OpenPositionAccountHistoryService();
		     
		      ArrayList<JoinOPLAccountHistory> oacal = new ArrayList<JoinOPLAccountHistory>();
		      
		     oacal= ophs.callgettradehistory(cst);
		     
		     ///assigning 3 displayvalues to array
		     double accountValues[]={cashbalance,totalop,accval};
		     
		     
		     
		    
		     
		        hs.setAttribute("accountValues",accountValues);  
		        
		        
		        hs.setAttribute("tableView",oacal);  
		        
		        RequestDispatcher rd = request.getRequestDispatcher("jsp/-----.jsp");
		        rd.forward(request, response);
	      
	}

}
