package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SetAlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SetAlert() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stockSymbol=request.getParameter("stockSymbol");
		HttpSession hs=request.getSession(false);
		hs.setAttribute("stockSymbol", stockSymbol);
		request.getRequestDispatcher("/jsp/setAlerts.jsp").forward(request, response);
	}

}
