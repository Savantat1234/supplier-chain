package com.example.supplerchain;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.ResultSet;

public class Login {

private byte[] getSHA(String input) {   //SHA: secure hashing algorithm..
    try {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");// NAME of algo that should b correct only
        return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));// convert this"input into stream of bytes,,with charset utf..8
        //digest=== run d algo & return a strem of bytes which will b encoded..
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
private String getEncriptedPassword (String password){
    String encriptedPassword = "";
    try {
        BigInteger number = new BigInteger(1,getSHA(password));
        StringBuilder hexString = new StringBuilder(number.toString(16));
        return hexString.toString();

    }
    catch (Exception e) {
        e.printStackTrace();
    }
    return encriptedPassword;
    }



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

   // public static void main(String[] args) {
     //   Login login = new Login(); // object of Login class..
     //   System.out.println(login.customerLogin("savantanjali0@gmail.com", "Savant@123"));
//    }
   public static void main(String[] args) {
       Login login = new Login();
      System.out.println(login.getEncriptedPassword("Savant@123"));

   }
}
