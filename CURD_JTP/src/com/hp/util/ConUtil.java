package com.hp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConUtil {

	public static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	public static final String URL      = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USERNAME = "system";
	public static final String PASSWORD = "tiger";
	
	
	public  Connection getConnection(){
		Connection con = null;
		
		try{
			Class.forName(DRIVER_CLASS);
			
			try{
				con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
			catch(SQLException se){
				System.out.println("failed to create database");
			}
		}
		catch(ClassNotFoundException cnf){
			System.out.println("driver not found");
		}
		return con;
	}
}
