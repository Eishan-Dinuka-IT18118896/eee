package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DBConnect;

public final class Customerloginimplent {

	private static boolean isTrue;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validate(String userName, String password) {
			
			try { 
			    con = DBConnect.getConnection();
			    stmt = con.createStatement();
			    String sql = "select * from customer where username='"+userName+"' and password='"+password+"'";	    
			     rs = stmt.executeQuery(sql);
			    
			    
			    if (isTrue) 
			    {
			    		isTrue = true;
			    }
			    else if (!isTrue) 
			    {
			    	isTrue = false;
			    }
			    
			}
			catch(Exception e) {
			    e.printStackTrace();
			}
			
			return isTrue;
			
	}

}
