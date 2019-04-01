package com.driving.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.driving.Service.Service;
import com.driving.User.Student;

/**
 * Servlet implementation class AddStudent
 */
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String stu_name = request.getParameter("stu_name");
	      String stu_id = request.getParameter("stu_id");
	      String stu_phone = request.getParameter("stu_phone");
	      String stu_school = request.getParameter("stu_school");
	      
	      Student student = new Student();
	      student.setStu_name(stu_name);
          student.setStu_id(stu_id);
          student.setStu_phone(stu_phone);
          student.setStu_school(stu_school);
          
          Service service = new Service();
          service.AddStudent(student);
	}

}
