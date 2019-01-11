package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Customer;
import com.Bean.TradeAccount;
import com.DAO.ViewUpdateDAO;
import com.Service.ViewUpdateService;


public class ViewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewUpdateController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String selection = request.getParameter("selection");
				
		HttpSession hs = request.getSession(false);
		
		ViewUpdateDAO vudao = new ViewUpdateDAO();
		
		Customer cst = (Customer)hs.getAttribute("customer");
		
		if("view".equalsIgnoreCase(selection))
		{
			TradeAccount trac = new TradeAccount();
			trac = vudao.viewProfile(cst);
			hs.setAttribute("tradeAccount",trac);
			request.getRequestDispatcher("jsp/profile.jsp").forward(request,response);
		}
		
		else if("update".equalsIgnoreCase(selection))
		{
			Customer cd = new Customer();
			Customer c = new Customer();
			ViewUpdateService vusvc = new ViewUpdateService();
			
			cd.setUserId(cst.getUserId());
			cd.setFirstName(request.getParameter("firstName"));
			cd.setLastName(request.getParameter("lastName"));
			cd.setDob(cst.getDob());
			cd.setCountry(cst.getCountry());
			cd.setPhoneNumber(Long.parseLong(request.getParameter("phoneNumber")));
			cd.setEmail(request.getParameter("emailId"));
			cd.setSecretAnswer(cst.getSecretAnswer());
			cd.setImage(cst.getImage());
			
			if("correct".equals(vusvc.checkUnique(cd)))
				if (vusvc.updateStatus(cd))
				{
					c = vusvc.updateConfirm(cd);
					hs.setAttribute("updateStatus",3);
					hs.setAttribute("customer",c);
				}	
			else if ("phoneNumber".equals(vusvc.checkUnique(cd)))
				 hs.setAttribute("updateStatus",1);
			else if ("email".equals(vusvc.checkUnique(cd)))
				 hs.setAttribute("updateStatus",2);
			else hs.setAttribute("updateStatus",0);
			
			request.getRequestDispatcher("jsp/profile.jsp").forward(request,response);
		}
		
		else request.getRequestDispatcher("jsp/home.jsp").forward(request,response);
	}

}
