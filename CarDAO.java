package com.car;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CarDAO   {
	
	public static String save(Car c) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_data", "user_name", "password");
			String query="insert into car ( name, colour, number)"+"values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, c.getCarName());
			statement.setString(2, c.getCarColour());
			statement.setString(3, c.getCarNumber());
			
			int execute = statement.executeUpdate();
			connection.close();
			return "no of rows added : "+execute;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	public Car getDataById(int id) {
		try {
			Car car=new Car();
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user_data";
			String user = "user_name";
			String password = "password";
			Connection connection = DriverManager.getConnection(url, user, password);
			String Query = "select * from car where id=?";
			PreparedStatement ps = connection.prepareStatement(Query);
			ps.setInt(1, id);
			
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				car.setId(resultSet.getInt(1));
				car.setCarName(resultSet.getString(2));
				car.setCarColour(resultSet.getString(3));
				car.setCarNumber(resultSet.getString(3));
				
			}
			connection.close();
			return car;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
