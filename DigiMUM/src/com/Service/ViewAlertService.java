package com.Service;
import com.Bean.Customer;
import java.util.ArrayList;
import com.Bean.ViewAlert;
import com.DAO.ViewAlertDAO;

public class ViewAlertService {
 public ArrayList<ViewAlert> viewAlert(Customer cst)
 {
	 return(new ViewAlertDAO().viewAlert(cst));
 }
}
