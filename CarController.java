package com.car;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CarController extends GenericServlet{

	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String parameter = req.getParameter("carName");
		String parameter2 = req.getParameter("carColour");
		String parameter3 = req.getParameter("carNumber");
		
		Car c=new Car();
		c.setCarName(parameter);
		c.setCarColour(parameter2);
		c.setCarNumber(parameter3);
		
		CarDAO cd=new CarDAO();
		PrintWriter writer = res.getWriter();
		writer.println(CarDAO.save(c));
		
	}

}
