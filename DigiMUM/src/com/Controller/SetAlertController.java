package com.Controller;

import com.Bean.Alert;
import com.Service.SetAlertService;
import com.Bean.Customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SetAlertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SetAlertController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession(false);
		String stockSymbol=hs.getAttribute("stockSymbol").toString();
		String condition=request.getParameter("condition");
		String price=request.getParameter("price");
		boolean flag=false;
		Customer cst = (Customer)hs.getAttribute("customer");
		SetAlertService sas=new SetAlertService();
		long stockId=sas.getStockId(stockSymbol);
		
		Alert a=new Alert();
		a.setPrice(Double.parseDouble(price));
		if(condition.equalsIgnoreCase("more"))
			a.setSign(1);
		else
			a.setSign(-1);
		a.setStockId(stockId);
		a.setUserId(cst.getUserId());
		if(stockId!=0)
			flag=sas.setAlert(a);
		if(flag)
			request.getRequestDispatcher("ViewWatchListController?markettype=NSE").forward(request, response);
		
	}

}
