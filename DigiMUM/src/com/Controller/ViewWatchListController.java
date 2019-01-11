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
import com.Bean.Watchlist;
import com.Service.ViewWatchListService;
import com.Service.WatchlistService;


public class ViewWatchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewWatchListController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession hs = request.getSession(false);
	      Customer cst= (Customer) hs.getAttribute("customer");
	      
	      String markettype = request.getParameter("markettype");
	      ViewWatchListService vws = new ViewWatchListService();
	      ArrayList<Watchlist> alwatch = new ArrayList<Watchlist> ();
	      alwatch = vws.callviewWatchList(cst, markettype);
	     System.out.println(alwatch.size());
	      for(int i=0;i<alwatch.size();i++)
	    	  System.out.println(alwatch.get(i).getStockName());
	      
	      
	      hs.setAttribute("viewWatchList",alwatch);  
	      
	      if(markettype.equalsIgnoreCase("nse"))
	      
	      {  
	    	  RequestDispatcher rd = request.getRequestDispatcher("jsp/stockWatchlist.jsp");
	        rd.forward(request, response);
	      }
	      
	      else if (markettype.equalsIgnoreCase("nasdaq"))
	      {  RequestDispatcher rd = request.getRequestDispatcher("jsp/nasdaqWatchlist.jsp");
	        rd.forward(request, response);
	      }
	      else if (markettype.equalsIgnoreCase("forex"))
	      {  RequestDispatcher rd = request.getRequestDispatcher("jsp/forexWatchlist.jsp");
	        	rd.forward(request, response);
	      }
	      else if (markettype!=null && !(markettype.equals("")))
	      {  
	    	  WatchlistService wtcsvc = new WatchlistService();
	    	  if(wtcsvc.deleteFromWatchlist(markettype, cst))
	    		  request.getRequestDispatcher("jsp/marketTable.jsp").forward(request, response);
	    	  else  request.getRequestDispatcher("jsp/stockWatchlist.jsp").forward(request, response);
	      } 	
	      
	}

}
