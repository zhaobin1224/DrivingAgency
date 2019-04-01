package com.driving.Service;

import java.sql.SQLException;
import java.util.List;

import com.driving.Dao.Dao;
import com.driving.User.Agency;
import com.driving.User.Student;

public class Service {
     Dao dao = new Dao();
     /*
      * 登录
      */
     public List<Agency> Login(Agency agency) throws Exception {
    	
		
			Agency loginagency = dao.findByName(agency);
			List<Agency> list;
			 if(loginagency==null || loginagency.getAgent_name()==null) {
	    	     throw new UserException("用户名或密码错误！"); 
	    	 }else if(!loginagency.getAgent_passwd().equals(agency.getAgent_passwd())) {
				 throw new UserException("用户名或密码错误！");
			 }else {
				 list = dao.findNextAgency(loginagency);
			 }
			
			return list;
	      
     }
     
     public void theUser() {
		
	}
     
     /*
      * 注册代理
      */
     public void RegistAgency(Agency agency) {
    	 try {
			int i=dao.insert_agency(agency);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     /*
      * 新增学员
      */
     public void AddStudent(Student student) {
    	 try {
			int i = dao.insert_student(student);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
}
