package laundryshop;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import laundryshop.Home;

public class Laundry_ShopGUI 
{
  
   public Connection myConnection=null;
       public Statement myStatement=null;
       public ResultSet myResult=null;
    
       public static void main(String[] args) 
    {    
        new Home();
    }
    

    
}