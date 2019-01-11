package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Customer;
import com.Bean.Stock;
import com.Service.StockService;


public class ViewMarketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ViewMarketController() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		HttpSession hs=request.getSession(false);
		Customer cst=(Customer)hs.getAttribute("customer");
		String market = request.getParameter("marketType");
		
		StockService ss=new StockService();
		ArrayList<Stock> viewList=ss.viewMarket(market);
		hs.setAttribute("viewList", viewList);
		
		String s="jsp/marketTable.jsp";
		request.getRequestDispatcher(s).forward(request, response);		
	}

}
