package util;

import java.io.*;
import java.util.*;

public class PropertyUtil {
    public static String getPropertyString(String f) {
        String s="";
        
        try {
            Properties p=new Properties();
            FileInputStream in=new FileInputStream(f);
            p.load(in);
            
            String h=p.getProperty("hostname");
            String db=p.getProperty("dbname");
            String u=p.getProperty("username");
            String pw=p.getProperty("password");
            String pt=p.getProperty("port");
            
            s="jdbc:mysql://"+h+":"+pt+"/"+db+"?user="+u+"&password="+pw;
        } 
        catch(Exception e) {
        	System.out.print(e.getMessage());
        }
        return s;
    }
}
