package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.API.FOREXRetrieval;
import com.API.NASDAQRetrieval;
import com.API.NSERetrieval;
import com.Bean.Forex;
import com.Bean.GoogAPIBean;
import com.Service.StockService;


public class UpdateStockController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateStockController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Inside dopost of controller");
		StockService ss=new StockService();
		ArrayList<GoogAPIBean> nse=NSERetrieval.returnNSE();
		ArrayList<GoogAPIBean> nasdaq=NASDAQRetrieval.returnNASDAQ();
		ArrayList<Forex> forex=FOREXRetrieval.returnFOREX();
		
		System.out.println("array list is retrieved");
		
		boolean n1=false;
		boolean n2=false;
		boolean n3=false;
		
		n1=ss.populateStock(nse);
		n2=ss.populateStock(nasdaq);
		n3=ss.populateForex(forex);
		
		
		if(n1==true)
		{
			System.out.println("NSE successfully updated");
		}
		if(n2==true)
		{
			System.out.println("NASDAQ successfully updated");
		}
		if(n3==true)
		{
			System.out.println("FOREX successfully updated");
		}
		
		
	
		
		request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
		
		
	}

}
