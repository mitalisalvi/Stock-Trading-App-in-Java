package com.Controller;

import com.Service.ViewAlertService;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.Bean.Customer;
import com.Bean.ViewAlert;


public class ViewAlertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewAlertController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession(false);
		Customer cst = (Customer)hs.getAttribute("customer");
		ViewAlertService vas=new ViewAlertService(); 
		ArrayList<ViewAlert> viewAlerts=vas.viewAlert(cst);
		
		
		
		hs.setAttribute("viewAlerts", viewAlerts);
		request.getRequestDispatcher("jsp/viewAlerts.jsp").forward(request, response);
		
	}

}
