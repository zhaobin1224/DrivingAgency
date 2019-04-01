package com.driving.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.driving.Service.Service;
import com.driving.User.Agency;

/**
 * Servlet implementation class RegistAgency
 */
public class RegistAgency extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistAgency() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	     response.setHeader("Access-Control-Allow-Origin", "*");
	     response.setHeader("Access-Control-Allow-Origin", "GET,POST");
	     request.setCharacterEncoding("UTF-8");
		
		 String agent_name = request.getParameter("agent_name");
	     String agent_id = request.getParameter("agent_id");
	     String agent_phone = request.getParameter("agent_phone");
	     String agent_school = request.getParameter("agent_school");
	     String agent_email = request.getParameter("agent_email");
	     
	     Agency agency = new Agency();
	     agency.setAgent_name(agent_name);
	     agency.setAgent_id(agent_id);
	     agency.setAgent_phone(agent_phone);
	     agency.setAgent_school(agent_school);
	     agency.setAgent_email(agent_email);
	     
	     String token = request.getHeader("token");
	     if(token.equals(request.getSession().getAttribute("token"))) {
	    	 String name = (String) request.getSession().getAttribute(token);
	    	
	     }
	     
	     
	     String string = (String) request.getSession().getAttribute("name");
	     Service service = new Service();
	     service.RegistAgency(agency);
	     
	}

}
