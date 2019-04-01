package com.driving.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.driving.User.Agency;
import com.driving.User.Student;

public class Dao {
	public Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/driving agent", "root", "123456");
		return connection;
	}

	// 判断用户名是否存在
	public Agency findByName(Agency agency) throws Exception {
		String sql = "select * from agency where agent_name=?";
		Connection connection = getCon();
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		statement.setString(1, agency.getAgent_name());
		// 返回查询结果
		ResultSet resultset = statement.executeQuery();
		Agency loginagency = new Agency();
		
		while (resultset.next()) {
			loginagency.setAgent_level(resultset.getInt("agent_level"));
			loginagency.setAgent_passwd(resultset.getString("agent_passwd"));
			loginagency.setAgent_name(resultset.getString("agent_name"));
			loginagency.setAgent_stucount(resultset.getInt("agent_stucount"));
		}
		connection.close();
		resultset.close();
		statement.close();
		
		return loginagency;
	}
	
	/*
	 * 查询下一个等级的代理
	 */
	public List<Agency> findNextAgency(Agency agency) throws ClassNotFoundException, SQLException {
		Connection connection = getCon();
		String sql = "select agent_level,agent_name,agent_todaystu,agent_stucount from agency where agent_level=? order by agent_stucount desc";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, agency.getAgent_level()+1);
		//返回查询结果
		ResultSet resultSet = statement.executeQuery();
		List<Agency> list = new ArrayList<Agency>();
		while(resultSet.next()) {
		     Agency agency2 = new Agency();
		     agency2.setAgent_level(resultSet.getInt("agent_level"));
		     agency2.setAgent_name(resultSet.getString("agent_name"));
		     agency2.setAgent_todaystu(resultSet.getInt("agent_todaystu"));
		     agency2.setAgent_stucount(resultSet.getInt("agent_stucount"));
		     list.add(agency2);
		}
		connection.close();
		statement.close();
		resultSet.close();
		return list;
	}  
    
	/**
	 * 返回此用户的信息
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
    public Agency theUser(String name) throws ClassNotFoundException, SQLException {
    	Connection connection = getCon();
		String sql = "select * from agency where agent_name=? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, name);
		ResultSet resultSet = statement.executeQuery();
		Agency agency = new Agency();
		while(resultSet.next()) {
			agency.setAgent_level(resultSet.getInt("agent_level"));
			agency.setAgent_name(resultSet.getString("agent_name"));
			agency.setAgent_todaystu(resultSet.getInt("agent_todaystu"));
			agency.setAgent_stucount(resultSet.getInt("agent_stucount"));
		}
		connection.close();
		statement.close();
		resultSet.close();
		return agency;
    } 

	// 新增代理
	public int insert_agency(Agency agency) throws SQLException, ClassNotFoundException {
		String sql = "insert into agency (agent_level,agent_name,agent_passwd,agent_phone,agent_id,agent_school,agent_email,agent_stucount,agent_image,agent_todaystu) values(?,?,?,?,?,?,?,?,?,?)";
		Connection connection = getCon();
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		statement.setInt(1, agency.getAgent_level());
		statement.setString(2, agency.getAgent_name());
		statement.setString(3, "666666");
		statement.setString(4, agency.getAgent_phone());
		statement.setString(5, agency.getAgent_id());
		statement.setString(6, agency.getAgent_school());
		statement.setString(7, agency.getAgent_email());
		statement.setInt(8, 0);
		statement.setString(9, agency.getAgent_iamgeurl());
		statement.setInt(10, 0);
		int result = statement.executeUpdate();
		return result;
	}

	// 新增学员
	public int insert_student(Student student) throws ClassNotFoundException, SQLException {
		String sql = "insert into student (stu_name,stu_id,stu_phone,stu_school,stu_image,aid) values(?,?,?,?,?,?)";
		Connection connection = getCon();
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		statement.setString(1, student.getStu_name());
		statement.setString(2, student.getStu_id());
		statement.setString(3, student.getStu_phone());
		statement.setString(4, student.getStu_school());
		statement.setString(5, student.getStu_imageurl());
		statement.setInt(6, student.getAid());
		int result = statement.executeUpdate();
		return result;
	}
	
}
