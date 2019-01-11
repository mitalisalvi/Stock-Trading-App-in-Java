package com.Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.Bean.Customer;
import com.DAO.RegistrationDAO;


public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrationController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
        
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Hello");  
	    Customer customer = new Customer();
	    String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String country=request.getParameter("country");
        String secretAnswer=request.getParameter("secretAnswer");
        String dob = request.getParameter("dob");
		
        String phn = request.getParameter("phoneNumber");
        long phoneNumber= Long.parseLong(phn);
        String email = request.getParameter("email");
        
        
        
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setCountry(country);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setSecretAnswer(secretAnswer) ;
        customer.setDob(dob);
        RegistrationDAO rgs = new  RegistrationDAO ();
        boolean flag = rgs.insertCustomer(customer, username, password);


        if(flag)
        	{
        	RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
        	rd.forward(request, response);
        	}
        else
        
        {
        	RequestDispatcher rd = request.getRequestDispatcher("jsp/register.jsp");
         	rd.include(request, response);
        }
	}

}
