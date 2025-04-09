package util;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection(String s) {
    	
        Connection c=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection(s);
        } 
        
        
        catch(Exception e) {
        	System.out.print(e.getMessage());
        }
        return c;
    }
}
