package com.masai.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class MyServlet implements Servlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("InIt method is executed!!");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    System.out.println("Service method is executed!!");
	    res.setContentType("text/html");
	    PrintWriter out=res.getWriter();
	    
	    out.print("Welcom <b>Raghu</b>");
	    out.print("<br>"+new java.util.Date());
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy method is executed!!");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
}
