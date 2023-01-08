package com.example.supplerchain;

import java.sql.ResultSet;

public class Login {


    public boolean customerLogin(String email, String password) {
        String query = String.format("select * from customer where email = '%s' and password = '%s' ", email, password);
        try {      //here is a block of code..
            DataBaseConnection dbcon = new DataBaseConnection(); // object of DataBaseConnection class is created...
            ResultSet rs = dbcon.getQueryTable(query);// rs is a ref variable of Resultset data type..
                                                     // dbcon -->> object of DataBaseConnection class..
                                                    // getQuerryTable is method ,we hv created in DataBaseConnection class..we r calling wid object of d same class..

            if (rs != null && rs.next()) {
                return true;
            }
        } catch (Exception e) {        //exception is occured & e is a ref variable name for that perticular exception..
            e.printStackTrace();       //it is d method of throwable class used to handle the exceptions..
                                      // it prints the throwable which may b d exception..
                                      // along with other details like..line number & class name...
        }
        return false;
    }

    public static void main(String[] args) {
        Login login = new Login(); // object of Login class..
        System.out.println(login.customerLogin("savantanjali0@gmail.com", "Savant@123"));
    }
}
