package com.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rohit","root","root");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from employee");

            while(rs.next())
            {
                System.out.print(rs.getInt("Emp_Id")+"\t");
                System.out.print(rs.getString("Emp_Name")+"\t");
                System.out.print(rs.getString("Position")+"   ");
                System.out.print(rs.getInt("Age")+"\t");
                System.out.println(rs.getInt("Salary"));
            }


        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
