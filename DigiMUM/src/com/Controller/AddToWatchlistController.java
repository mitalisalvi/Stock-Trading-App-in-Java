package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Customer;
import com.Service.StockService;
import com.Service.WatchlistService;

public class AddToWatchlistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddToWatchlistController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//PrintWriter bb=response.getWriter();
		//bb.println("fjdkghfdjghdfghjk");
		
		String symbolreceived=request.getParameter("stockId");
		
		int id=Integer.parseInt(symbolreceived);
		
		//forward id which is stock id to dao and then copy from stockmarket table
		
		boolean n1=false;
		
		HttpSession hs=request.getSession(false);
	
		Customer cst=(Customer)hs.getAttribute("customer");
		
		WatchlistService wtcsvc = new WatchlistService();
		
		n1 = wtcsvc.addToWatchlist(id, cst);
	
		if(n1==true)
		{
			System.out.println("Watchlist sucessfully added");
			hs.setAttribute("addWatchlist",true);
		}
		else hs.setAttribute("addWatchlist",false);
		
		request.getRequestDispatcher("jsp/marketTable.jsp").forward(request,response);
	}

}
