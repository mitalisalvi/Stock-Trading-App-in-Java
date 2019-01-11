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


public class GetStockController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetStockController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	
		StockService ss=new StockService();
		ArrayList<GoogAPIBean> nse=NSERetrieval.returnNSE();
		ArrayList<GoogAPIBean> nasdaq=NASDAQRetrieval.returnNASDAQ();
		ArrayList<Forex> forex=FOREXRetrieval.getFOREX();
		
		boolean n1=false;
		boolean n2=false;
		boolean n3=false;
		
		n1=ss.populateStock(nse);
		n2=ss.populateStock(nasdaq);
		n3=ss.populateForex(forex);
		
		if(n1==false)
		{
			ss.populateStock(nse);
		}
		if(n2==false)
		{
			ss.populateStock(nasdaq);
		}
		if(n3==false)
		{
			ss.populateForex(forex);
		}
		*/
		
		
		
		
	}

}
