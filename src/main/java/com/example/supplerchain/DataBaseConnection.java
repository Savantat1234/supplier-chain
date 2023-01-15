package com.example.supplerchain;
import java.sql.*;
public class DataBaseConnection {
    private static final String databaseeeURL = "jdbc:mysql://localhost:3306/supplier_chain_dec27";
    private static final String userName = "root";
    private static final String password = "--Anjali@123";
    public Statement getStatement(){

        Statement statement = null;
     Connection conn;
try{
conn = DriverManager.getConnection(databaseeeURL,userName,password);
statement = conn.createStatement();
}
catch(Exception e){
e.printStackTrace();
        }
return statement;
    }
    public ResultSet getQueryTable(String query){
        Statement statement = getStatement();
        try{
            return statement.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public int executeUpdateQuery(String query){
        Statement statement = getStatement();
        try{
            return statement.executeUpdate(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }


    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        ResultSet rs = dataBaseConnection.getQueryTable("select email,first_name from customer");
        try{
            while(rs.next())  {
                System.out.println(rs.getString("email") + " " + rs.getString("first_name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
         }
}
